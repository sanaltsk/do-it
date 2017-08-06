package com.inspyreit.kui.doit;

import android.app.FragmentManager;
import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.daimajia.swipe.util.Attributes;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<ToDoItem> to_do_items = new ArrayList<>();

    private ListView mListView;
    private ListViewAdapter mAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        mAdapter = new ListViewAdapter(this,to_do_items);
        mListView.setAdapter(mAdapter);
        mAdapter.setMode(Attributes.Mode.Single);

        FloatingActionButton addTaskBtn = (FloatingActionButton) findViewById(R.id.addTaskBtn);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                AddTaskDialogFragment dialogFragment = new AddTaskDialogFragment ();
                dialogFragment.show(fm,"Add Task");
            }
        });
    }

    public void addNewTask(ToDoItem task) {
        to_do_items.add(task);
        mAdapter.notifyDataSetChanged();
        Log.d("New Task: ", task.toString());

    }

    public void editTask(ToDoItem task, int position) {
        to_do_items.set(position,task);
        mAdapter.notifyDataSetChanged();
        Log.d("Edit Task: ", task.toString());

    }
}
