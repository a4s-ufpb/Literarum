package com.example.rynzler.literarum;

import android.app.Activity;
import android.content.Intent;
import android.os.RemoteException;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rynzler.literarum.models.Challenge;
import com.example.rynzler.literarum.models.Theme;
import com.example.rynzler.literarum.sisalfaservice.SisalfaMockService;
import com.example.rynzler.literarum.sisalfaservice.SisalfaService;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by rynzler on 05/01/18.
 */

public class GameManager extends Activity{

    private SisalfaService sisalfaService;
    private ConvertTextToSpeech convertTextToSpeech;
    private List<Integer> randomChallenges;

    public GameManager(){
        this.sisalfaService = new SisalfaMockService();
        this.convertTextToSpeech = new ConvertTextToSpeech();
        this.randomChallenges = new ArrayList<Integer>(3);
    }

    public int displayChallengeOnScreen(ImageView firstIV, ImageView secondIV, ImageView thirdIV,
    TextView wordTV, String challengesId) throws RemoteException {
        getRandom(challengesId);
        List<Challenge> challenges = sisalfaService.getChallengesByTheme(challengesId);
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

    private List<Integer> getRandom(String challengesId) throws RemoteException {
        for(int k = 0; k < 3; k++){
            int rnd = new Random().nextInt(sisalfaService.getChallengesByTheme(challengesId).size());
            if(!randomChallenges.contains(rnd)){
                randomChallenges.add(rnd);
            }

        }
        return randomChallenges;
    }





}
