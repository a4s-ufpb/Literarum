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
    private ConnectionAPI connectionAPI;
    private TextView titleThemes;
    private List<ImageView> contextsViews;
    private ImageView firstIV;
    private ImageView secondIV;
    private ImageView thirdIV;
    private ImageView fourthIV;
    private ImageView fifthIV;
    private ImageView sixthIV;
    private SisalfaRepository db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_themes);
        Typeface typeface = Typeface.createFromAsset(
                getAssets(), "From Cartoon Blocks.ttf");
        StrictMode.ThreadPolicy policy = new
                StrictMode.ThreadPolicy.Builder().permitAll().build();
        StrictMode.setThreadPolicy(policy);
        this.configButton = findViewById(R.id.configButton);

        this.titleThemes = findViewById(R.id.titleTheme);
        titleThemes.setTypeface(typeface);
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

        this.contextsViews = new ArrayList<>
                (Arrays.asList(firstIV, secondIV, thirdIV, fourthIV, fifthIV, sixthIV));

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

    public void displayContextsOnScreen(){
        int aux = 0;
        if(db.getAllContexts() != null){
            for (SisContext sc: db.getAllContexts()){
                if(aux == 6){
                    break;
                }contextsViews.get(aux).setImageBitmap(AndroidUtils.ByteArrayToBitmap(sc.getImageBytes()));
                contextsViews.get(aux).setTag(sc.getId());
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
