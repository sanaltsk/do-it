package com.inspyreit.kui.doit;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.daimajia.swipe.SwipeLayout;
import com.daimajia.swipe.adapters.BaseSwipeAdapter;

import java.text.DateFormat;
import java.util.List;

public class ListViewAdapter extends BaseSwipeAdapter {
    List<ToDoItem>  tasks;

    private Context mContext;
    private static LayoutInflater inflater=null;

    public ListViewAdapter(Context mContext, List<ToDoItem> taskList)
    {
        tasks=taskList;
        this.mContext = mContext;
    }

    @Override
    public int getSwipeLayoutResourceId(int position) {
        return R.id.swipe;
    }

    @Override
    public View generateView(int position, ViewGroup parent) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.listview_item, null);
        SwipeLayout swipeLayout = (SwipeLayout)v.findViewById(getSwipeLayoutResourceId(position));
        swipeLayout.setShowMode(SwipeLayout.ShowMode.PullOut);
        swipeLayout.addDrag(SwipeLayout.DragEdge.Left, swipeLayout.findViewById(R.id.bottom_wrapper));
        swipeLayout.addDrag(SwipeLayout.DragEdge.Right, swipeLayout.findViewById(R.id.bottom_wrapper_2));

        swipeLayout.getSurfaceView().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Click on surface", Toast.LENGTH_SHORT).show();
                Log.d("app", "click on surface");
            }
        });
        swipeLayout.getSurfaceView().setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Toast.makeText(mContext, "longClick on surface", Toast.LENGTH_SHORT).show();
                Log.d("app", "longClick on surface");
                return true;
            }
        });
        swipeLayout.findViewById(R.id.star2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Star", Toast.LENGTH_SHORT).show();
            }
        });

        swipeLayout.findViewById(R.id.trash2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Trash Bin", Toast.LENGTH_SHORT).show();
            }
        });
        swipeLayout.findViewById(R.id.archive).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Archivinggg", Toast.LENGTH_SHORT).show();
            }
        });

        swipeLayout.findViewById(R.id.delete).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "Delete Bin", Toast.LENGTH_SHORT).show();
            }
        });
        return v;
    }

    public class Holder {
        TextView taskTitle;
        TextView dueDate;
    }
    @Override
    public void fillValues(int position, View convertView) {
        ToDoItem task = tasks.get(position);
        Holder holder=new Holder();
        holder.taskTitle=(TextView) convertView.findViewById(R.id.taskTitle);
        holder.dueDate = (TextView) convertView.findViewById(R.id.dueDate);

        holder.taskTitle.setText(task.getTaskName());
        if(task.getDueDate()!=null) {
            DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(mContext);
            String date_string = dateFormat.format(task.getDueDate());
            holder.dueDate.setText(date_string);
        }

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

    /*
    Color transition method.
     */
    public Object evaluate(float fraction, Object startValue, Object endValue) {
        int startInt = (Integer) startValue;
        int startA = (startInt >> 24) & 0xff;
        int startR = (startInt >> 16) & 0xff;
        int startG = (startInt >> 8) & 0xff;
        int startB = startInt & 0xff;

        int endInt = (Integer) endValue;
        int endA = (endInt >> 24) & 0xff;
        int endR = (endInt >> 16) & 0xff;
        int endG = (endInt >> 8) & 0xff;
        int endB = endInt & 0xff;

        return (int) ((startA + (int) (fraction * (endA - startA))) << 24) |
                (int) ((startR + (int) (fraction * (endR - startR))) << 16) |
                (int) ((startG + (int) (fraction * (endG - startG))) << 8) |
                (int) ((startB + (int) (fraction * (endB - startB))));
    }
}
