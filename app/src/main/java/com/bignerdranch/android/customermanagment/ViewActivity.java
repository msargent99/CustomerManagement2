package com.bignerdranch.android.customermanagment;

import android.content.ContentValues;
import android.graphics.Bitmap;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import java.io.File;

public class ViewActivity extends AppCompatActivity {

    public File mPhotoFile;
    public View mPhotoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);

        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if(fragment == null){
            fragment = new User();
            fm.beginTransaction ().add(R.id.fragment_container, fragment).commit();
        }
        /*/
        ContentValues values = new ContentValues();
        ContentValues names = values.get(db.KEY_GOLD_HOARD_NAME_COLUMN);

        EditText e = (EditText) findViewById (R.id.names);
        e.setText(names.toString());
        /*/
        private void updatePhotoView(){
        if(mPhotoFile == null || !mPhotoFile.exists()){
            mPhotoView.setImageDrawable(null);
        } else {
            Bitmap bitmap = PictureUtils.getScaledBitmap(mPhotoFile.getPath(), getActivity());
            mPhotoView.setImageBitmap(bitmap);
    }
    }
}
