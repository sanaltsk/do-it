package com.inspyreit.kui.doit;

import android.app.DatePickerDialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by sanal on 8/1/17.
 */

public class EditTaskDialogFragment extends DialogFragment {
    String date_string;
    String task_string;
    Date date;
    int position;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        date_string = getArguments().getString("date");
        task_string = getArguments().getString("title");
        position = getArguments().getInt("position");


        final View rootView = inflater.inflate(R.layout.fragment_edit_task_dialog, container, false);
        getDialog().setTitle("Add Task");
        Button dismiss = (Button) rootView.findViewById(R.id.edit_task_dismiss_btn);
        dismiss.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        TextView taskTV = (TextView)rootView.findViewById(R.id.edit_task_title);
        taskTV.setText(task_string);
        if(date_string!=null && !date_string.isEmpty()) {
            TextView dateTV = (TextView)rootView.findViewById(R.id.edit_task_date_holder);
            dateTV.setText(date_string);
        }

        Button save =(Button) rootView.findViewById(R.id.edit_task_save_btn);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText taskNameET = (EditText) rootView.findViewById(R.id.edit_task_title);
                String taskName = taskNameET.getText().toString();
                MainActivity callingActivity = (MainActivity) getActivity();
                ToDoItem task = new ToDoItem(taskName);
                task.setDueDate(date);
                callingActivity.editTask(task_string,task,position);
                dismiss();
            }
        });

        ImageButton cal = (ImageButton) rootView.findViewById(R.id.edit_task_cal_btn);
        cal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cal = Calendar.getInstance();
                int year = cal.get(Calendar.YEAR);
                int month = cal.get(Calendar.MONTH);
                int day = cal.get(Calendar.DAY_OF_MONTH);


                DatePickerDialog datePickerDialog = new DatePickerDialog(getActivity(), new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                        cal.set(Calendar.YEAR, year);
                        cal.set(Calendar.MONTH, month);
                        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        DateFormat dateFormat = android.text.format.DateFormat.getDateFormat(view.getContext());

                        TextView dateText = (TextView)rootView.findViewById(R.id.edit_task_date_holder);
                        date_string = dateFormat.format(cal.getTime());
                        date = cal.getTime();
                        dateText.setText(date_string);
                    }
                }, year, month, day);
                datePickerDialog.show();
            }
        });
        return rootView;
    }



}
