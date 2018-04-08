package com.example.android.audiobook;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Intent in;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Populate the audioBooks ArrayList with AudioBook instances.
        final ArrayList<AudioBook> audioBooks = new ArrayList<AudioBook>();
        audioBooks.add(new AudioBook(getString(R.string.book_1_title), getString(R.string.book_1_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_2_title), getString(R.string.book_2_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_3_title), getString(R.string.book_3_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_4_title), getString(R.string.book_4_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_5_title), getString(R.string.book_5_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_6_title), getString(R.string.book_6_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_7_title), getString(R.string.book_7_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_8_title), getString(R.string.book_8_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_9_title), getString(R.string.book_9_author)));
        audioBooks.add(new AudioBook(getString(R.string.book_10_title), getString(R.string.book_10_author)));

        // Create A custom Adaper (i.e. AudioBookAdapter) and set it to the empty list.
        AudioBookAdapter itemsAdapter = new AudioBookAdapter(this, audioBooks);

        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(itemsAdapter);

        // Set OnItemClickListener for each list item.
        in = new Intent(MainActivity.this, NowPlaying.class);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                for (int i = 0; i < parent.getCount(); i++) {
                    if (i == position) {
                        in.putExtra("item", audioBooks.get(i));
                        startActivity(in);
                    }
                }
            }
        });

        this.setTitle(R.string.library);
    }
}
