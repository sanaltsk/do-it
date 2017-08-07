package com.inspyreit.kui.doit.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.inspyreit.kui.doit.ToDoItem;

import java.util.ArrayList;
import java.util.Date;

/**
 * Created by sanal on 8/6/17.
 */

public class DBManager {

    private DatabaseHelper dbHelper;

    private Context context;

    private SQLiteDatabase database;

    public DBManager(Context c) {
        context = c;
    }

    public DBManager open() throws SQLException {
        dbHelper = new DatabaseHelper(context);
        database = dbHelper.getWritableDatabase();
        return this;
    }

    public void close() {
        dbHelper.close();
    }

    public void insert(ToDoItem task) {
        open();
        ContentValues contentValue = new ContentValues();
        contentValue.put(DatabaseHelper.TITLE, task.getTaskName());
        if(task.getDueDate()!=null) {
            contentValue.put(DatabaseHelper.DUEDATE, task.getDueDate().getTime());
        }
        if(task.isComplete()) {
            contentValue.put(DatabaseHelper.COMPLETE,Boolean.TRUE);
        } else {
            contentValue.put(DatabaseHelper.COMPLETE,Boolean.FALSE);
        }
        if(task.isStared()) {
            contentValue.put(DatabaseHelper.STARED,Boolean.TRUE);
        } else {
            contentValue.put(DatabaseHelper.STARED,Boolean.FALSE);
        }
        database.insert(DatabaseHelper.TABLE_NAME, null, contentValue);
        close();
    }

    public Cursor fetch() {
        String[] columns = new String[] { DatabaseHelper._ID, DatabaseHelper.TITLE, DatabaseHelper.DUEDATE,
        DatabaseHelper.COMPLETE, DatabaseHelper.STARED};
        Cursor cursor = database.query(DatabaseHelper.TABLE_NAME, columns, null, null, null, null, null);
        if (cursor != null) {
            cursor.moveToFirst();
        }
        return cursor;
    }

    public int update(String task_name, ToDoItem task) {
        open();
        ContentValues contentValues = new ContentValues();
        contentValues.put(DatabaseHelper.TITLE, task.getTaskName());
        if(task.getDueDate()!=null){
            contentValues.put(DatabaseHelper.DUEDATE, task.getDueDate().getTime());
        }
        contentValues.put(DatabaseHelper.COMPLETE, task.isComplete());
        contentValues.put(DatabaseHelper.STARED, task.isStared());
        int i = database.update(DatabaseHelper.TABLE_NAME, contentValues, DatabaseHelper.TITLE + " = '" + task_name + "'", null);
        close();
        return i;
    }

    public void delete(String title) {
        open();
        database.delete(DatabaseHelper.TABLE_NAME, DatabaseHelper.TITLE + "='" + title+"'", null);
        close();
    }

    public ArrayList<ToDoItem> getAllTasks() {
        open();
        ArrayList<ToDoItem> tasks = new ArrayList<>();
        Cursor cursor = fetch();
        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String title = cursor.getString(cursor.getColumnIndexOrThrow(DatabaseHelper.TITLE));
                Long duedate = cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper.DUEDATE));
                Boolean complete = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.COMPLETE)) == 1;
                Boolean starred = cursor.getInt(cursor.getColumnIndexOrThrow(DatabaseHelper.STARED)) == 1;
                ToDoItem task = new ToDoItem(title);
                if(duedate!=0) {
                    task.setDueDate(new Date(duedate));
                }
                task.set_id(cursor.getLong(cursor.getColumnIndexOrThrow(DatabaseHelper._ID)));
                task.setTaskName(title);
                task.setComplete(complete);
                task.setStared(starred);
                tasks.add(task);
                cursor.moveToNext();
            }
        }
        close();
        return tasks;

    }
}
