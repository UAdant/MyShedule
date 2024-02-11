package com.example.myshedule;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatDialogFragment;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Locale;

public class AddScheduleDialog extends AppCompatDialogFragment {
    private EditText editTextSubject;
    private EditText editTextType;
    private EditText editTextDate;
    private OnAddButtonClickListener addButtonClickListener;

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.add_dialog_schedule, null);

        builder.setView(view)
                .setTitle("Add Schedule Entry")
                .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        // Порожнє тіло, так як ми не робимо нічого при натисканні кнопки "Скасувати"
                    }
                })
                .setPositiveButton("Save", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String subject = editTextSubject.getText().toString();
                        String type = editTextType.getText().toString();
                        String date = editTextDate.getText().toString();

                        if (subject.isEmpty() || type.isEmpty() || date.isEmpty()) {
                            Toast.makeText(getContext(), "Будь ласка, заповніть всі поля", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (isValidDate(date)) {
                            if (addButtonClickListener != null) {
                                addButtonClickListener.onAddButtonClick(subject, type, date);
                            }

                            // Закриття клавіатури
                            InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
                            imm.hideSoftInputFromWindow(editTextDate.getWindowToken(), 0);
                        } else {
                            Toast.makeText(getContext(), "Неправильний формат дати. Введіть дату у форматі 'dd.mm.yyyy'", Toast.LENGTH_SHORT).show();
                        }
                    }
                });

        editTextSubject = view.findViewById(R.id.editTextText);
        editTextType = view.findViewById(R.id.editTextText2);
        editTextDate = view.findViewById(R.id.editTextText3);

        // Підказка для користувача
        editTextDate.setHint("dd.mm.yyyy");

        return builder.create();
    }

    public interface OnAddButtonClickListener {
        void onAddButtonClick(String subject, String type, String date);
    }

    public void setOnAddButtonClickListener(OnAddButtonClickListener listener) {
        this.addButtonClickListener = listener;
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


