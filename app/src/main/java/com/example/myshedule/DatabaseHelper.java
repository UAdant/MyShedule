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
    private static final String DATABASE_NAME = "schedule_database";
    private static final String TABLE_SCHEDULE = "schedule";
    private static final String TABLE_EXAMS = "exams";
    private static final String TABLE_EXAM_GRADES = "exam_grades";
    private static final String COLUMN_ID = "id";
    private static final String COLUMN_SUBJECT = "subject";
    private static final String COLUMN_TYPE = "type";
    private static final String COLUMN_DATE = "date";
    private static final String COLUMN_COMPLETED = "completed";
    private static final String COLUMN_TIME = "time";
    private static final String COLUMN_GRADE = "grade";

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

        String CREATE_EXAMS_TABLE = "CREATE TABLE " + TABLE_EXAMS + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SUBJECT + " TEXT,"
                + COLUMN_DATE + " TEXT,"
                + COLUMN_TIME + " TEXT,"
                + COLUMN_COMPLETED + " INTEGER"
                + ")";
        db.execSQL(CREATE_EXAMS_TABLE);

        String CREATE_EXAM_GRADES_TABLE = "CREATE TABLE " + TABLE_EXAM_GRADES + "("
                + COLUMN_ID + " INTEGER PRIMARY KEY,"
                + COLUMN_SUBJECT + " TEXT,"
                + COLUMN_GRADE + " INTEGER"
                + ")";
        db.execSQL(CREATE_EXAM_GRADES_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SCHEDULE);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAMS);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_EXAM_GRADES);
        onCreate(db);
    }

    public void addScheduleEntry(ScheduleEntry scheduleEntry) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBJECT, scheduleEntry.getSubject());
        values.put(COLUMN_TYPE, scheduleEntry.getType());
        values.put(COLUMN_DATE, scheduleEntry.getDate());
        values.put(COLUMN_COMPLETED, scheduleEntry.isCompleted() ? 1 : 0);
        db.insert(TABLE_SCHEDULE, null, values);
        db.close();
    }

    public void addExam(Exam exam) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBJECT, exam.getSubject());
        values.put(COLUMN_DATE, exam.getDate());
        values.put(COLUMN_TIME, exam.getTime());
        values.put(COLUMN_COMPLETED, exam.isCompleted() ? 1 : 0);
        db.insert(TABLE_EXAMS, null, values);
        db.close();
    }

    public void addExamGrade(ExamGrade examGrade) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SUBJECT, examGrade.getSubject());
        values.put(COLUMN_GRADE, examGrade.getGrade());
        db.insert(TABLE_EXAM_GRADES, null, values);
        db.close();
    }

    public List<ScheduleEntry> getAllScheduleEntries() {
        List<ScheduleEntry> scheduleEntries = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_SCHEDULE;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ScheduleEntry scheduleEntry = new ScheduleEntry();
                scheduleEntry.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                scheduleEntry.setSubject(cursor.getString(cursor.getColumnIndex(COLUMN_SUBJECT)));
                scheduleEntry.setType(cursor.getString(cursor.getColumnIndex(COLUMN_TYPE)));
                scheduleEntry.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                scheduleEntry.setCompleted(cursor.getInt(cursor.getColumnIndex(COLUMN_COMPLETED)) == 1);
                scheduleEntries.add(scheduleEntry);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return scheduleEntries;
    }

    public List<Exam> getAllExams() {
        List<Exam> exams = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EXAMS;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                Exam exam = new Exam();
                exam.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                exam.setSubject(cursor.getString(cursor.getColumnIndex(COLUMN_SUBJECT)));
                exam.setDate(cursor.getString(cursor.getColumnIndex(COLUMN_DATE)));
                exam.setTime(cursor.getString(cursor.getColumnIndex(COLUMN_TIME)));
                exam.setCompleted(cursor.getInt(cursor.getColumnIndex(COLUMN_COMPLETED)) == 1);
                exams.add(exam);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return exams;
    }

    public List<ExamGrade> getAllExamGrades() {
        List<ExamGrade> examGrades = new ArrayList<>();
        String selectQuery = "SELECT * FROM " + TABLE_EXAM_GRADES;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor.moveToFirst()) {
            do {
                ExamGrade examGrade = new ExamGrade();
                examGrade.setId(cursor.getInt(cursor.getColumnIndex(COLUMN_ID)));
                examGrade.setSubject(cursor.getString(cursor.getColumnIndex(COLUMN_SUBJECT)));
                examGrade.setGrade(cursor.getInt(cursor.getColumnIndex(COLUMN_GRADE)));
                examGrades.add(examGrade);
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return examGrades;
    }
}
