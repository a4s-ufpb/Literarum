package br.ufpb.dcx.sisalfa.activities;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import com.example.rynzler.literarum.R;
import br.ufpb.dcx.sisalfa.database.SisalfaRepository;
import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{

    public static final String FEATURE_NOT_SUPPORTED = "Feature not supported in your device.";

    private ImageView firstIV;
    private ImageView secondIV;
    private ImageView thirdIV;
    private ImageView firstHeart;
    private ImageView secondHeart;
    private ImageView thirdHeart;
    private TextView wordTV;
    private List<Integer> challenges;
    private ProgressBar progressBar;
    private List<Challenge> challengesList;

    private int progressStatus = 0;
    private int challengeTextViewID;
    private int heartCount = 0;
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
        ImageView playIV = findViewById(R.id.btnPlay);
        playIV.setOnClickListener(this);
        this.wordTV = findViewById(R.id.textView);
        this.firstIV = findViewById(R.id.firstIV);
        firstIV.setOnClickListener(this);
        this.secondIV = findViewById(R.id.secondIV);
        secondIV.setOnClickListener(this);
        this.thirdIV = findViewById(R.id.thirdIV);
        thirdIV.setOnClickListener(this);

        ImageView helpIV = findViewById(R.id.btnHelp);
        helpIV.setOnClickListener(this);
        ImageView backIV = findViewById(R.id.btnBack);
        backIV.setOnClickListener(this);



        this.progressBar = findViewById(R.id.pb);
        this.firstHeart =findViewById(R.id.imageView);
        this.secondHeart = findViewById(R.id.imageView2);
        this.thirdHeart = findViewById(R.id.imageView3);

        SisalfaRepository db = new SisalfaRepository(getApplicationContext());


        progressBar.setMax(10);
        textToSpeechConverter();


        Intent it = getIntent();
        int themeID = it.getIntExtra("theme", -1);
        System.out.println(themeID);
        this.challengesList = db.getChallengesByContext(themeID);
        System.out.println("TAMANHO" + db.getChallengesByContext(themeID).size());


        this.challengeTextViewID = displayChallengeOnScreen();




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
                checkAnswer((int) firstIV.getTag());
                break;
            case R.id.secondIV:
                checkAnswer((int) secondIV.getTag());
                break;
            case R.id.thirdIV:
                checkAnswer((int) thirdIV.getTag());
                break;
        }

    }

    private void checkAnswer(int id)  {
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

    private int displayChallengeOnScreen() {
        randomChallenges();

        firstIV.setImageBitmap(AndroidUtils.ByteArrayToBitmap(challengesList.get(challenges.get(0)).getImageBytes()));
        firstIV.setTag(challengesList.get(challenges.get(0)).getId());

        System.out.println("ID DO DESAFIO 1: " +challengesList.get(challenges.get(0)).getId());

        secondIV.setImageBitmap(AndroidUtils.ByteArrayToBitmap(challengesList.get(challenges.get(1)).getImageBytes()));
        secondIV.setTag(challengesList.get(challenges.get(1)).getId());

        System.out.println("ID DO DESAFIO 2: " +challengesList.get(challenges.get(1)).getId());

        thirdIV.setImageBitmap(AndroidUtils.ByteArrayToBitmap(challengesList.get(challenges.get(2)).getImageBytes()));
        thirdIV.setTag(challengesList.get(challenges.get(2)).getId());

        System.out.println("ID DO DESAFIO 3: " +challengesList.get(challenges.get(2)).getId());

        int rnd = new Random().nextInt(3);
        wordTV.setText(String.valueOf(challengesList.get(challenges.get(rnd)).getWord()));

        System.out.println("ID retornado: " + challengesList.get(challenges.get(rnd)).getId());

        return challengesList.get(challenges.get(rnd)).getId();

    }

    private void randomChallenges() {
        this.challenges = new ArrayList<>(3);
        for(int k = 0; k < 3; ){
            int rnd = new Random()
                    .nextInt(challengesList.size());

            if (!challenges.contains(rnd)) {
                challenges.add(rnd);
                k++;
                System.out.println("adicionando posição do challenge: " + rnd);
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

    @Override
    protected void onDestroy() {


        //Close the Text to Speech Library
        if(textToSpeech != null) {

            textToSpeech.stop();
            textToSpeech.shutdown();
            Log.d("TAG", "TTS Destroyed");
        }
        super.onDestroy();
    }

}
