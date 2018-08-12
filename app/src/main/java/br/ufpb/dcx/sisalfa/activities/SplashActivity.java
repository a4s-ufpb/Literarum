package br.ufpb.dcx.sisalfa.activities;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.example.rynzler.literarum.R;

import java.io.IOException;

import br.ufpb.dcx.sisalfa.connection.ConnectionAPI;
import br.ufpb.dcx.sisalfa.database.FilledData;
import br.ufpb.dcx.sisalfa.database.SisalfaRepository;

/**
 * Created by rynzler on 31/01/18.
 */

public class SplashActivity extends AppCompatActivity implements Runnable{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);
        int SDK_INT = android.os.Build.VERSION.SDK_INT;
        if (SDK_INT > 8) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder()
                    .permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }
        Handler handler = new Handler();
        handler.postDelayed(this, 1000);

    }

    @Override
    public void run() {
        FilledData fd = new FilledData(this);
        try {
            fd.execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        startActivity(new Intent(this, ThemesActivity.class));
        overridePendingTransition(android.R.anim.fade_in,android.R.anim.fade_out);
        finish();
    }
}