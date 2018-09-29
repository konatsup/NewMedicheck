package com.lifeistech.android.medicheck;

/**
 * Created by koizumikarin on 2018/04/09.
 */

import android.app.Activity;
import android.app.AlarmManager;
import android.app.PendingIntent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.util.Log;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;
import android.app.Activity;
import android.content.Intent;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class MedicineTime extends Activity {
    LinearLayout layout;
    ListView morning;
    ListView noon;
    ListView evening;
    ListView beforesleep;
    ListView afterbreakfast;
    ListView afterlunch;
    ListView afterdinner;
    ListView breakfast_lunch;
    ListView lunch_dinner;
    ListView everytime;

    private AlarmManager am;
    private PendingIntent pending;
    private int requestCode = 1;


    MedicineAdapterTime medicineAdaptertime;
    private Realm realm;
    private List<String> itemNames;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicine_list_time);
        itemNames = new ArrayList<>();
        morning = (ListView) findViewById(R.id.morning);
        noon = (ListView) findViewById(R.id.noon);
        evening = (ListView) findViewById(R.id.evening);
        beforesleep= (ListView) findViewById(R.id.beforesleep);
        afterbreakfast = (ListView) findViewById(R.id.afterbreakfast);
        afterlunch = (ListView) findViewById(R.id.afterlunch);
        afterdinner = (ListView) findViewById(R.id.afterdinner);
        breakfast_lunch = (ListView) findViewById(R.id.breakfast_lunch);
        lunch_dinner = (ListView) findViewById(R.id.lunch_dinner);
        everytime = (ListView) findViewById(R.id.everytime);

        realm = Realm.getDefaultInstance();
        RealmResults<Medicine> result = realm.where(Medicine.class).findAll();
        medicineAdaptertime = new MedicineAdapterTime(result, this);
        morning.setAdapter(medicineAdaptertime);
        noon.setAdapter(medicineAdaptertime);
        evening.setAdapter(medicineAdaptertime);
        beforesleep.setAdapter(medicineAdaptertime);
        afterbreakfast.setAdapter(medicineAdaptertime);
        afterlunch.setAdapter(medicineAdaptertime);
        afterdinner.setAdapter(medicineAdaptertime);
        breakfast_lunch.setAdapter(medicineAdaptertime);
        lunch_dinner.setAdapter(medicineAdaptertime);
        everytime.setAdapter(medicineAdaptertime);

        Button sendButton4 = (Button) findViewById(R.id.sendbutton4);
        sendButton4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicineTime.this,com.lifeistech.android.medicheck.MedicineList.class);
                startActivity(intent);
                finish();
            }

        });

        ToggleButton button = (ToggleButton) this.findViewById(R.id.visiblebutton);
        button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.morning);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button2 = (ToggleButton) this.findViewById(R.id.visiblebutton2);
        button2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.noon);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button3 = (ToggleButton)this.findViewById(R.id.visiblebutton3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.evening);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button4 = (ToggleButton)this.findViewById(R.id.visiblebutton4);
        button4.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.beforesleep);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button5 = (ToggleButton)this.findViewById(R.id.visiblebutton5);
        button5.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.afterbreakfast);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button6 = (ToggleButton)this.findViewById(R.id.visiblebutton6);
        button6.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.afterlunch);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button7 = (ToggleButton)this.findViewById(R.id.visiblebutton7);
        button7.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.afterdinner);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button8 = (ToggleButton)this.findViewById(R.id.visiblebutton8);
        button8.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.breakfast_lunch);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button9 = (ToggleButton)this.findViewById(R.id.visiblebutton9);
        button9.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.lunch_dinner);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        ToggleButton button10 = (ToggleButton)this.findViewById(R.id.visiblebutton10);
        button10.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Calendar calendar = Calendar.getInstance();
                calendar.setTimeInMillis(System.currentTimeMillis());
                am = (AlarmManager) getSystemService(ALARM_SERVICE);
                ListView listView = (ListView) MedicineTime.this.findViewById(R.id.everytime);
                if (listView.getVisibility() != View.GONE) {
                    listView.setVisibility(View.GONE);
                } else {
                    listView.setVisibility(View.VISIBLE);
                }
            }});

        FloatingActionButton backbutton2 =(FloatingActionButton) findViewById(R.id.backbutton2);
        backbutton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Start.class);
                startActivity(intent);
                finish();
            }
        });
    }

}