package com.project.lab4;

import android.provider.BaseColumns;

public class StudentInfoContact {
    private StudentInfoContact(){}

    public static class Students implements BaseColumns {
        public static final String TABLE_NAME = "student_info";
        public static final String STUDENT_ID = "student_id";
        public static final String STUDENT_NAME = "student_name";
        public static final String STUDENT_EMAIL = "student_email";


    }
}
