package com.ajith.advanced;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.text.DateFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class LocaleText extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private int mInputQuantity = 1;
    private NumberFormat mNumberFormat = NumberFormat.getInstance();
    private double mPrice = 0.10;

    private double mFrExchangeRate = 73.25; // 73.25 rupees = $1.

    private NumberFormat mCurrencyFormat = NumberFormat.getCurrencyInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_locale_text);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);

        final Date myDate = new Date();
        final long expirationDate = myDate.getTime() + TimeUnit.DAYS.toMillis(5);
        myDate.setTime(expirationDate);

        String myFormattedDate = DateFormat.getDateInstance().format(myDate);
        TextView expirationDateView = findViewById(R.id.date);
        expirationDateView.setText(myFormattedDate);

        String myFormattedPrice;
        final String deviceLocale = Locale.getDefault().getCountry();
        if (deviceLocale.equals("IN")) {
            mPrice *= mFrExchangeRate;
            myFormattedPrice = mCurrencyFormat.format(mPrice);
        } else {
            mCurrencyFormat = NumberFormat.getCurrencyInstance(Locale.US);
            myFormattedPrice = mCurrencyFormat.format(mPrice);
        }

        final TextView total = findViewById(R.id.total);
        final TextView localePrice = findViewById(R.id.price);
        localePrice.setText(myFormattedPrice);

        final EditText enteredQuantity = findViewById(R.id.quantity);

        enteredQuantity.setOnEditorActionListener
                (new EditText.OnEditorActionListener() {
                    @Override
                    public boolean onEditorAction(TextView v, int actionId,
                                                  KeyEvent event) {
                        if (actionId == EditorInfo.IME_ACTION_DONE) {
                            // Close the keyboard.
                            InputMethodManager imm = (InputMethodManager)
                                    v.getContext().getSystemService
                                            (Context.INPUT_METHOD_SERVICE);
                            assert imm != null;
                            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);

                            try {
                                mInputQuantity = Objects.requireNonNull(mNumberFormat.parse(v.getText()
                                        .toString())).intValue();
                                v.setError(null);
                            } catch (ParseException e) {
                                Log.e(TAG, Log.getStackTraceString(e));
                                v.setError(getText(R.string.enter_number));
                                return false;
                            }

                            String myFormattedQuantity =
                                    mNumberFormat.format(mInputQuantity);
                            v.setText(myFormattedQuantity);

                            return true;
                        }
                        return false;
                    }
                });


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (deviceLocale.equals("IN")) {
                    total.setText(String.valueOf(Integer.parseInt(enteredQuantity.getText().toString()) * 7.32));
                } else {
                    total.setText(String.valueOf(Integer.parseInt(enteredQuantity.getText().toString()) * 0.1));
                }
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle options menu item clicks here.
        switch (item.getItemId()) {
            case R.id.action_help:
                showHelp();
                return true;
            case R.id.action_language:
                Intent languageIntent = new
                        Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(languageIntent);
                return true;
            default:
        }
        return super.onOptionsItemSelected(item);
    }

    private void showHelp() {
        Intent helpIntent = new Intent(this, HelpActivity.class);
        startActivity(helpIntent);
    }

}
