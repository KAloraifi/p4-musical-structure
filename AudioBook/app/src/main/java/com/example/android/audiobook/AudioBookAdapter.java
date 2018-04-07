package com.example.android.audiobook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Aloraifi on 07/04/2018.
 */

public class AudioBookAdapter extends ArrayAdapter<AudioBook> {

    public AudioBookAdapter(Context context, ArrayList<AudioBook> audioBooks) {

        super(context, 0, audioBooks);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext())
                    .inflate(R.layout.list_item, parent, false);
        }

        AudioBook currentBook = getItem(position);

        TextView bookTitle = listItemView.findViewById(R.id.book_title);
        bookTitle.setText(currentBook.getTitle());

        TextView bookAuthor = listItemView.findViewById(R.id.book_author);
        String bookAuthorText = String.format(super.getContext().getString(R.string.author_credit), currentBook.getAuthor());
        bookAuthor.setText(bookAuthorText);

        return listItemView;
    }
}
