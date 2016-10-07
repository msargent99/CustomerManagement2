package com.bignerdranch.android.customermanagment;

import android.app.Dialog;
import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        FragmentManager fm = getSupportFragmentManager();
        Fragment fragment = fm.findFragmentById(R.id.fragment_container);

        if (fragment == null) {
            fragment = new User();
            fm.beginTransaction()
                    .add(R.id.fragment_container, fragment).commit();
        }
        Button mButtonAdd = (Button) findViewById(R.id.add_btn);
        assert mButtonAdd != null;
        mButtonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, EditCustomer.class));
            }
        });
        Button mButtonView = (Button) findViewById(R.id.view_btn);
        mButtonView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, ViewActivity.class));
            }
        });
        Button mButtonBilling = (Button) findViewById(R.id.billing_btn);
        mButtonBilling.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MenuActivity.this, BillingActivity.class));
            }
        });
        Button mButtonFinalize = (Button) findViewById(R.id.finalizing_btn);
        mButtonFinalize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        AlertDialog.Builder logoff = new AlertDialog.Builder(MenuActivity.this);
        logoff.setMessage("Logging You Off");
        final AlertDialog alert  = logoff.create();

        Button mButtonLogoff = (Button) findViewById(R.id.logoff_btn);
        mButtonLogoff.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                alert.show();
                startActivity(new Intent(MenuActivity.this, LoginActivity.class));
            }
        });
    }
}
