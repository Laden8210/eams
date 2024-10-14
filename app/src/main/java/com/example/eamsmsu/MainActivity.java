package com.example.eamsmsu;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.eamsmsu.api.PostTask;
import com.example.eamsmsu.calback.PostCallback;
import com.example.eamsmsu.model.Officer;
import com.google.android.material.textfield.TextInputLayout;
import com.google.gson.Gson;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity implements PostCallback {

    private Button btnLogin;
    private TextInputLayout tilUsername;
    private TextInputLayout tilPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        tilPassword = findViewById(R.id.tilPassword);
        tilUsername = findViewById(R.id.tilUsername);

        btnLogin = findViewById(R.id.btnLogin);

        if (SessionManager.getInstance(this).isLoggedIn()) {
            startActivity(new Intent(MainActivity.this, EventActivity.class));
            finish();
        }

        btnLogin.setOnClickListener(v -> {
            JSONObject jsonObject = new JSONObject();
            try {
                jsonObject.put("username", tilUsername.getEditText().getText().toString());
                jsonObject.put("password", tilPassword.getEditText().getText().toString());

                new PostTask(this, this, "dasd", "login.php").execute(jsonObject);
            } catch (Exception e) {
                e.printStackTrace();
            }

        });

    }

    @Override
    public void onPostSuccess(String responseData) {
        Gson gson = new Gson();
        Officer officer = gson.fromJson(responseData, Officer.class);
        SessionManager.getInstance(this).createLoginSession(officer);
        startActivity(new Intent(MainActivity.this, EventActivity.class));
        finish();
    }

    @Override
    public void onPostError(String errorMessage) {
        AlertDialog alertDialog = new AlertDialog.Builder(this)
                .setTitle("Error")
                .setMessage(errorMessage)
                .setPositiveButton("OK", (dialog, which) -> dialog.dismiss())
                .create();
        alertDialog.show();
    }
}