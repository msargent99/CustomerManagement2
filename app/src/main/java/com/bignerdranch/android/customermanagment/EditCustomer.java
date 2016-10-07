package com.bignerdranch.android.customermanagment;

import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import java.io.File;
import java.util.Date;
import java.util.Calendar;

public class EditCustomer extends AppCompatActivity {
    public Context mContext;
    public Date date = new Date();
    public Calendar cal = Calendar.getInstance();
    private File mPhotoFile;

    public File getPhotoFile(){

        File externalFilesDir = mContext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);

        if (externalFilesDir == null){
            return null;
        }
        return new File(externalFilesDir, "IMG_" + date.toString() + "_" + cal.getTime() + ".jpg");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_customer);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new User();
            fm.beginTransaction ().add(R.id.fragment_container, fragment).commit();
        }

        Button  mButtonSubmit = (Button) findViewById(R.id.button_submit_customer);
        mButtonSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mPhotoFile = getPhotoFile();
            }
        });
        /*/
        mButtonSubmitCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(MyHoardDatabase.myDatabase.db.Cols.KEY_GOLD_HOARD_NAME_COLUMN, R.id.textbox_customer_name);
            }
        });
        /*/
        final Intent captureImage = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);

        Button  mButtonPhoto = (Button) findViewById(R.id.button_photo);
        mButtonPhoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivityForResult(captureImage, 2);
            }
        });
    }
}
