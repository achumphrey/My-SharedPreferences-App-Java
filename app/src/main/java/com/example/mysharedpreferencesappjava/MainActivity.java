package com.example.mysharedpreferencesappjava;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    TextView name, email;

    private static final String MyPreference = "myPref";
    private static final String Name = "nameKey";
    private static final String Email = "emailKey";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        name = findViewById(R.id.edName);
        email = findViewById(R.id.edEmail);

        sharedPreferences = getSharedPreferences(MyPreference,
                Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name))
            name.setText(sharedPreferences.getString(Name, ""));

        if (sharedPreferences.contains(Email))
            email.setText(sharedPreferences.getString(Email, ""));
    }

    public void save(View view){
        String nm = name.getText().toString();
        String em = email.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, nm);
        editor.putString(Email, em);
        editor.apply();
    }

    public void get(View view){
        name = findViewById(R.id.edName);
        email = findViewById(R.id.edEmail);

        sharedPreferences = getSharedPreferences(MyPreference,
                Context.MODE_PRIVATE);

        if (sharedPreferences.contains(Name))
            name.setText(sharedPreferences.getString(Name, ""));

        if (sharedPreferences.contains(Email))
            email.setText(sharedPreferences.getString(Email, ""));
    }

    public void clear(View view){
        name = findViewById(R.id.edName);
        email = findViewById(R.id.edEmail);
        name.setText("");
        email.setText("");
    }
}
