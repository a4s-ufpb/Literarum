package com.example.rynzler.literarum.sisalfaservice;

import com.example.rynzler.literarum.exceptions.DataAlreadyExistsException;
import com.example.rynzler.literarum.exceptions.DataNotFoundException;
import com.example.rynzler.literarum.models.Challenge;
import com.example.rynzler.literarum.models.Theme;
import com.example.rynzler.literarum.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynzler on 29/03/18.
 */

public class SisalfaMockService implements  SisalfaService{
    private List<User> users;
    private List<Challenge> challenges;
    private List<Theme> themes;
    private static int nextUserId = 0;
    private static int nextChallengeId = 0;
    private static int nextContextId = 0;


    private synchronized static String getNextContextId() {
        String id = "CtxID:"+nextContextId++;
        return id;
    }

    private synchronized static String getNextChallengeId() {
        String id = "ChID:"+nextChallengeId++;
        return id;
    }

    private synchronized static String getNextUserId() {
        String id = "UsrID:"+nextUserId++;
        return id;
    }

    public SisalfaMockService() {
        this.users = new ArrayList<User>();
        this.challenges = new ArrayList<Challenge>();
        this.themes = new ArrayList<Theme>();
    }
    @Override
    public String addTheme(Theme theme) throws DataAlreadyExistsException {
        if (this.themes.contains(theme)) {
            throw new DataAlreadyExistsException();
        } else {
            if (theme.getThemeId().equals(Theme.DEFAULT_CONTEXT_ID)) {
                theme.setThemeId(getNextContextId());
            }
            this.themes.add(theme);
            return theme.getThemeId();
        }
    }

    @Override
    public List<Theme> getAllThemes() {
        return this.themes;
    }

    @Override
    public List<Theme> getAllThemesOfUser(String idUser) {
        List<Theme> themesOfUser = new ArrayList<Theme>();
        for (Theme c: this.themes) {
            if (c.getUserId().equals(idUser)) {
                themesOfUser.add(c);
            }
        }
        return themesOfUser;
    }
    @Override
    public Theme getTheme(String idTheme) {
        for (Theme c: this.themes) {
            if (c.getThemeId().equals(idTheme)) {
                return c;
            }
        }
        return null;
    }
    @Override
    public void updateTheme(Theme theme) throws DataNotFoundException{
        for (Theme c: this.themes) {
            if (c.getThemeId().equals(theme.getThemeId())) {
                this.themes.remove(c);
                this.themes.add(theme);
                return;
            }
        }
        throw new DataNotFoundException("Context not found. Id:"+theme.getThemeId());
    }
    @Override
    public void deleteTheme(String idContext) throws DataNotFoundException{
        for (Theme c: this.themes) {
            if (c.getThemeId().equals(idContext) ) {
                this.themes.remove(c);
                return;
            }
        }
        throw new DataNotFoundException("Context not found. Id:"+idContext);
    }

    @Override
    public String addChallenge(Challenge challenge) throws DataAlreadyExistsException{
        if (this.challenges.contains(challenge)) {
            throw new DataAlreadyExistsException("This challenge already exists. Id:"+challenge.getChallengeId());
        } else {
            if (challenge.getChallengeId().equals(Challenge.DEFAULT_CHALLENGE_ID)) {
                challenge.setChallengeId(getNextChallengeId());
            }
            this.challenges.add(challenge);
            return challenge.getChallengeId();
        }
    }
    @Override
    public void updateChallenge(Challenge newChallenge) throws DataNotFoundException{
        for (Challenge c: this.challenges) {
            if (c.getChallengeId().equals(newChallenge.getChallengeId())) {
                this.challenges.remove(c);
                this.challenges.add(newChallenge);
                return;
            }
        }
        throw new DataNotFoundException("Challenge not found. Id:"+newChallenge.getChallengeId());
    }
    @Override
    public List<Challenge> getAllChallenges() {
        return this.challenges;
    }
    @Override
    public List<Challenge> getAllChallengesOfUser(String idUser) {
        List<Challenge> challengesOfUser = new ArrayList<Challenge>();
        for (Challenge c: this.challenges) {
            if (c.getUserId().equals(idUser)) {
                challengesOfUser.add(c);
            }
        }
        return challengesOfUser;
    }
    @Override
    public Challenge getChallenge(String idChallenge) throws DataNotFoundException{
        for (Challenge c: this.challenges) {
            if (c.getChallengeId().equals(idChallenge)) {
                return c;
            }
        }
        throw new DataNotFoundException("Challenge not found. Id:"+idChallenge);
    }
    @Override
    public List<Challenge> getChallengesByTheme(String idContext) {
        List<Challenge> challengesByContext = new ArrayList<Challenge>();
        for (Challenge c: this.challenges) {
            if (c.getThemeId().equals(idContext)) {
                challengesByContext.add(c);
            }
        }
        return challengesByContext;
    }
    @Override
    public String addUser(User user) throws DataAlreadyExistsException {
        if (this.users.contains(user)) {
            throw new DataAlreadyExistsException("User already exists. Id:"+user.getUserId());
        } else {
            if (user.getUserId().equals(User.DEFAULT_USER_ID)) {
                user.setUserId(getNextUserId());
            }
            this.users.add(user);
            return user.getUserId();
        }

    }
    @Override
    public List<User> getAllUsers() {
        return this.users;
    }
    @Override
    public User getUser(String idUser) throws DataNotFoundException{
        for (User u: this.users) {
            if (u.getUserId().equals(idUser)) {
                return u;
            }
        }
        throw new DataNotFoundException("User not found. Id:"+idUser);
    }

    @Override
    public void deleteChallenge(String idChallenge) throws DataNotFoundException{
        for (Challenge c: this.challenges) {
            if (c.getChallengeId().equals(idChallenge)) {
                this.challenges.remove(c);
                return;
            }
        }
        throw new DataNotFoundException("Challenge not found. Id:"+idChallenge);
    }
    @Override
    public void deleteUser(String idUser) throws DataNotFoundException{
        for (User u: this.users) {
            if (u.getUserId().equals(idUser)) {
                this.users.remove(u);
                return;
            }
        }
        throw new DataNotFoundException("User not found. Id:"+idUser);
    }

    @Override
    public void updateUser(User user) throws DataNotFoundException{
        for (User u: this.users) {
            if (u.getUserId().equals(user.getUserId())) {
                this.users.remove(u);
                this.users.add(user);
                return;
            }
        }
        throw new DataNotFoundException("User not found. Id:"+user.getUserId());
    }



}

