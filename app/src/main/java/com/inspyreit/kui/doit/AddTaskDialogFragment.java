package com.inspyreit.kui.doit;

import android.app.FragmentManager;
import android.os.Bundle;
import android.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import static android.R.attr.value;

/**
 * Created by sanal on 8/1/17.
 */

public class AddTaskDialogFragment extends DialogFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.fragment_add_task_dialog, container, false);
        getDialog().setTitle("Add Task");
        Button dismiss = (Button) rootView.findViewById(R.id.dismiss);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });

        Button save =(Button) rootView.findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskName = (EditText) rootView.findViewById(R.id.task);
                String value = taskName.getText().toString();
                Log.d("Quantity: ", value);
                MainActivity callingActivity = (MainActivity) getActivity();
                callingActivity.addNewTask(value);
                dismiss();
            }
        });
        return rootView;
    }



}
