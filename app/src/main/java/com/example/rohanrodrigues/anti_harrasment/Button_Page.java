package com.example.rohanrodrigues.anti_harrasment;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;

import com.google.android.gms.maps.SupportMapFragment;

/**
 * Created by rohanrodrigues on 11/11/16.
 */

public class Button_Page extends Activity {
    boolean safe = true;
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

        fingerprint.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!safe) {
                    startTime = System.currentTimeMillis();
                }
            }
        });
    }

    public void setActivityBackgroundColor(int color) {
        View view = this.getWindow().getDecorView();
        view.setBackgroundColor(color);
    }
}
