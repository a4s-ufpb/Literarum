package com.example.rynzler.literarum;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.ImageView;

import java.io.Serializable;

/**
 * Created by rynzler on 18/02/18.
 */

public class Word implements Serializable{
    private int imageId;
    private String sound;
    private String name;

    public Word(int image, String sound, String name) {
        this.imageId = image;
        this.sound = sound;
        this.name = name;
    }

    public int getImageId() {
        return imageId;
    }

    public void setImage(int imageId) {
        this.imageId = imageId;
    }

    public String getSound() {
        return sound;
    }

    public void setSound(String sound) {
        this.sound = sound;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(imageId);
        parcel.writeString(name);
        parcel.writeString(sound);
        Log.v("", "writeToParcel..." + i);

    }
    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Word createFromParcel(Parcel in) {
            return new Word(in);
        }

        public Word[] newArray(int size) {
            return new Word[size];
        }
    };

    private Word(Parcel in){
        name = in.readString();
        imageId = in.readInt();
        sound = in.readString();

    }*/
}
