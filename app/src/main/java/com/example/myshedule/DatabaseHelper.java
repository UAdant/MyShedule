package com.example.myshedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import java.util.ArrayList;
import java.util.List;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "lecture_database";
    private static final String TABLE_NAME = "lectures";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SUBJECT = "subject";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_TYPE = "type";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SUBJECT + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_TYPE + " TEXT"
                + ")";
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public void addLecture(CardData lecture) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBJECT, lecture.getSubject());
        values.put(COLUMN_DATE, lecture.getDate());
        values.put(COLUMN_TYPE, lecture.getType());
        db.insert(TABLE_NAME, null, values);
        db.close();
    }


    public List<CardData> getAllLectures() {
        List<CardData> lectureList = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_NAME;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                // Викликаємо конструктор з усіма параметрами
                CardData lecture = new CardData(cursor.getString(2), null, cursor.getString(1), cursor.getString(3));
                lectureList.add(lecture);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return lectureList;
    }
}
