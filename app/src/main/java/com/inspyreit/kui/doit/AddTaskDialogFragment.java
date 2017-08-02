package com.inspyreit.kui.doit;

import android.app.DatePickerDialog;
import android.app.FragmentManager;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.app.DialogFragment;
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
import java.util.Locale;

import static android.R.attr.value;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.L;
import static com.inspyreit.kui.doit.R.id.date;

/**
 * Created by sanal on 8/1/17.
 */

public class AddTaskDialogFragment extends DialogFragment {
    String date_string;
    Date date;
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
                EditText taskNameET = (EditText) rootView.findViewById(R.id.task);
                String taskName = taskNameET.getText().toString();
                MainActivity callingActivity = (MainActivity) getActivity();
                ToDoItem task = new ToDoItem();
                task.setTaskName(taskName);
                task.setDueDate(date);
                callingActivity.addNewTask(task);
                dismiss();
            }
        });

        ImageButton cal = (ImageButton) rootView.findViewById(R.id.calButton);
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
                        Log.i("Setting task date ",dateFormat.format(cal.getTime()));

                        TextView dateText = (TextView)rootView.findViewById(R.id.date_holder);
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
