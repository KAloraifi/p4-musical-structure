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
        audioBooks.add(new AudioBook("Elon Musk", "Ashlee Vance"));
        audioBooks.add(new AudioBook("Deep Work", "Cal Newport"));
        audioBooks.add(new AudioBook("Mr. Mercedes", "Stephen King"));
        audioBooks.add(new AudioBook("Ego Is The Enemy", "Ryan Holiday"));
        audioBooks.add(new AudioBook("A Brief History of Time", "Stephen Hawking"));
        audioBooks.add(new AudioBook("Never Split The Difference", "Chris Voss"));
        audioBooks.add(new AudioBook("Algorithms to Live By", "Brian Christian"));
        audioBooks.add(new AudioBook("When Breath Becomes Air", "Paul Kalanithi"));
        audioBooks.add(new AudioBook("Unbroken", "Laura Hillenbrand"));
        audioBooks.add(new AudioBook("Algorithms to Live By", "Brian Christian"));

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
    }
}
