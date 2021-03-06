package com.ajith.advanced;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.ajith.advanced.Advanced.Fragment;
import com.ajith.advanced.Advanced.FragmentCommunicate;
import com.ajith.advanced.Advanced.LocaleText;
import com.ajith.advanced.Advanced.SensorSurvey;
import com.ajith.advanced.Advanced.TiltSpot;
import com.ajith.advanced.Fundamentals.HelloToast;
import com.ajith.advanced.Fundamentals.HelloWorld;
import com.ajith.advanced.Fundamentals.ScrollingText;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "ajju";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void helloWorld(View view) {
        startActivity(new Intent(this, HelloWorld.class));
    }

    public void helloToast(View view) {
        startActivity(new Intent(this, HelloToast.class));
    }

    public void fragment(View view) {
        startActivity(new Intent(this, Fragment.class));
    }

    public void scroll(View view) {
        startActivity(new Intent(this, ScrollingText.class));
    }

    public void fragmentCommunication(View view) {
        startActivity(new Intent(this, FragmentCommunicate.class));
    }

    public void sensorSurvey(View view) {
        startActivity(new Intent(this, SensorSurvey.class));
    }

    public void tilt(View view) {
        startActivity(new Intent(this, TiltSpot.class));
    }

    public void addLanguage(View view) {
        startActivity(new Intent(this, LocaleText.class));
    }

    public void location(View view) {
    }

    public void places(View view) {
    }

    public void maps(View view) {
    }
}
