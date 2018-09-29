package com.lifeistech.android.medicheck;

import android.Manifest;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v4.app.ActivityCompat;
import android.util.Log;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.app.Activity;
import android.provider.MediaStore;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.util.Calendar;
import java.util.List;
import java.util.Random;

import io.realm.Realm;
import io.realm.RealmResults;
import io.realm.internal.IOException;

public class MedicineRegistration extends Activity {

    private List<String> medicineList;
    private final static int RESULT_CAMERA = 1001;
    private ImageView imageView;
    private final int REQUEST_PERMISSION = 1000;
    private String fileName = "sample_image.jpg";
    private String filePath;
    byte[] bytes;
    String Text;
    EditText editText1, editText2;
    private Realm realm;
    Medicine medicine;

    public static final String TABLE_SAMPLE =
            "create table information(" + "name text not null," + "medicine" + "bytes);";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.medicineregistration);
        editText1 = (EditText) findViewById(R.id.editText);
        editText2 = (EditText) findViewById(R.id.editText2);
//         = (Spinner)findViewById(R.id.spinner2);
        String str = "image file: " + fileName;

        findViews();
//        setListeners();

//        if (Build.VERSION.SDK_INT >= 23) {
//            checkPermission();
//        } else {
//            setUpWriteExternalStorage();
//        }

        Intent intent = getIntent();
        final int medicineId = intent.getIntExtra("id", 0);
        realm = Realm.getDefaultInstance();
        RealmResults<Medicine> result = realm.where(Medicine.class).equalTo("id", medicineId).findAll();
        if (medicineId != 0) {
            medicine = result.get(0);
            editText1.setText(medicine.getName());
            editText2.setText(medicine.getDose());
//            editText3.setText(medicine.getTiming() + "");
        }

        imageView = (ImageView) findViewById(R.id.image_view);

        MyOpenHelper helper = new MyOpenHelper(this);
        final EditText nameText = (EditText) findViewById(R.id.editText);
        Text = nameText.getText().toString();
        final ImageView medicineImage = (ImageView) findViewById(R.id.image_view);

        ImageButton cameraButton = (ImageButton) findViewById(R.id.camera_button);
        cameraButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, RESULT_CAMERA);
            }
        });

        Button sendButton = (Button) findViewById(R.id.send_button);
        sendButton.setOnClickListener(new OnClickListener() {

            @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
            @Override
            public void onClick(View v) {
                if (medicineId == 0) {
                    add();
                } else {
                    update();
                }
                Intent dbIntent = new Intent(MedicineRegistration.this, MedicineList.class);
                startActivity(dbIntent);
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == RESULT_CAMERA) {
            android.graphics.Bitmap bitmap = (android.graphics.Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(bitmap);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 1000, baos);
            bytes = baos.toByteArray();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void add() {
        String createdAtText = android.text.format.DateFormat.format("yyyy-MM-dd-kk-mm-ss", Calendar.getInstance()).toString();
        Random random = new Random();
        realm.beginTransaction();
        Medicine medicine = realm.createObject(Medicine.class); // 新たなオブジェクトを作成
        medicine.setId(random.nextInt(9999999));
        medicine.setName(editText1.getText().toString());
        medicine.setDose(editText2.getText().toString());
        medicine.setTakePerDay(1);
//        medicine.setTiming(Integer.parseInt(editText3.getText().toString()+0));
        medicine.setCreatedAt(createdAtText);
        medicine.setResId(R.drawable.ic_launcher);
        realm.commitTransaction();
    }

    @RequiresApi(api = Build.VERSION_CODES.CUPCAKE)
    public void update() {
        String createdAtText = android.text.format.DateFormat.format("yyyy-MM-dd-kk-mm-ss", Calendar.getInstance()).toString();
        Random random = new Random();
        realm.beginTransaction();
        medicine.setId(random.nextInt(9999999));
        medicine.setName(editText1.getText().toString());
        medicine.setDose(editText2.getText().toString());
        medicine.setTakePerDay(1);
//        medicine.setTiming(Integer.parseInt(spinner.getText().toString()+0));
        medicine.setCreatedAt(createdAtText);
        medicine.setResId(R.drawable.ic_launcher);
        realm.commitTransaction();

        finish();

    }


    static final int REQUEST_CAPTURE_IMAGE = 100;

    Button button;
    File picFile;

    protected void findViews() {
        button = (Button) findViewById(R.id.send_button);
        imageView = (ImageView) findViewById(R.id.imageView);
    }

    protected String getPicFileName() {
        Calendar c = Calendar.getInstance();
        String s = c.get(Calendar.YEAR)
                + "_" + (c.get(Calendar.MONTH) + 1)
                + "_" + c.get(Calendar.DAY_OF_MONTH)
                + "_" + c.get(Calendar.HOUR_OF_DAY)
                + "_" + c.get(Calendar.MINUTE)
                + "_" + c.get(Calendar.SECOND)
                + ".jpg";
        return s;
    }
}