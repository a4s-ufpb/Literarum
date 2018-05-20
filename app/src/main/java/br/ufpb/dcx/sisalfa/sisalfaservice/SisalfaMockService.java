package br.ufpb.dcx.sisalfa.sisalfaservice;

import br.ufpb.dcx.sisalfa.models.SisContext;
import br.ufpb.dcx.sisalfa.models.DataAlreadyExistsException;
import br.ufpb.dcx.sisalfa.models.DataNotFoundException;
import br.ufpb.dcx.sisalfa.models.Challenge;
import br.ufpb.dcx.sisalfa.models.User;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rynzler on 29/03/18.
 */

public class SisalfaMockService implements  SisalfaService{
    protected List<User> users;
    protected List<Challenge> challenges;
    protected List<SisContext> sisContexts;
    private static int nextUserId = 0;
    private static int nextChallengeId = 0;
    private static int nextContextId = 0;


    private synchronized static int getNextContextId() {
        int id = nextContextId++;
        return id;
    }

    private synchronized static int getNextChallengeId() {
        int id = nextChallengeId++;
        return id;
    }

    private synchronized static int getNextUserId() {
        int id = nextUserId++;
        return id;
    }

    public SisalfaMockService() {
        this.users = new ArrayList<User>();
        this.challenges = new ArrayList<Challenge>();
        this.sisContexts = new ArrayList<SisContext>();
    }
    @Override
    public int addContext(SisContext sisContext) throws DataAlreadyExistsException {
        if (this.sisContexts.contains(sisContext)) {
            throw new DataAlreadyExistsException();
        } else {
            if (sisContext.getContextId() == (SisContext.DEFAULT_CONTEXT_ID)) {
                sisContext.setContextId(getNextContextId());
            }
            this.sisContexts.add(sisContext);
            return sisContext.getContextId();
        }
    }

    @Override
    public List<SisContext> getAllContexts() {
        return this.sisContexts;
    }

    @Override
    public List<SisContext> getAllContextsOfUser(int idUser) {
        List<SisContext> themesOfUser = new ArrayList<SisContext>();
        for (SisContext c: this.sisContexts) {
            if (c.getUserId() == (idUser)) {
                themesOfUser.add(c);
            }
        }
        return themesOfUser;
    }
    @Override
    public SisContext getContext(int idContext) {
        for (SisContext c: this.sisContexts) {
            if (c.getContextId() == (idContext)) {
                return c;
            }
        }
        return null;
    }
    @Override
    public void updateContext(SisContext sisContext) throws DataNotFoundException {
        for (SisContext c: this.sisContexts) {
            if (c.getContextId() == (sisContext.getContextId())) {
                this.sisContexts.remove(c);
                this.sisContexts.add(sisContext);
                return;
            }
        }
        throw new DataNotFoundException("SisContext not found. Id:"+ sisContext.getContextId());
    }
    @Override
    public void deleteContext(int idContext) throws DataNotFoundException{
        for (SisContext c: this.sisContexts) {
            if (c.getContextId() == (idContext) ) {
                this.sisContexts.remove(c);
                return;
            }
        }
        throw new DataNotFoundException("SisContext not found. Id:"+idContext);
    }

    @Override
    public int addChallenge(Challenge challenge) throws DataAlreadyExistsException{
        if (this.challenges.contains(challenge)) {
            throw new DataAlreadyExistsException("This challenge already exists. Id:"+challenge.getChallengeId());
        } else {
            if (challenge.getChallengeId() == (Challenge.DEFAULT_CHALLENGE_ID)) {
                challenge.setChallengeId(getNextChallengeId());
            }
            this.challenges.add(challenge);
            return challenge.getChallengeId();
        }
    }
    @Override
    public void updateChallenge(Challenge newChallenge) throws DataNotFoundException{
        for (Challenge c: this.challenges) {
            if (c.getChallengeId() == (newChallenge.getChallengeId())) {
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
    public List<Challenge> getAllChallengesOfUser(int idUser) {
        List<Challenge> challengesOfUser = new ArrayList<Challenge>();
        for (Challenge c: this.challenges) {
            if (c.getUserId() == (idUser)) {
                challengesOfUser.add(c);
            }
        }
        return challengesOfUser;
    }
    @Override
    public Challenge getChallenge(int idChallenge) throws DataNotFoundException{
        for (Challenge c: this.challenges) {
            if (c.getChallengeId() == (idChallenge)) {
                return c;
            }
        }
        throw new DataNotFoundException("Challenge not found. Id:"+idChallenge);
    }
    @Override
    public List<Challenge> getChallengesByContext(int idContext) {
        List<Challenge> challengesByContext = new ArrayList<Challenge>();
        for (Challenge c: this.challenges) {
            if (c.getContextId() == (idContext)) {
                challengesByContext.add(c);
            }
        }
        return challengesByContext;
    }
    @Override
    public int addUser(User user) throws DataAlreadyExistsException {
        if (this.users.contains(user)) {
            throw new DataAlreadyExistsException("User already exists. Id:"+user.getUserId());
        } else {
            if (user.getUserId() == (User.DEFAULT_USER_ID)) {
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
    public User getUser(int idUser) throws DataNotFoundException{
        for (User u: this.users) {
            if (u.getUserId()==(idUser)) {
                return u;
            }
        }
        throw new DataNotFoundException("User not found. Id:"+idUser);
    }

    @Override
    public void deleteChallenge(int idChallenge) throws DataNotFoundException{
        for (Challenge c: this.challenges) {
            if (c.getChallengeId() == (idChallenge)) {
                this.challenges.remove(c);
                return;
            }
        }
        throw new DataNotFoundException("Challenge not found. Id:"+idChallenge);
    }
    @Override
    public void deleteUser(int idUser) throws DataNotFoundException{
        for (User u: this.users) {
            if (u.getUserId() == (idUser)) {
                this.users.remove(u);
                return;
            }
        }
        throw new DataNotFoundException("User not found. Id:"+idUser);
    }

    @Override
    public void updateUser(User user) throws DataNotFoundException{
        for (User u: this.users) {
            if (u.getUserId() ==(user.getUserId())) {
                this.users.remove(u);
                this.users.add(user);
                return;
            }
        }
        throw new DataNotFoundException("User not found. Id:"+user.getUserId());
    }



}

