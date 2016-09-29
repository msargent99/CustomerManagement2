package com.bignerdranch.android.customermanagment;

import android.content.ContentValues;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class EditCustomer extends AppCompatActivity {

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

        Button  mButtonSubmitCustomer = (Button) findViewById(R.id.button_submit_customer);
        mButtonSubmitCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ContentValues values = new ContentValues();
                values.put(myDatabase.Cols.KEY_GOLD_HOARD_NAME_COLUMN, R.id.textbox_customer_name);
            }
        });
    }
}
