package com.example.eamsmsu;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import com.example.eamsmsu.api.PostTask;
import com.example.eamsmsu.calback.PostCallback;
import com.example.eamsmsu.model.Event;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class EventActivity extends AppCompatActivity implements PostCallback {

    private RecyclerView rvEvent;
    private FloatingActionButton fabAddEvent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_event);
        fabAddEvent = findViewById(R.id.fabAddEvent);
        try {

            JSONObject jsonObject = new JSONObject();
            jsonObject.put("officer_id", SessionManager.getInstance(this).getOfficer().getOfficerId());

            new PostTask(this, this, "error", "fetch-event.php").execute(jsonObject);

        }catch (Exception e){
            e.printStackTrace();
        }

        fabAddEvent.setOnClickListener(v -> {

            new MaterialAlertDialogBuilder(this)
                    .setTitle("Logout Confirmation")
                    .setMessage("Are you sure you want to log out?")
                    .setPositiveButton("Yes", (dialog, which) -> {
                        SessionManager.getInstance(this).logoutUser();
                        startActivity(new Intent(this, MainActivity.class));
                        finish();
                    })
                    .setNegativeButton("No", (dialog, which) -> {
                        dialog.dismiss();
                    })
                    .show();
        });

    }

    @Override
    public void onPostSuccess(String responseData) {
        Gson gson = new Gson();
        Type eventType = new TypeToken<List<Event>>() {}.getType();
        List<Event> eventList = gson.fromJson(responseData, eventType);
        rvEvent = findViewById(R.id.rvEvents);
        rvEvent.setAdapter(new EventAdapter(this, eventList));

    }
    @Override
    public void onPostError(String errorMessage) {

    }
}