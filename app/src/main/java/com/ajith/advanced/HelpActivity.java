package com.ajith.advanced;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class HelpActivity extends AppCompatActivity {

    private static final String TAG = "ajju";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_help);

        Button button = findViewById(R.id.call);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber = getString(R.string.support_phone);
                callSupportCenter(phoneNumber);
            }
        });
    }

    private void callSupportCenter(String phoneNumber) {
        // Format the phone number for dialing.
        String formattedNumber = String.format("tel: %s", phoneNumber);
        // Create the intent.
        Intent dialIntent = new Intent(Intent.ACTION_DIAL);
        // Set the formatted phone number as data for the intent.
        dialIntent.setData(Uri.parse(formattedNumber));
        // If package resolves to an app, send intent.
        if (dialIntent.resolveActivity(getPackageManager()) != null) {
            startActivity(dialIntent);
        } else {
            Log.e(TAG, getString(R.string.dial_log_message));
        }
    }
}
