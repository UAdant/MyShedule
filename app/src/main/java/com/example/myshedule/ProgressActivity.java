package com.example.myshedule;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class ProgressActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_progress);

        // Находим кнопку по идентификаторуп
        ImageButton backButton = findViewById(R.id.button11);

        // Устанавливаем обработчик нажатия на кнопку
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем интент для открытия MainActivity
                Intent intent = new Intent(ProgressActivity.this, MainActivity.class);
                // Запускаем MainActivity
                startActivity(intent);
            }
        });
    }
}
