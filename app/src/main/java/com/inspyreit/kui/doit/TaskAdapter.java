package com.inspyreit.kui.doit;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.List;

/**
 * Created by sanal on 8/2/17.
 */

public class TaskAdapter extends BaseAdapter {
    List<ToDoItem>  tasks;
    Context context;
    private static LayoutInflater inflater=null;

    public TaskAdapter(MainActivity mainActivity, List<ToDoItem> taskList) {
        // TODO Auto-generated constructor stub
        tasks=taskList;
        context=mainActivity;
        inflater = ( LayoutInflater )context.
                getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        return tasks.size();
    }

    @Override
    public Object getItem(int position) {
        return tasks.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }
    public class Holder {
        TextView taskTitle;
        TextView dueDate;
    }
    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        ToDoItem task = tasks.get(position);
        Holder holder=new Holder();
        View rowView;
        rowView = inflater.inflate(R.layout.single_task, null);
        holder.taskTitle=(TextView) rowView.findViewById(R.id.taskTitle);
        holder.dueDate = (TextView) rowView.findViewById(R.id.dueDate);

        holder.taskTitle.setText(task.getTaskName());
        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(context);
        String date_string = dateFormat.format(task.getDueDate());
        holder.dueDate.setText(date_string);
        rowView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // TODO Auto-generated method stub
                Toast.makeText(context, "You Clicked "+tasks.get(position).toString(), Toast.LENGTH_LONG).show();
            }
        });
        return rowView;
    }
}
