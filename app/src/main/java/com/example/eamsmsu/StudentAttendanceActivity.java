package com.example.eamsmsu;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultLauncher;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eamsmsu.api.PostTask;
import com.example.eamsmsu.calback.PostCallback;
import com.example.eamsmsu.model.Event;
import com.example.eamsmsu.model.EventAttendance;
import com.example.eamsmsu.model.Student;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.journeyapps.barcodescanner.ScanContract;
import com.journeyapps.barcodescanner.ScanOptions;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class StudentAttendanceActivity extends AppCompatActivity implements PostCallback {

    private RecyclerView rvStudentAttendance;
    private FloatingActionButton fabScan;
    private TextView tvEventName, tvVenue, tvDate, tvCourse;
    private TextView tvStudentName, tvStudentId, tvStudentCourse, tvStudentYearSection;
    private StudentAttendanceAdapter studentAttendanceAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_student_attendance);



        tvDate = findViewById(R.id.textView2);
        tvEventName = findViewById(R.id.tvTitle);
        tvVenue = findViewById(R.id.textView);
        tvCourse = findViewById(R.id.tvDate);

        rvStudentAttendance = findViewById(R.id.rvStudentAttendance);
        refreshAdapter();


        fabScan = findViewById(R.id.fabScan);
        fabScan.setOnClickListener(v -> {
            ScanOptions integrator = new ScanOptions();
            integrator.setPrompt("Scan a QR Code");
            integrator.setOrientationLocked(false);
            barcodeLauncher.launch(integrator);
        });

        if (getIntent().hasExtra("event")){
            Event event = (Event) getIntent().getParcelableExtra("event");
            tvEventName.setText(event.getTitleEvent());
            tvVenue.setText(event.getVenue());
            tvDate.setText(event.getDateTimeEvent());
            tvCourse.setText(event.getProgram());
            if (event.getProgramId().equals("All")){
                tvCourse.setText("All Programs");
            }else{
                tvCourse.setText(event.getSemester()+" - " + event.getProgram());
            }
        }
    }

    private final ActivityResultLauncher<ScanOptions> barcodeLauncher = this.registerForActivityResult(new ScanContract(), result -> {
        if (result.getContents() == null) {
            return;
        }
        String studentId = result.getContents().toString();
        Log.d("StudentAttendanceActivity", "Student ID: " + studentId);
        if (studentId != null) {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("student_id", studentId);
                new PostTask(this, this, "Error", "get-student-info.php").execute(jsonObject);
            } catch (Exception e) {
                Log.e("StudentAttendanceActivity", "Error creating JSON object", e);
            }
        }
    });

    @Override
    public void onPostSuccess(String responseData) {

        Gson gson = new Gson();
        Student student = gson.fromJson(responseData, Student.class);


        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(this);

        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_box, null);
        tvStudentName = dialogView.findViewById(R.id.tvStudentName);
        tvStudentId = dialogView.findViewById(R.id.tvStudentID);
        tvStudentCourse = dialogView.findViewById(R.id.tvCourse);
        tvStudentYearSection = dialogView.findViewById(R.id.tvYearSection);

        tvStudentId.setText(student.getStudentIdNumber());
        tvStudentCourse.setText(student.getProgram());
        tvStudentYearSection.setText(student.getYearLevel() + " - " + student.getSection());
        tvStudentName.setText(student.getFirstName() + " " + student.getLastName());

        alertDialogBuilder.setTitle("Student Information")
                .setView(dialogView)
                .setNegativeButton("Time In", (dialog, which) -> {
                    setTimeInOut(student.getStudentId(), "Time In");
                })
                .setPositiveButton("Time Out", (dialog, which) -> {

                    setTimeInOut(student.getStudentId(), "Time Out");
                });
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }

    @Override
    public void onPostError(String errorMessage) {

    }

    private void setTimeInOut(String studentId, String type) {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("student_id", studentId);
            jsonObject.put("type", type);
            jsonObject.put("event_id", ((Event) getIntent().getParcelableExtra("event")).getEventId());
            new PostTask(this, new PostCallback() {
                @Override
                public void onPostSuccess(String responseData) {
                    Toast.makeText(StudentAttendanceActivity.this, responseData, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void onPostError(String errorMessage) {
                    Toast.makeText(StudentAttendanceActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }, "Error", "save-attendance.php").execute(jsonObject);
        } catch (Exception e) {
            Log.e("StudentAttendanceActivity", "Error creating JSON object", e);
        }
        refreshAdapter();
    }

    private void refreshAdapter(){

        try {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("event_id", ((Event) getIntent().getParcelableExtra("event")).getEventId());
            new PostTask(this, new PostCallback() {
                @Override
                public void onPostSuccess(String responseData) {
                    Gson gson = new Gson();
                    Type studentListType = new TypeToken<List<EventAttendance>>(){}.getType();
                    List<EventAttendance> studentList = gson.fromJson(responseData, studentListType);
                    studentAttendanceAdapter = new StudentAttendanceAdapter(StudentAttendanceActivity.this, studentList);
                    rvStudentAttendance.setAdapter(studentAttendanceAdapter);
                    rvStudentAttendance.setLayoutManager(new LinearLayoutManager(StudentAttendanceActivity.this));
                    Log.d("StudentAttendanceActivity", "Student List: " + studentList);
                }

                @Override
                public void onPostError(String errorMessage) {
                    Toast.makeText(StudentAttendanceActivity.this, errorMessage, Toast.LENGTH_SHORT).show();
                }
            }, "Error", "fetch-attendance.php").execute(jsonObject);
        } catch (Exception e) {
            Log.e("StudentAttendanceActivity", "Error creating JSON object", e);
        }
    }
}

