package com.example.eamsmsu;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eamsmsu.api.PostTask;
import com.example.eamsmsu.calback.PostCallback;
import com.example.eamsmsu.model.EventAttendance;
import com.example.eamsmsu.model.Student;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.util.List;

public class StudentAttendanceAdapter extends RecyclerView.Adapter<StudentAttendanceAdapter.StudentAttendanceViewHolder> {

    private Context context;
    private List<EventAttendance> studentList;
    private TextView tvStudentName, tvStudentId, tvStudentCourse, tvStudentYearSection;
    public StudentAttendanceAdapter(Context context, List<EventAttendance> studentList) {
        this.context = context;
        this.studentList = studentList;
    }

    @NonNull
    @Override
    public StudentAttendanceAdapter.StudentAttendanceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_student, parent, false);
        return new StudentAttendanceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StudentAttendanceAdapter.StudentAttendanceViewHolder holder, int position) {
        EventAttendance student = studentList.get(position);
        holder.tvStudentName.setText(student.getStudFname() + " " + student.getStudLname());
        holder.tvStudentId.setText(student.getStudentId());
        holder.tvCourse.setText(student.getProgram() + " " + student.getYrlevel() + " " + student.getStudSection());
        holder.tvAttendanceDetails.setText(student.getAttendanceDetails());

        holder.cardView.setOnClickListener(e -> {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("student_id", student.getStudentId());
                new PostTask(context, new PostCallback() {
                    @Override
                    public void onPostSuccess(String responseData) {
                        Gson gson = new Gson();
                        Student student = gson.fromJson(responseData, Student.class);

                        MaterialAlertDialogBuilder alertDialogBuilder = new MaterialAlertDialogBuilder(context);


                        LayoutInflater inflater = LayoutInflater.from(context);
                        View dialogView = inflater.inflate(R.layout.dialog_box, null);


                        tvStudentName = dialogView.findViewById(R.id.tvStudentName);
                        tvStudentId = dialogView.findViewById(R.id.tvStudentID);
                        tvStudentCourse = dialogView.findViewById(R.id.tvCourse);
                        tvStudentYearSection = dialogView.findViewById(R.id.tvYearSection);


                        tvStudentId.setText(student.getStudentIdNumber());
                        tvStudentCourse.setText(student.getProgram());
                        tvStudentYearSection.setText(student.getYearLevel() + " - " + student.getSection());
                        tvStudentName.setText(student.getFirstName() + " " + student.getLastName());


                        alertDialogBuilder.setView(dialogView)
                                .setPositiveButton("Close", (dialog, which) -> {
                                    dialog.dismiss();
                                });

                        AlertDialog alertDialog = alertDialogBuilder.create();
                        alertDialog.show();
                    }

                    @Override
                    public void onPostError(String errorMessage) {

                    }
                }, "Error", "get-student-info.php").execute(jsonObject);
            } catch (Exception ex) {
                Log.e("StudentAttendanceActivity", "Error creating JSON object", ex);
            }
        });



    }

    @Override
    public int getItemCount() {
        return studentList.size();
    }

    public class StudentAttendanceViewHolder extends RecyclerView.ViewHolder {
        private TextView tvStudentName, tvStudentId, tvAttendanceDetails, tvCourse;
        private CardView cardView;
        public StudentAttendanceViewHolder(@NonNull View itemView) {
            super(itemView);
            tvStudentName = itemView.findViewById(R.id.tvTitle);
            tvStudentId = itemView.findViewById(R.id.tvStudentId);

            tvCourse = itemView.findViewById(R.id.tvCourse);
            tvAttendanceDetails = itemView.findViewById(R.id.tvAttendanceDetails);

            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
