package com.anddev.edu_room.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.anddev.edu_room.R;

public class ProfessionActivity extends AppCompatActivity {

    ImageButton stud, teach;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profession);

        stud = findViewById(R.id.student_login);
        teach = findViewById(R.id.teacher_login);

        stud.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity();
            }
        });

        teach.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                LoginActivity();
            }
        });


    }


    private void LoginActivity(){
        startActivity(new Intent(ProfessionActivity.this, LoginActivity.class));
    }

}