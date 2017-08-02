package com.inspyreit.kui.doit;

import android.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        Button addTaskBtn = (Button) findViewById(R.id.addTaskBtn);
        addTaskBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                AddTaskDialogFragment dialogFragment = new AddTaskDialogFragment ();
                dialogFragment.show(fm,"sss");
            }
        });
    }

    public void addNewTask(String selectedValue) {
        // TODO add your implementation.
        Log.d("New Task: ", selectedValue);

    }
}
