package com.example.rynzler.literarum;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.Handler;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView playIV, firstIV, secondIV, thirdIV, helpIV, backIV,
            firstHeart, secondHeart, thirdHeart;
    private TextView wordTV;
    private GameTheme gameTheme;
    private ArrayList<Word> gameWords;
    private TextToSpeech tts;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private int idTextView;
    private int result;
    private int heartCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);

        //get the components reference from XML layout.
        this.playIV = (ImageView) findViewById(R.id.btnPlay);
        playIV.setOnClickListener(this);
        this.wordTV = (TextView) findViewById(R.id.textView);
        this.firstIV = (ImageView) findViewById(R.id.firstIV);
        firstIV.setOnClickListener(this);
        this.secondIV = (ImageView) findViewById(R.id.secondIV);
        secondIV.setOnClickListener(this);
        this.thirdIV = (ImageView) findViewById(R.id.thirdIV);
        thirdIV.setOnClickListener(this);
        this.helpIV = (ImageView) findViewById(R.id.btnHelp);
        helpIV.setOnClickListener(this);
        this.backIV = (ImageView) findViewById(R.id.btnBack);
        backIV.setOnClickListener(this);
        this.progressBar = (ProgressBar) findViewById(R.id.pb);
        this.firstHeart = (ImageView) findViewById(R.id.imageView);
        this.secondHeart = (ImageView) findViewById(R.id.imageView2);
        this.thirdHeart = (ImageView) findViewById(R.id.imageView3);


        startActivity(new Intent(this, PopUp.class));
        Intent it = getIntent();

        gameWords = (ArrayList<Word>) it.getSerializableExtra("theme");
        gameTheme = new GameTheme("Theme", 1, gameWords);
        idTextView = insertImageAndText();
        initTextToSpeech();
        progressBar.setMax(10);


        /*byte[] byteArray = it.getByteArrayExtra("IMAGEM");
        Bitmap bmp = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length);
        imageQuadro.setImageBitmap(bmp);*/

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnHelp:
                startActivity(new Intent(this, PopUp.class));
                break;
            case R.id.btnPlay:
                speakOut();
                break;
            case R.id.btnBack:
                startActivity(new Intent(this, ContextsActivity.class));
                break;
            case R.id.firstIV:
                checkAnswer((Integer) firstIV.getTag());
                break;
            case R.id.secondIV:
                checkAnswer((Integer) secondIV.getTag());
                break;
            case R.id.thirdIV:
                checkAnswer((Integer) thirdIV.getTag());
                break;
        }

    }

    private void speakOut(){
        if (result == TextToSpeech.LANG_MISSING_DATA ||
                result == TextToSpeech.LANG_NOT_SUPPORTED) {
            Toast.makeText(getApplicationContext(), "Feature not supported " +
                    "in your device.", Toast.LENGTH_SHORT);
        }else{
            String text = wordTV.getText().toString();
            tts.speak(text, TextToSpeech.QUEUE_FLUSH, null);
        }

    }

    private void initTextToSpeech(){
        tts = new TextToSpeech(GameActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                    result = tts.setLanguage(Locale.US);
                else{
                    Toast.makeText(getApplicationContext(), "Feature not supported" +
                            "in your device..", Toast.LENGTH_SHORT);
                }
            }

        });
    }

    private int insertImageAndText(){
        int[] array = new int[3];
        int random = 0, randomTemp = 0;

        random = getRandom();
        array[0] = random;
        randomTemp = random;
        firstIV.setImageResource(gameWords.get(random).getImageId());
        firstIV.setTag((gameWords.get(random).getImageId()));
        random = getRandom();
        if(random == randomTemp){
            random = getRandom();
            randomTemp = random;
        }array[1] = random;
        secondIV.setImageResource(gameWords.get(random).getImageId());
        secondIV.setTag((gameWords.get(random).getImageId()));
        random = getRandom();
        if(random == randomTemp){
            random = getRandom();
        }array[2] = random;
        thirdIV.setImageResource(gameWords.get(random).getImageId());
        thirdIV.setTag((gameWords.get(random).getImageId()));
        int rnd = new Random().nextInt(array.length);
        wordTV.setText(String.valueOf(gameWords.get(array[rnd]).getName()));
        return gameWords.get(array[rnd]).getImageId();

    }


    private int getRandom(){
        int rnd = new Random().nextInt(gameTheme.getWords().size());
        return rnd;
    }

    private void checkAnswer(int id){
        if(id != idTextView){
            clearHeartView();
            Toast.makeText(getApplicationContext(), "Errado!", Toast.LENGTH_SHORT).show();
        }else{
            progressBar();
            Toast.makeText(getApplicationContext(), "Correto!", Toast.LENGTH_SHORT).show();
            idTextView = insertImageAndText();
        }

    }
    public void progressBar() {
        if(progressStatus < 10){
            progressStatus += 1;
            progressBar.setProgress(progressStatus);
        }else{
            progressStatus = 0;
            startActivity(new Intent(this, WinActivity.class));
        }
    }

    private void clearHeartView(){
        if(heartCount == 0){
            firstHeart.setImageResource(android.R.color.transparent);
            heartCount++;
        }else if(heartCount == 1){
            secondHeart.setImageResource(android.R.color.transparent);
            heartCount++;
        }else if(heartCount == 2){
            thirdHeart.setImageResource(android.R.color.transparent);
            heartCount = 0;
            startActivity(new Intent(this, LoseActivity.class));
        }
    }
}
