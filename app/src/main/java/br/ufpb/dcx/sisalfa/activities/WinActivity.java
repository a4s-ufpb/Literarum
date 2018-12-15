package br.ufpb.dcx.sisalfa.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rynzler.literarum.R;

public class WinActivity extends Activity implements View.OnClickListener{
    private TextView stats;
    private ImageView homeBtn;
    private ImageView tryAgainBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_win);
        displayMetricsManager();
        int correctAnswers = getIntent().getIntExtra("ca", -1);
        int numberChallenges = getIntent().getIntExtra("cn", -1);
        int wrongAnswers = getIntent().getIntExtra("wa", -1);
        this.stats = findViewById(R.id.stats);
        this.homeBtn = findViewById(R.id.homewinbtn);
        homeBtn.setOnClickListener(this);
        this.tryAgainBtn = findViewById(R.id.tryagainwinbtn);
        tryAgainBtn.setOnClickListener(this);
        stats.setText("Total de desafios: "+numberChallenges+"/nErros: "+wrongAnswers);

    }

    public void displayMetricsManager(){
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int width = dm.widthPixels;
        int heigth = dm.heightPixels;
        getWindow().setLayout((int) (width * .8), (int) (heigth * .6));
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.homewinbtn:
                startActivity(new Intent(this, ThemesActivity.class));
                break;
            case R.id.tryagainwinbtn:
                finish();
                break;
        }
    }
}
