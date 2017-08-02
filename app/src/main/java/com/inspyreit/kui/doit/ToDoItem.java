package com.inspyreit.kui.doit;

import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by sanal on 8/2/17.
 */

public class ToDoItem {
    String taskName;

    Date dueDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoItem toDoItem = (ToDoItem) o;

        if (taskName != null ? !taskName.equals(toDoItem.taskName) : toDoItem.taskName != null)
            return false;
        return dueDate != null ? dueDate.equals(toDoItem.dueDate) : toDoItem.dueDate == null;

    }

    @Override
    public int hashCode() {
        int result = taskName != null ? taskName.hashCode() : 0;
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        return result;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public Date getDueDate() {
        return dueDate;
    }

    public void setDueDate(Date dueDate) {
        DateFormat dateFormat = new SimpleDateFormat();
        this.dueDate = dueDate;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                '}';
    }
}