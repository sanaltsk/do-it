package com.inspyreit.kui.doit;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    TaskAdapter adapter;
    List<ToDoItem> to_do_items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView) findViewById(R.id.listView);
        adapter = new TaskAdapter(this, to_do_items);
        list.setAdapter(adapter);

        Button addTaskBtn = (Button) findViewById(R.id.addTaskBtn);
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
        adapter.notifyDataSetChanged();
        Log.d("New Task: ", task.toString());

    }
}
