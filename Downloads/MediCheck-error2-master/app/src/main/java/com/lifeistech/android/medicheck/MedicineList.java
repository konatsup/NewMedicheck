package com.lifeistech.android.medicheck;

import android.app.Activity;
import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.widget.LinearLayout;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import java.util.ArrayList;
import java.util.List;
import io.realm.Realm;
import io.realm.RealmResults;

public class MedicineList extends Activity {
    LinearLayout layout;
    ListView medicineList;
    MedicineAdapter medicineAdapter;
    private Realm realm;
    private List<String> itemNames;

    @Override

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicinelist);
        itemNames = new ArrayList<>();
        medicineList = (ListView) findViewById(R.id.medicinelist);
        realm = Realm.getDefaultInstance();
        RealmResults<Medicine> result = realm.where(Medicine.class).findAll();
        medicineAdapter = new MedicineAdapter(result, this);
        medicineList.setAdapter(medicineAdapter);

        FloatingActionButton backbutton =(FloatingActionButton) findViewById(R.id.backbutton);
        backbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Start.class);
                startActivity(intent);
                finish();
            }
        });

        FloatingActionButton addButton = (FloatingActionButton) findViewById(R.id.addbutton);
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), MedicineRegistration.class);
                startActivity(intent);
                finish();
            }
        });

        Button sendButton3 = (Button) findViewById(R.id.sendbutton3);
        sendButton3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MedicineList.this,com.lifeistech.android.medicheck.MedicineTime.class);
                startActivity(intent);
                finish();
            }

        });

    }
}