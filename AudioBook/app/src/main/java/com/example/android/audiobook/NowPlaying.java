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

public class NowPlaying extends AppCompatActivity {

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
        final ImageButton playPause = findViewById(R.id.play_button);
        playPause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Drawable drawable = playPause.getDrawable();
                if (drawable.getConstantState().equals(
                        getResources().getDrawable(R.drawable.ic_play_circle_filled_black_48px).getConstantState())) {

                    playPause.setImageResource(R.drawable.ic_pause_circle_filled_black_48px);
                } else {
                    playPause.setImageResource(R.drawable.ic_play_circle_filled_black_48px);
                }
            }
        });

        // Assign OnClickListener on Library button to go back to MainActivity.
        Button button = (Button) findViewById(R.id.library_button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
