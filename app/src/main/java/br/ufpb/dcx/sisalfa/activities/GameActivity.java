package br.ufpb.dcx.sisalfa.activities;

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

import com.example.rynzler.literarum.R;

import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.sisalfaservice.SisalfaMockService;
import br.ufpb.dcx.sisalfa.sisalfaservice.SisalfaService;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String FEATURE_NOT_SUPPORTED = "Feature not supported in your device.";

    private ImageView playIV, firstIV, secondIV, thirdIV, helpIV, backIV,
            firstHeart, secondHeart, thirdHeart;
    private TextView wordTV;
    private SisalfaService sisalfaService;
    private List<Integer> challenges;
    private ProgressBar progressBar;
    private int progressStatus = 0;
    private int challengeTextViewID;
    private int heartCount = 0;
    private String themeID;
    private TextToSpeech textToSpeech;
    private int result;


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
        this.sisalfaService = new SisalfaMockService();
        this.challenges = new ArrayList<>(3);


        progressBar.setMax(10);
        textToSpeechConverter();


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
                AndroidUtils.speakOut(String.valueOf(wordTV.getText()),
                        result,
                        getApplicationContext(),
                        textToSpeech);
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
        randomChallenges(themeID);
        List<Challenge> challengesAux = sisalfaService.getChallengesByContext(themeID);
        firstIV.setImageResource(challengesAux.get(challenges.get(0)).getImage());
        firstIV.setTag(challengesAux.get(challenges.get(0)).getImage());

        secondIV.setImageResource(challengesAux.get(challenges.get(1)).getImage());
        secondIV.setTag(challengesAux.get(challenges.get(1)).getImage());

        thirdIV.setImageResource(challengesAux.get(challenges.get(2)).getImage());
        thirdIV.setTag(challengesAux.get(challenges.get(2)).getImage());

        int rnd = new Random().nextInt(3);
        wordTV.setText(String.valueOf(challengesAux.get(challenges.get(rnd)).getWord()));
        int imageIdentifier = challengesAux.get(rnd).getImage();

        return imageIdentifier;

    }

    private void randomChallenges(String themesId) throws RemoteException {
        for(int k = 0; k < 3;){
            int rnd = new Random()
                    .nextInt(sisalfaService
                            .getChallengesByContext(themesId)
                            .size());

            if (!challenges.contains(rnd)) {
                challenges.add(rnd);
                k++;
            }

        }
    }

    private void textToSpeechConverter(){
        textToSpeech = new TextToSpeech(GameActivity.this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS)
                    result = textToSpeech.setLanguage(Locale.US);
                else{
                    Toast.makeText(getApplicationContext(), FEATURE_NOT_SUPPORTED, Toast.LENGTH_SHORT).show();

                }
            }

        });
        result = 0;
    }
}
