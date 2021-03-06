package com.project.lab4;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ViewAllFragment extends Fragment {

    private TextView tv_all_student;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_view_all, container,false);

        tv_all_student = view.findViewById(R.id.tv_all_student_info);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        getAllStudentInfo();
    }

    private void getAllStudentInfo() {
        // ToDo 4: Retrieve the student info saved from the database
        StudentDBHelper dbHelper = new StudentDBHelper(getActivity());
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query(StudentInfoContact.Students.TABLE_NAME, null, null, null, null, null, StudentInfoContact.Students.STUDENT_ID);
        String result = "";
        while (cursor.moveToNext()) {
            String id = cursor.getString(cursor.getColumnIndex(StudentInfoContact.Students.STUDENT_ID));
            String name = cursor.getString(cursor.getColumnIndex(StudentInfoContact.Students.STUDENT_NAME));
            String email = cursor.getString(cursor.getColumnIndex(StudentInfoContact.Students.STUDENT_EMAIL));

            result = result + "\n\nID: " + id + "\nNAME: " + name + "\nEMAIL: " +  email;
        }
        db.close();
        if (result.isEmpty()) {
            result = "No records found";
        }
        tv_all_student.setText(result);
    }
}