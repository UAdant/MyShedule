package com.example.myshedule;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UpcomingExamsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_upcoming_exams);

        // Находим кнопку по идентификатору
        ImageButton backButton = findViewById(R.id.button9);

        // Устанавливаем обработчик нажатия на кнопку
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем интент для открытия MainActivity
                Intent intent = new Intent(UpcomingExamsActivity.this, MainActivity.class);
                // Запускаем MainActivity
                startActivity(intent);
            }
        });
    }
}
