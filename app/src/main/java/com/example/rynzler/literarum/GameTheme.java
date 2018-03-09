package com.example.rynzler.literarum;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import android.widget.ImageView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynzler on 18/02/18.
 */

public class GameTheme{
    private String name;
    private int image;
    private List<Word> words;

    public GameTheme(String name, int image, List<Word> words) {
        this.name = name;
        this.image = image;
        this.words = words;
    }

    public void addWord(Word word){
        this.words.add(word);
    }

    public Word getWordById(int id){
        for(Word w: words){
            if(w.getImageId() == id){
                return w;
            }
        }return null;
    }

    public void setWords(List<Word> words) {
        this.words = words;
    }

    public Word getWord(String name){
        for(Word w: this.words){
            if(w.getName().equals(name)){
                return w;
            }
        }return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public List<Word> getWords() {
        return words;
    }
/*
    @Override
    public int describeContents() {
        return 0;
    }

   @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeInt(image);
        //parcel.writeTypedList(words);

    }

    private GameTheme(Parcel in){
        name = in.readString();
        image = in.readInt();
        //words = new ArrayList<>();
       // words = in.createTypedArrayList(Word.CREATOR);

    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public GameTheme createFromParcel(Parcel in) {
            return new GameTheme(in);
        }

        public GameTheme[] newArray(int size) {
            return new GameTheme[size];
        }
    };*/
}
