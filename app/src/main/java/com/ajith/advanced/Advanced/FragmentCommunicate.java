package com.ajith.advanced.Advanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ajith.advanced.Advanced.SimpleFragment;
import com.ajith.advanced.R;

public class FragmentCommunicate extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment_communicate);
    }

    public void fragmentOpen(View view) {
    }
}
