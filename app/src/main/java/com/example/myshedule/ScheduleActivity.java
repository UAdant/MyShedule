package com.example.myshedule;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ScheduleActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ScheduleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        recyclerView = findViewById(R.id.recyclerView); // Получаем ссылку на RecyclerView
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        // Создаем экземпляр адаптера и передаем ему контекст и список данных
        adapter = new ScheduleAdapter(this, getScheduleEntries());

        // Устанавливаем адаптер для RecyclerView
        recyclerView.setAdapter(adapter);

        ImageButton addButton = findViewById(R.id.bthAddEvent);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openAddScheduleDialog();
            }
        });

        ImageButton openActivityMenu = findViewById(R.id.openAcivityMenuMain);

        openActivityMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish(); // Close ScheduleActivity and return to MainActivity
            }
        });
    }

    // Метод для получения списка данных расписания
    private List<ScheduleEntry> getScheduleEntries() {
        // В данном методе вы можете получить данные из вашей базы данных или другого источника данных
        // Здесь просто возвращается пустой список для примера
        return new ArrayList<>();
    }

    public void openAddScheduleDialog() {
        AddScheduleDialog addScheduleDialog = new AddScheduleDialog();
        addScheduleDialog.setOnAddButtonClickListener(new AddScheduleDialog.OnAddButtonClickListener() {
            @Override
            public void onAddButtonClick(String subject, String type, String date) {
                applyTexts(subject, type, date);
            }
        });
        addScheduleDialog.show(getSupportFragmentManager(), "add schedule dialog");
    }

    public void applyTexts(String subject, String type, String date) {
        DatabaseHelper dbHelper = new DatabaseHelper(this);
        ScheduleEntry scheduleEntry = new ScheduleEntry(subject, type, date, false);
        dbHelper.addScheduleEntry(scheduleEntry);
        Toast.makeText(this, "Event added successfully", Toast.LENGTH_SHORT).show();
    }
}

