package com.example.android.audiobook;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Aloraifi on 07/04/2018.
 */

public class AudioBook implements Parcelable{
    private String mTitle;
    private String mAuthor;

    public AudioBook(String mTitle, String mAuthor) {
        this.mTitle = mTitle;
        this.mAuthor = mAuthor;
    }

    protected AudioBook(Parcel in) {
        mTitle = in.readString();
        mAuthor = in.readString();
    }

    public static final Creator<AudioBook> CREATOR = new Creator<AudioBook>() {
        @Override
        public AudioBook createFromParcel(Parcel in) {
            return new AudioBook(in);
        }

        @Override
        public AudioBook[] newArray(int size) {
            return new AudioBook[size];
        }
    };

    public String getTitle() {
        return mTitle;
    }

    public String getAuthor() {
        return mAuthor;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(mTitle);
        dest.writeString(mAuthor);
    }
}
