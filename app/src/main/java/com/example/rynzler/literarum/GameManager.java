package com.example.rynzler.literarum;

import android.util.Log;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynzler on 05/01/18.
 */

public class GameManager implements Serializable{

    private List<GameTheme> themes;

    public GameManager(List<GameTheme> themes) {
        this.themes = themes;
    }

    public GameManager(){
        this.themes = new ArrayList<GameTheme>();
    }

    public List<GameTheme> getThemes() {
        return this.themes;
    }

    public void setThemes(List<GameTheme> themes) {
        this.themes = themes;
    }

    public void removeColorTheme(GameTheme gameTheme){
        if(themes.contains(gameTheme))
            themes.remove(gameTheme);
        else
            Log.i("LOG", "Theme doesn't exist.");

    }

    public void addTheme(GameTheme gameTheme){
        this.themes.add(gameTheme);
    }

    public GameTheme getSpecificTheme(String name){
        for(GameTheme gt: this.themes){
            if(gt.getName().equals(name)){
                return gt;
            }
        }return  null;
    }
}
