package com.example.ambulence;

import android.content.Intent;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.spark.submitbutton.SubmitButton;

public class MainActivity extends AppCompatActivity {
    private SubmitButton mDriver, mCustomer;

    private static int SPLASH_TIME_OUT = 3210;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mDriver = (SubmitButton) findViewById(R.id.driver);
        mCustomer = (SubmitButton) findViewById(R.id.customer);

        startService(new Intent(MainActivity.this, onAppKilled.class));
        mDriver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, DriverLoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },SPLASH_TIME_OUT);

                return;
            }
        });

        mCustomer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, CustomerLoginActivity.class);
                        startActivity(intent);
                        finish();
                    }
                },SPLASH_TIME_OUT);

                return;
            }
        });
    }
}
