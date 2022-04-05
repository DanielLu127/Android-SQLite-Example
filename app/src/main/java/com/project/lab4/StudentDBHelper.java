package com.project.lab4;

import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.security.cert.CRLException;

public class StudentDBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "student.db";
    private static final int DATABASE_VERSION = 1;
    private static final String CRATE_TABLE = " CREATE TABLE " +
            StudentInfoContact.Students.TABLE_NAME + "(" +
            StudentInfoContact.Students._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
            StudentInfoContact.Students.STUDENT_NAME + " TEXT NOT NULL, " +
            StudentInfoContact.Students.STUDENT_ID + " TEXT NOT NULL, " +
            StudentInfoContact.Students.STUDENT_EMAIL + " TEXT" + ")";

    private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + StudentInfoContact.Students.TABLE_NAME;

    public StudentDBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        System.out.println(CRATE_TABLE);
        // create table
        db.execSQL(CRATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }
}
