package com.example.vladok.rentaddresses.util;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.Toast;

import com.example.vladok.rentaddresses.R;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class DoubleDatePicker implements View.OnClickListener, DatePickerDialog.OnDateSetListener {
    private Button buttonFrom;
    private Button buttonTo;
    private Context context;
    private Calendar calendar;
    private int year;
    private int month;
    private int day;
    private int btnId;


    public DoubleDatePicker(Context context, int from, int to) {
        Activity act = (Activity) context;

        this.buttonFrom = (Button) act.findViewById(from);
        this.buttonFrom.setOnClickListener(this);

        this.buttonTo = (Button) act.findViewById(to);
        this.buttonTo.setOnClickListener(this);

        this.context = context;
        calendar = Calendar.getInstance();
    }

    @Override
    public void onClick(View v) {
        btnId = v.getId();
        DatePickerDialog dialog = new DatePickerDialog(context, this, calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
        dialog.show();
    }

    private void updateDisplay() {

        if (btnId == buttonFrom.getId()) {
            buttonFrom.setText(new StringBuilder()
                    .append(day).append("/").append(month + 1).append("/").append(year).append(" "));
        } else {
            buttonTo.setText(new StringBuilder()
                    .append(day).append("/").append(month + 1).append("/").append(year).append(" "));
        }


    }

    @Override
    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
        if(view.isShown()) {
            this.year = year;
            this.month = monthOfYear;
            this.day = dayOfMonth;
            updateDisplay();
            validateDates();
        }
    }

    private boolean validateDates() {
        Boolean isValid = false;
        DateFormat df = new SimpleDateFormat(Config.DATE_FORMAT);
        String strFrom = buttonFrom.getText().toString();
        String strTo = buttonTo.getText().toString();


        Date dateFrom;
        Date dateTo;
        try {
            dateFrom = df.parse(strFrom);
            dateTo = df.parse(strTo);

            if (dateFrom.before(dateTo) || dateFrom.equals(dateTo)) {
                isValid = true;
            }else{
                Toast.makeText(context, R.string.msgCorrectDays,
                        Toast.LENGTH_LONG).show();
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return isValid;
    }
    public boolean onBackValidate(){
        return validateDates();
    }

}