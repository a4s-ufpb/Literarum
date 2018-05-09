package br.ufpb.dcx.sisalfa.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rynzler.literarum.R;

public class ThemesActivity extends AppCompatActivity implements View.OnClickListener{
    private TextView titleThemes;
    private ImageView fruitsIV;
    private ImageView professionsIV;
    private ImageView animalsIV;
    private ImageView homeIV;
    private ImageView colorsIV;
    private ImageView bodyIV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_themes);
        Typeface typeface = Typeface.createFromAsset(
                getAssets(), "From Cartoon Blocks.ttf");
        this.titleThemes = findViewById(R.id.titleTheme);
        titleThemes.setTypeface(typeface);
        this.fruitsIV = findViewById(R.id.fruitId);
        fruitsIV.setOnClickListener(this);
        this.professionsIV = findViewById(R.id.professionsId);
        professionsIV.setOnClickListener(this);
        this.animalsIV = findViewById(R.id.animalsId);
        animalsIV.setOnClickListener(this);
        this.homeIV = findViewById(R.id.homeId);
        homeIV.setOnClickListener(this);
        this.bodyIV =  findViewById(R.id.bodyId);
        bodyIV.setOnClickListener(this);
        this.colorsIV = findViewById(R.id.colorsId);
        colorsIV.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        Intent it = new Intent(this, GameActivity.class);
        switch (view.getId()){
            case R.id.bodyId:
                it.putExtra("theme", "bodyThemeID");
                break;
            case R.id.animalsId:
                it.putExtra("theme", "animalsThemeID");
                break;
            case R.id.colorsId:
               it.putExtra("theme", "colorsThemeID");
                break;
            case R.id.professionsId:
                it.putExtra("theme", "professionsThemeID");
                break;
            case R.id.fruitId:
                it.putExtra("theme", "fruitsThemeID");
                break;
            case R.id.homeId:
                it.putExtra("theme", "homeThemeID");
                break;
        }
        startActivity(it);

    }
    private int getDrawableId(String drawableName){
        return getResources().getIdentifier(drawableName , "drawable", getPackageName());

    }
}
