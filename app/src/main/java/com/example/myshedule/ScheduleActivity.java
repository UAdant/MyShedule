package com.example.myshedule;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Button addButton = findViewById(R.id.bthAddEvent);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddScheduleDialog();
            }
        });

        Button openActivityMenu = findViewById(R.id.openAcivityMenuMain);

        openActivityMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    public void openAddScheduleDialog() {
        AddScheduleDialog addScheduleDialog = new AddScheduleDialog();
        addScheduleDialog.show(getSupportFragmentManager(), "add schedule dialog");
    }

    public void applyTexts(String subject, String type, String date) {
        if (isValidDate(date)) {
            // Додавання даних до бази даних
            DatabaseHelper dbHelper = new DatabaseHelper(this);
            ScheduleEntry scheduleEntry = new ScheduleEntry(subject, type, date, false); // Передаємо значення completed як false, оскільки запис ще не виконаний
            long insertedRowId = dbHelper.addScheduleEntry(scheduleEntry);
            dbHelper.close(); // Закриття з'єднання з базою даних

            if (insertedRowId != -1) {
                // Дані успішно збережено
                Toast.makeText(this, "Дані успішно збережено", Toast.LENGTH_SHORT).show();
            } else {
                // Помилка збереження даних
                Toast.makeText(this, "Помилка збереження даних", Toast.LENGTH_SHORT).show();
            }
        } else {
            // Повідомлення про неправильний формат дати
            Toast.makeText(this, "Неправильний формат дати. Введіть дату у форматі 'dd.mm.yyyy'", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean isValidDate(String date) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy", Locale.getDefault());
        sdf.setLenient(false);
        try {
            sdf.parse(date);
            return true;
        } catch (ParseException e) {
            return false;
        }
    }
}
