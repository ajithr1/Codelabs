package com.ajith.advanced.Advanced;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.ajith.advanced.R;

public class Fragment extends AppCompatActivity implements SimpleFragment.OnFragmentInteractionListener {

    private boolean isDisplayed = false;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);

        button = findViewById(R.id.b);
    }

    public void fragmentOpen(View view) {
        if (!isDisplayed){
            displayFragment();
        }else {
            hideFragment();
        }
    }

    private void displayFragment() {
        SimpleFragment simpleFragment = new SimpleFragment();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.container, simpleFragment).addToBackStack(null).commit();

        button.setText("Close");

        isDisplayed = true;
    }

    private void hideFragment() {
        FragmentManager manager = getSupportFragmentManager();
        SimpleFragment simpleFragment = (SimpleFragment) manager.findFragmentById(R.id.container);

        if (simpleFragment != null){
            FragmentTransaction transaction = manager.beginTransaction();
            transaction.remove(simpleFragment).commit();

            isDisplayed = false;

            button.setText("open");
        }
    }

    @Override
    public void onRadioButtonChoice(int choice) {
        Toast.makeText(this, String.valueOf(choice), Toast.LENGTH_SHORT).show();
    }
}
