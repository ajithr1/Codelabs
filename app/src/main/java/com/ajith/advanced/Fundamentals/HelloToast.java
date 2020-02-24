package com.ajith.advanced.Fundamentals;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.ajith.advanced.R;

public class HelloToast extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello_toast);

        tv = findViewById(R.id.textView);
    }

    public void toast(View view) {
        Toast.makeText(this, "Last value is: "+tv.getText().toString(), Toast.LENGTH_SHORT).show();
        tv.setText("0");
    }

    public void count(View view) {
        int value = Integer.parseInt(tv.getText().toString());
        tv.setText(String.valueOf(value + 1));
    }
}
