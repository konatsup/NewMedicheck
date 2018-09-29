package com.lifeistech.android.medicheck;

import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.FragmentActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TimePicker;
import android.widget.TextView;

import java.util.Locale;

public class Alarm extends FragmentActivity
        implements TimePickerDialog.OnTimeSetListener {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.alarm);

//        textView = (TextView) findViewById(R.id.timeView);
//        textView = (TextView) findViewById(R.id.timeView2);
//        textView = (TextView) findViewById(R.id.timeView3);
//        textView = (TextView) findViewById(R.id.timeView4);
//        textView = (TextView) findViewById(R.id.timeView5);
//        textView = (TextView) findViewById(R.id.timeView6);
//        textView = (TextView) findViewById(R.id.timeView7);
//        textView = (TextView) findViewById(R.id.timeView8);
//        textView = (TextView) findViewById(R.id.timeView9);

        FloatingActionButton backButton = (FloatingActionButton) findViewById(R.id.backbutton3);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Start.class);
                startActivity(intent);
                finish();
            }
        });

        Switch alarm = (Switch) findViewById(R.id.alarm);
        final Switch sound = (Switch) findViewById(R.id.sound);
        final Switch vibrate = (Switch) findViewById(R.id.vibrate);
        final LinearLayout linearlayout = (LinearLayout) findViewById(R.id.layout3);

        alarm.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (sound.getVisibility() != View.GONE) {
                    sound.setVisibility(View.GONE);
                } else {
                    sound.setVisibility(View.VISIBLE);
                }

                if (vibrate.getVisibility() != View.GONE) {
                    vibrate.setVisibility(View.GONE);
                } else {
                    vibrate.setVisibility(View.VISIBLE);
                }

                if (linearlayout.getVisibility() != View.GONE) {
                    linearlayout.setVisibility(View.GONE);
                } else {
                    linearlayout.setVisibility(View.VISIBLE);
                }
            }
        });

    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {

        String string = String.format(Locale.US, "%02d:%02d", hourOfDay, minute);
        textView.setText(string);
    }

    public void showTimePickerDialog(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView);
    }

    public void showTimePickerDialog2(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView2);
    }

    public void showTimePickerDialog3(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView3);
    }

    public void showTimePickerDialog4(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView4);
    }

    public void showTimePickerDialog5(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView5);
    }

    public void showTimePickerDialog6(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView6);
    }

    public void showTimePickerDialog7(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView7);
    }

    public void showTimePickerDialog8(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView8);
    }

    public void showTimePickerDialog9(View v) {
        DialogFragment newFragment = new TimePick();
        newFragment.show(getSupportFragmentManager(), "timePicker");
        textView = (TextView) findViewById(R.id.timeView9);
    }

}