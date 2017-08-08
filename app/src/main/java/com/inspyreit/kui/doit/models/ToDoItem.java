package com.inspyreit.kui.doit.models;

import java.util.Date;

/**
 * Created by sanal on 8/2/17.
 */

public class ToDoItem {
    Long _id;
    String taskName;
    Date dueDate;
    boolean stared = false;
    boolean complete = false;

    public ToDoItem(String taskName) {
        this.taskName = taskName;
    }

    public Long get_id() {
        return _id;
    }

    public void set_id(Long _id) {
        this._id = _id;
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
        this.dueDate = dueDate;
    }

    public boolean isStared() {
        return stared;
    }

    public void setStared(boolean stared) {
        this.stared = stared;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ToDoItem toDoItem = (ToDoItem) o;

        if (stared != toDoItem.stared) return false;
        if (complete != toDoItem.complete) return false;
        if (taskName != null ? !taskName.equals(toDoItem.taskName) : toDoItem.taskName != null)
            return false;
        return dueDate != null ? dueDate.equals(toDoItem.dueDate) : toDoItem.dueDate == null;

    }

    @Override
    public int hashCode() {
        int result = taskName != null ? taskName.hashCode() : 0;
        result = 31 * result + (dueDate != null ? dueDate.hashCode() : 0);
        result = 31 * result + (stared ? 1 : 0);
        result = 31 * result + (complete ? 1 : 0);
        return result;
    }

    @Override
    public String toString() {
        return "ToDoItem{" +
                "taskName='" + taskName + '\'' +
                ", dueDate=" + dueDate +
                ", stared=" + stared +
                ", complete=" + complete +
                '}';
    }
}
