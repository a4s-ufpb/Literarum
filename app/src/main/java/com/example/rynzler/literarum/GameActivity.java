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
import com.example.rynzler.literarum.sisalfaservice.SisalfaMockService;
import com.example.rynzler.literarum.sisalfaservice.SisalfaService;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView playIV, firstIV, secondIV, thirdIV, helpIV, backIV,
            firstHeart, secondHeart, thirdHeart;
    private TextView wordTV;
    private SisalfaService sisalfaService;
    private List<Integer> randomChallenges;
    private ConvertTextToSpeech convertTextToSpeech;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private int challengeTextViewID;
    private int heartCount = 0;
    private String themeID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        startActivity(new Intent(this, PopUp.class));

        //get the components reference from XML layout.
        this.playIV = findViewById(R.id.btnPlay);
        playIV.setOnClickListener(this);
        this.wordTV = findViewById(R.id.textView);
        this.firstIV = findViewById(R.id.firstIV);
        firstIV.setOnClickListener(this);
        this.secondIV = findViewById(R.id.secondIV);
        secondIV.setOnClickListener(this);
        this.thirdIV = findViewById(R.id.thirdIV);
        thirdIV.setOnClickListener(this);
        this.helpIV = findViewById(R.id.btnHelp);
        helpIV.setOnClickListener(this);
        this.backIV = findViewById(R.id.btnBack);
        backIV.setOnClickListener(this);
        this.progressBar = findViewById(R.id.pb);
        this.firstHeart =findViewById(R.id.imageView);
        this.secondHeart = findViewById(R.id.imageView2);
        this.thirdHeart = findViewById(R.id.imageView3);
        this.convertTextToSpeech = new ConvertTextToSpeech();
        this.sisalfaService = new SisalfaMockService();
        this.randomChallenges = new ArrayList<>(3);


        progressBar.setMax(10);



        Intent it = getIntent();
        this.themeID = it.getStringExtra("theme");


        try {
            this.challengeTextViewID = displayChallengeOnScreen();
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
            challengeTextViewID = displayChallengeOnScreen();
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

    private int displayChallengeOnScreen() throws RemoteException {
        getRandom(themeID);
        List<Challenge> challenges = sisalfaService.getChallengesByTheme(themeID);
        firstIV.setImageResource(challenges.get(randomChallenges.get(0)).getImage());
        firstIV.setTag(challenges.get(randomChallenges.get(0)).getImage());

        secondIV.setImageResource(challenges.get(randomChallenges.get(1)).getImage());
        secondIV.setTag(challenges.get(randomChallenges.get(1)).getImage());

        thirdIV.setImageResource(challenges.get(randomChallenges.get(2)).getImage());
        thirdIV.setTag(challenges.get(randomChallenges.get(2)).getImage());

        int rnd = new Random().nextInt(3);
        wordTV.setText(String.valueOf(challenges.get(randomChallenges.get(rnd)).getWord()));

        return challenges.get(rnd).getImage();

    }

    private void getRandom(String themesId) throws RemoteException {
        randomChallenges = new ArrayList<>(3);
        for(int k = 0; k < 3; k++){
            int rnd = new Random().nextInt(sisalfaService.getChallengesByTheme(themesId).size());
            if(!randomChallenges.contains(rnd)){
                randomChallenges.add(rnd);
            }

        }
    }
}
