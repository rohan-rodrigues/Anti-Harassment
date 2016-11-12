package com.example.rohanrodrigues.anti_harrasment;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.google.android.gms.maps.SupportMapFragment;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by rohanrodrigues on 11/11/16.
 */

public class Button_Page extends Activity {
    boolean safe = true;
    boolean holding = false;
    Button safeButton, unsafeButton, fingerprint;
    long startTime;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout);

    safeButton = (Button)findViewById(R.id.safe_button);
        unsafeButton = (Button)findViewById(R.id.unsafe_button);
        fingerprint = (Button)findViewById(R.id.fingerprint_button);

        safeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safe = true;
                setActivityBackgroundColor(Color.WHITE);
            }
        });

        unsafeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                safe = false;
                setActivityBackgroundColor(Color.RED);
            }
        });

        fingerprint.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        return true;
                    case MotionEvent.ACTION_UP:
                        startTime = System.currentTimeMillis();
                        new Timer().schedule(new TimerTask(){
                            public void run() {
                                if (!safe) {
                                    setActivityBackgroundColor(Color.YELLOW);
                                }
                            }
                        }, 60000);
                        return true;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.item1:
                goToMap();
                return true;
            case R.id.item2:
                goToButton();
                return true;
            case R.id.item3:
                goToSettings();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }

    public void goToSettings() {
        Intent settings = new Intent(this, Settings.class);
        startActivity(settings);
    }

    public void goToMap() {
        Intent maps = new Intent(this, MapsActivity.class);
        startActivity(maps);
    }

    public void goToButton() {
        Intent button = new Intent(this, Button_Page.class);
        startActivity(button);
    }

}

