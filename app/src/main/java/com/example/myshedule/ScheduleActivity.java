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

public class ScheduleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_schedule);

        Button buttonAdd = findViewById(R.id.buttonAdd);

        Button openActivityMenu = findViewById(R.id.openAcivityMenuMain);
        buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showAddLectureDialog();
            }
        });




        openActivityMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ScheduleActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showAddLectureDialog() {
        AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(this);
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_add_lecture, null);
        dialogBuilder.setView(dialogView);

        final EditText editTextSubject = dialogView.findViewById(R.id.editTextSubject);
        final EditText editTextDate = dialogView.findViewById(R.id.editTextDate);
        final EditText editTextType = dialogView.findViewById(R.id.editTextType);

        dialogBuilder.setTitle("Add Lecture");
        dialogBuilder.setPositiveButton("Add", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String subject = editTextSubject.getText().toString();
                String date = editTextDate.getText().toString();
                String type = editTextType.getText().toString();

                // Додайте код для додавання лекції до бази даних з введеними даними

                dialog.dismiss();
            }
        });

        dialogBuilder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        AlertDialog alertDialog = dialogBuilder.create();
        alertDialog.show();
    }
}