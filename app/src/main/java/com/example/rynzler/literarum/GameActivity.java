package com.example.rynzler.literarum;

import android.content.Intent;
import android.os.RemoteException;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rynzler.literarum.models.Challenge;
import com.example.rynzler.literarum.models.Theme;
import com.example.rynzler.literarum.sisalfaservice.SisalfaService;

import java.util.ArrayList;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView playIV, firstIV, secondIV, thirdIV, helpIV, backIV,
            firstHeart, secondHeart, thirdHeart;
    private TextView wordTV;
    private SisalfaService sisalfaService;
    private GameManager gameManager;
    private ConvertTextToSpeech convertTextToSpeech;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private int challengeTextViewID;
    private int heartCount = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        startActivity(new Intent(this, PopUp.class));

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
        this.convertTextToSpeech = new ConvertTextToSpeech();
        this.gameManager = new GameManager();

        progressBar.setMax(10);



        Intent it = getIntent();
        String themeID = it.getStringExtra("theme");

        try {
            challengeTextViewID = gameManager.displayChallengeOnScreen(firstIV, secondIV, thirdIV,
                    wordTV, "teste");
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnHelp:
                startActivity(new Intent(this, PopUp.class));
                break;
            case R.id.btnPlay:
                convertTextToSpeech.speakOut(wordTV.getText().toString());
                break;
            case R.id.btnBack:
                startActivity(new Intent(this, ThemesActivity.class));
                break;
            case R.id.firstIV:
                try {
                    checkAnswer((Integer) firstIV.getTag());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.secondIV:
                try {
                    checkAnswer((Integer) secondIV.getTag());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
            case R.id.thirdIV:
                try {
                    checkAnswer((Integer) thirdIV.getTag());
                } catch (RemoteException e) {
                    e.printStackTrace();
                }
                break;
        }

    }

    private void checkAnswer(int id) throws RemoteException {
        if(id != challengeTextViewID){
            clearHeartView();
            Toast.makeText(getApplicationContext(), "Errado!", Toast.LENGTH_SHORT).show();
        }else{
            progressBar();
            Toast.makeText(getApplicationContext(), "Correto!", Toast.LENGTH_SHORT).show();
            challengeTextViewID = challengeTextViewID = gameManager.displayChallengeOnScreen(firstIV, secondIV, thirdIV,
                    wordTV, "teste");
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
