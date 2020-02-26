package com.ajith.advanced.Advanced;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NavUtils;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;

import com.ajith.advanced.MainActivity;
import com.ajith.advanced.R;

public class SongDetailActivity extends AppCompatActivity {

    public SongUtils.Song mSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_detail);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        mSong = SongUtils.SONG_ITEMS.get
                (getIntent().getIntExtra(SongUtils.SONG_ID_KEY, 0));
        if (mSong != null) {
            ((TextView) findViewById(R.id.song_detail)).setText(mSong.details);
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == android.R.id.home) {
            NavUtils.navigateUpTo(this, new Intent(this, MainActivity.class));
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
