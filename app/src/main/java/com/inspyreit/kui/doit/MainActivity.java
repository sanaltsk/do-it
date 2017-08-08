package com.inspyreit.kui.doit;

import android.app.FragmentManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ListView;

import com.daimajia.swipe.util.Attributes;
import com.inspyreit.kui.doit.adapter.ListViewAdapter;
import com.inspyreit.kui.doit.db.DBManager;
import com.inspyreit.kui.doit.dialogfragment.AddTaskDialogFragment;
import com.inspyreit.kui.doit.models.ToDoItem;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    List<ToDoItem> to_do_items = new ArrayList<>();

    private ListView mListView;
    private ListViewAdapter mAdapter;
    private DBManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        dbManager = new DBManager(getApplicationContext());
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.listview);
        to_do_items = dbManager.getAllTasks();
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
        dbManager.insert(task);
        mAdapter.notifyDataSetChanged();
        Log.d("New Task: ", task.toString());
    }

    public void editTask(String task_name, ToDoItem task, int position) {
        to_do_items.set(position,task);
        dbManager.update(task_name, task);
        mAdapter.notifyDataSetChanged();
        Log.d("Edit Task: ", task.toString());

    }
}
