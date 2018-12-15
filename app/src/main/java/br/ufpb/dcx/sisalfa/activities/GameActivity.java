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
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class GameActivity extends AppCompatActivity implements View.OnClickListener{
    private int correctAnswers = 0;
    private int wrongAnswers = 0;
    private int count = 0;
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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_game);
        startActivity(new Intent(this, PopUp.class));

        //get the components reference from XML layout.
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
        Intent it = getIntent();
        int themeID = it.getIntExtra("theme", -1);
        System.out.println(themeID);
        this.challengesList = db.getChallengesByContext(themeID);
        System.out.println("TAMANHO" + db.getChallengesByContext(themeID).size());


        this.challengeTextViewID = displayChallengeOnScreen();
        progressBar.setMax(challengesList.size());
        System.out.println(challengesList.size());




    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnHelp:
                startActivity(new Intent(this, PopUp.class));
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
            wrongAnswers += 1;
            clearHeartView();
            Toast.makeText(getApplicationContext(), "Continue tentando!", Toast.LENGTH_SHORT).show();
        }else{
            correctAnswers += 1;
            progressBar();
            Toast.makeText(getApplicationContext(), "Brilhante!", Toast.LENGTH_SHORT).show();
            challengeTextViewID = displayChallengeOnScreen();
        }

    }
    public void progressBar() {
        progressStatus += 1;
        count+=1;
        progressBar.setProgress(progressStatus);
        if(progressStatus == challengesList.size()){
            progressBar.setProgress(0);
            Intent it = new Intent(this, WinActivity.class);
            it.putExtra("ca", correctAnswers);
            it.putExtra("cn", challengesList.size());
            it.putExtra("wa", wrongAnswers);
            startActivity(it);
            progressStatus = 0;
            count = 0;

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
        Collections.shuffle(challenges);
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
        wordTV.setText(String.valueOf(challengesList.get(count).getWord()));

        System.out.println("ID retornado: " + challengesList.get(challenges.get(rnd)).getId());

        return challengesList.get(count).getId();

    }

    private void randomChallenges() {
        this.challenges = new ArrayList<>(3);
        challenges.add(count);
        System.out.println(count);
        System.out.println(progressStatus);
        for(int k = 0; k < 2; ){
            int rnd = new Random()
                    .nextInt(challengesList.size());

            if (!challenges.contains(rnd)) {
                challenges.add(rnd);
                k++;
                System.out.println("adicionando posição do challenge: " + rnd);
            }

        }
    }



}
