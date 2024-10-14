package com.example.eamsmsu;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.gson.Gson;
import com.example.eamsmsu.model.Officer;

public class SessionManager {

    private static final String PREF_NAME = "UserSession";
    private static final String KEY_IS_LOGGED_IN = "isLoggedIn";
    private static final String KEY_OFFICER = "officer";

    private static SessionManager instance;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Gson gson;


    private SessionManager(Context context) {
        sharedPreferences = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
    }

    public static synchronized SessionManager getInstance(Context context) {
        if (instance == null) {
            instance = new SessionManager(context.getApplicationContext());
        }
        return instance;
    }

    public void createLoginSession(Officer officer) {
        editor.putBoolean(KEY_IS_LOGGED_IN, true);
        String officerJson = gson.toJson(officer);
        editor.putString(KEY_OFFICER, officerJson);
        editor.apply();
    }

    public boolean isLoggedIn() {
        return sharedPreferences.getBoolean(KEY_IS_LOGGED_IN, false);
    }

    public Officer getOfficer() {
        String officerJson = sharedPreferences.getString(KEY_OFFICER, null);
        return gson.fromJson(officerJson, Officer.class);
    }

    public void logoutUser() {
        editor.clear();
        editor.apply();
    }
}
