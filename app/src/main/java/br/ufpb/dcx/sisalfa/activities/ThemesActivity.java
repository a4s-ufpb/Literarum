package br.ufpb.dcx.sisalfa.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rynzler.literarum.R;


import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import br.ufpb.dcx.sisalfa.connection.ConnectionAPI;
import br.ufpb.dcx.sisalfa.database.FilledData;
import br.ufpb.dcx.sisalfa.database.SisalfaRepository;

import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.util.AndroidUtils;


public class ThemesActivity extends AppCompatActivity implements View.OnClickListener{
    private ImageView configButton;
    private ImageView btnHelp;
    private ConnectionAPI connectionAPI;
    private TextView titleThemes;
    private List<ImageView> contextsImages;
    private List<TextView> contextsNames;
    private ImageView firstIV,
            secondIV,
            thirdIV,
            fourthIV,
            fifthIV,
            sixthIV;


    private TextView firstTV,
            secondTV,
            thirdTV,
            fourthTV,
            fifthTV,
            sixthTV;

    private SisalfaRepository db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_themes);
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.configButton = findViewById(R.id.configButton);
        this.btnHelp = findViewById(R.id.btnHelp);


        this.titleThemes = findViewById(R.id.titleTheme);
        this.firstIV = findViewById(R.id.view1Id);
        firstIV.setOnClickListener(this);
        this.secondIV = findViewById(R.id.view2Id);
        secondIV.setOnClickListener(this);
        this.thirdIV = findViewById(R.id.view3Id);
        thirdIV.setOnClickListener(this);
        this.fourthIV = findViewById(R.id.view4Id);
        fourthIV.setOnClickListener(this);
        this.fifthIV =  findViewById(R.id.view5Id);
        fifthIV.setOnClickListener(this);
        this.sixthIV = findViewById(R.id.view6Id);
        sixthIV.setOnClickListener(this);

        this.firstTV = findViewById(R.id.txt1Id);
        this.secondTV = findViewById(R.id.txt2Id);
        this.thirdTV = findViewById(R.id.txt3Id);
        this.fourthTV = findViewById(R.id.txt4Id);
        this.fifthTV = findViewById(R.id.txt5Id);
        this.sixthTV = findViewById(R.id.txt6Id);

        this.contextsImages = new ArrayList<>
                (Arrays.asList(firstIV, secondIV, thirdIV, fourthIV, fifthIV, sixthIV));
        this.contextsNames = new ArrayList<>
                (Arrays.asList(firstTV, secondTV, thirdTV, fourthTV, fifthTV, sixthTV));

        this.db = new SisalfaRepository(this);

        this.connectionAPI = new ConnectionAPI(getApplicationContext());


       displayContextsOnScreen();



    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, GameActivity.class);
        switch (view.getId()){
            case R.id.view1Id:
                it.putExtra("theme", (int) firstIV.getTag());
                break;
            case R.id.view2Id:
                it.putExtra("theme", (int) secondIV.getTag());
                break;
            case R.id.view3Id:
                it.putExtra("theme", (int) thirdIV.getTag());
                break;
            case R.id.view4Id:
                it.putExtra("theme", (int) fourthIV.getTag());
                break;
            case R.id.view5Id:
                it.putExtra("theme", (int) fifthIV.getTag());
                break;
            case R.id.view6Id:
                it.putExtra("theme", (int) sixthIV.getTag());
                break;
        }
        startActivity(it);

    }
    public void configStarter(View view){
        startActivity(new Intent(this, ConfigActivity.class));
    }
    public void helpThemes(View view){
        startActivity(new Intent(this, themeHelp.class));
    }

    public void displayContextsOnScreen(){
        int aux = 0;
        if(db.getAllContexts() != null){
            for (SisContext sc: db.getAllContexts()){
                if(aux == 6){
                    break;
                }contextsImages.get(aux).setImageBitmap(AndroidUtils.ByteArrayToBitmap(sc.getImageBytes()));
                contextsNames.get(aux).setText(sc.getName().toUpperCase());
                contextsImages.get(aux).setTag(sc.getId());
                aux++;
            }
        }

    }


    @Override
    protected void onPause() {
        super.onPause();
        db.closeDB();
    }

    @Override
    protected void onStop() {
        super.onStop();
        db.closeDB();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        db.closeDB();
    }
}
