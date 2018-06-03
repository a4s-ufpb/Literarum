package br.ufpb.dcx.sisalfa.activities;

import android.content.Intent;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.rynzler.literarum.R;

import java.util.List;

import br.ufpb.dcx.sisalfa.connection.ConnectionAPI;
import br.ufpb.dcx.sisalfa.database.SisalfaRepository;
import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.models.User;
import br.ufpb.dcx.sisalfa.sisalfaservice.SisalfaMockService;

public class ThemesActivity extends AppCompatActivity implements View.OnClickListener{
    private SisalfaMockService sisalfaMockService;
    private SisalfaRepository sisalfaRepository;
    private ConnectionAPI connectionAPI;
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

        this.sisalfaRepository= new SisalfaRepository(getApplicationContext());
        this.sisalfaMockService = new SisalfaMockService();
        this.connectionAPI =  new ConnectionAPI();
        connectionAPI.startContexts();
        connectionAPI.startChallenges();
        connectionAPI.startUsers();
        sisalfaMockService = connectionAPI.getSisalfaMockServices();
        tableCreator();

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

    private void tableCreator(){
        if(sisalfaRepository.getAllContexts() == null){
            for(SisContext sc: sisalfaMockService.getAllContexts()){
                sisalfaRepository.createContext(sc);
            }
        }else{
            for(SisContext sc: sisalfaMockService.getAllContexts()){
                if(sisalfaRepository.getAllContexts().contains(sc)){
                    Log.i("TAG", "Object already exist.");
                }
                else{
                    sisalfaRepository.createContext(sc);
                }

            }
        }

        if(sisalfaRepository.getAllChallenges() == null){
            for(Challenge c: sisalfaMockService.getAllChallenges()){
                sisalfaRepository.createChallenge(c);
            }
        }else{
            for(Challenge c: sisalfaMockService.getAllChallenges()){
                if(sisalfaRepository.getAllChallenges().contains(c)){
                    Log.i("TAG", "Object already exist.");
                }
                else{
                    sisalfaRepository.createChallenge(c);
                }

            }
        }

        if(sisalfaRepository.getAllUsers() == null){
            for(User u: sisalfaMockService.getAllUsers()){
                sisalfaRepository.createUser(u);
            }
        }else{
            for(User u: sisalfaMockService.getAllUsers()){
                if(sisalfaRepository.getAllUsers().contains(u)){
                    Log.i("TAG", "Object already exist.");
                }
                else{
                    sisalfaRepository.createUser(u);
                }

            }
        }
    }
}
