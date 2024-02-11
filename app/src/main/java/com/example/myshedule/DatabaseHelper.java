package com.example.myshedule;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    private static final String DATABASE_NAME = "schedule_database";
    private static final String TABLE_SCHEDULE = "schedule";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SUBJECT = "subject";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_COMPLETED = "completed";

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_SCHEDULE_TABLE = "CREATE TABLE " + TABLE_SCHEDULE + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SUBJECT + " TEXT,"
                + COLUMN_TYPE + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_COMPLETED + " INTEGER"
                + ")";
        db.execSQL(CREATE_SCHEDULE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
        onCreate(db);
    }

    public void addScheduleEntry(ScheduleEntry entry) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBJECT, entry.getSubject());
        values.put(COLUMN_TYPE, entry.getType());
        values.put(COLUMN_DATE, entry.getDate());
        values.put(COLUMN_COMPLETED, entry.isCompleted() ? 1 : 0);

        db.insert(TABLE_SCHEDULE, null, values);
        db.close();
    }
}
