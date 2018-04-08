package com.example.android.audiobook;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

public class NowPlaying extends AppCompatActivity implements View.OnClickListener {
    ImageButton playPause;
    Button library;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        // Recieve what was sent by the intent and create with it an AudioBook instance.
        Intent in = getIntent();

        AudioBook nowPlaying = in.getParcelableExtra("item");

        // Update the TextViews in NowPlaying activity.
        TextView bookTitle = findViewById(R.id.playing_book_title);
        bookTitle.setText(nowPlaying.getTitle());

        TextView bookAuthor = findViewById(R.id.playing_book_author);
        String bookAuthorText = String.format(getString(R.string.author_credit), nowPlaying.getAuthor());
        bookAuthor.setText(bookAuthorText);

        // Set OnClickListener on play button to toggle between play and pause.
        playPause = findViewById(R.id.play_button);
        playPause.setOnClickListener(this);

        // Assign OnClickListener on Library button to go back to MainActivity.
        library = findViewById(R.id.library_button);
        library.setOnClickListener(this);

        this.getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {

            // case playPause button is pressed.
            case R.id.play_button:
                Drawable drawable = playPause.getDrawable();
                if (drawable.getConstantState().equals(
                        getResources().getDrawable(R.drawable.ic_play_circle_filled_black_48px).getConstantState())) {

                    playPause.setImageResource(R.drawable.ic_pause_circle_filled_black_48px);
                } else {
                    playPause.setImageResource(R.drawable.ic_play_circle_filled_black_48px);
                }
                break;

            // case library button is pressed.
            case R.id.library_button:
                finish();
                break;
        }
    }
}
