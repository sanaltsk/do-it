package com.inspyreit.kui.doit.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by sanal on 8/6/17.
 */


public class DatabaseHelper extends SQLiteOpenHelper {

    // Table Name
    public static final String TABLE_NAME = "tasks";

    // Table columns
    public static final String _ID = "_id";
    public static final String TITLE = "title";
    public static final String DUEDATE = "duedate";
    public static final String COMPLETE = "complete";
    public static final String STARED = "stared";


    // Database Information
    static final String DB_NAME = "DOIT";

    // database version
    static final int DB_VERSION = 3;

    private static final String CREATE_TABLE = "create table " + TABLE_NAME + "(" + _ID
            + " INTEGER PRIMARY KEY AUTOINCREMENT, " + TITLE + " TEXT NOT NULL, " + DUEDATE
            + " LONG, " + COMPLETE + " BOOLEAN, " + STARED + " BOOLEAN );";

    public DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }
}
