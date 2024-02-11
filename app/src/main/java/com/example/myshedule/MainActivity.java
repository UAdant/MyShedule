package com.example.myshedule;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Обработчик нажатия кнопки для открытия Activity Schedule
        ImageButton openScheduleActivityButton = findViewById(R.id.openAcivitySchedule);
        openScheduleActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ScheduleActivity.class);
                startActivity(intent);
            }
        });

        // Обработчик нажатия кнопки для открытия Activity UpcomingExams
        ImageButton openUpcomingExamsActivityButton = findViewById(R.id.openUpcomingExamsActivity);
        openUpcomingExamsActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, UpcomingExamsActivity.class);
                startActivity(intent);
            }
        });

        // Обработчик нажатия кнопки для открытия Activity Progress
        ImageButton openProgressActivityButton = findViewById(R.id.openProgressActivity);
        openProgressActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProgressActivity.class);
                startActivity(intent);
            }
        });

        // Обработчик нажатия кнопки для открытия Activity Grades
        ImageButton openGradesActivityButton = findViewById(R.id.openGradesActivity);
        openGradesActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GradesActivity.class);
                startActivity(intent);
            }
        });


    }
}
