package com.example.newfakebook.database;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import static androidx.constraintlayout.widget.Constraints.TAG;

public class MyDtabase extends SQLiteOpenHelper {

    // Database Name and Version
    public static final String DB_NAME = "my_database.db";
    public static final int DB_VERSION = 1;

    // Student table and Columns
    public static final String STUDENT_TABLE = "student";

    public static final String STUDENT_NAME = "name";
    public static final String STUDENT_AGE = "age";
    public static final String STUDENT_MARK = "mark";

    // Search a one student from table, student name
    public static String SEARCH_NAME = "name";

    // Create student table
    public static final String CREATE_TABLE = "CREATE TABLE "+STUDENT_TABLE+"("
            +STUDENT_NAME+" VARCHAR(120),"
            +STUDENT_AGE+" INTEGER,"
            +STUDENT_MARK+" INTEGER );";

    // SQL quaries
    public static final String DROP_TABLE = "DROP TABLE IF EXISTS "+STUDENT_TABLE;
    public static final String SELECT_STUDENTS = "SELECT * FROM "+STUDENT_TABLE;

    public MyDtabase(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
        Log.d("onCreate", "Database successfully created");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE);
        onCreate(db);
    }

    public String insertStudent(String name, int age, int mark){
        String status = "fail";
        try{
            status="pass";
            SQLiteDatabase db = getWritableDatabase();
            db.execSQL("INSERT INTO "+STUDENT_TABLE+" VALUES ('"+name+"' , "+age+" , "+mark+" );");
            db.close();
        }
        catch (Exception e){}

        return status;
    }

    public Cursor getStudent(String name){
        SEARCH_NAME = name;
        SQLiteDatabase db = getWritableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM student WHERE name='"+name+"'", null);

        return cursor;

    }


    public SQLiteDatabase getDb(){
        SQLiteDatabase db2 = getWritableDatabase();
        return db2;
    }

    public Cursor getAllStudents() {
        SQLiteDatabase db = getWritableDatabase();
        //SQL Result taken to cursor
        Cursor cursor = db.rawQuery(SELECT_STUDENTS, null);
        return cursor;
    }
}
