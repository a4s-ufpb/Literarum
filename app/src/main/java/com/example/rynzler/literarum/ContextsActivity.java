package com.example.rynzler.literarum;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Typeface;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.ByteArrayOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContextsActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView titleThemes;
    private ImageView fruitsIV;
    private ImageView professionsIV;
    private ImageView animalsIV;
    private ImageView homeIV;
    private ImageView colorsIV;
    private ImageView bodyIV;
    private GameManager gameManager;
    private List<Word> colorsTheme;
    private GameTheme gameTheme;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_contexts);
        Typeface typeface = Typeface.createFromAsset(
                getAssets(), "From Cartoon Blocks.ttf");
        this.titleThemes = (TextView) findViewById(R.id.titleTheme);
        titleThemes.setTypeface(typeface);
        this.fruitsIV = (ImageView) findViewById(R.id.fruitId);
        fruitsIV.setOnClickListener(this);
        this.professionsIV = (ImageView) findViewById(R.id.professionsId);
        professionsIV.setOnClickListener(this);
        this.animalsIV = (ImageView) findViewById(R.id.animalsId);
        animalsIV.setOnClickListener(this);
        this.homeIV = (ImageView) findViewById(R.id.homeId);
        homeIV.setOnClickListener(this);
        this.bodyIV = (ImageView) findViewById(R.id.bodyId);
        bodyIV.setOnClickListener(this);
        this.colorsIV = (ImageView) findViewById(R.id.colorsId);
        colorsIV.setOnClickListener(this);
        this.gameManager = new GameManager();
        Word blue = new Word(getDrawableId("blue"), "blue", "Blue");
        Word red = new Word(getDrawableId("red"), "red", "Red");
        Word brown = new Word(getDrawableId("brown"), "brown", "Brown");
        Word yellow = new Word(getDrawableId("yellow"), "yellow", "Yellow");
        Word purple = new Word(getDrawableId("purple"), "purple", "Purple");
        Word gray = new Word(getDrawableId("gray"), "gray", "Gray");
        Word green = new Word(getDrawableId("green"), "green", "Green");


        colorsTheme = new ArrayList<Word>
                (Arrays.asList(blue, red, brown, yellow, purple, gray, green));
        gameTheme = new GameTheme("Colors", R.drawable.colors, colorsTheme);
        gameManager.addTheme(gameTheme);

    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, GameActivity.class);
        switch (view.getId()){
            case R.id.bodyId:
                break;
            case R.id.animalsId:
                break;
            case R.id.colorsId:
                it.putExtra("theme", (Serializable) colorsTheme);
                break;
            case R.id.professionsId:
                break;
            case R.id.fruitId:
                break;
            case R.id.homeId:
                break;
        }

        /*Bitmap imageEmBits =((BitmapDrawable) imageView.getDrawable()).getBitmap();
        ByteArrayOutputStream stream = new ByteArrayOutputStream();
        imageEmBits.compress(Bitmap.CompressFormat.PNG, 100, stream);
        byte[] byteArray = stream.toByteArray();*/
        startActivity(it);

    }
    private int getDrawableId(String drawableName){
        return getResources().getIdentifier(drawableName , "drawable", getPackageName());

    }
}
