package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */

public class Challenge{

    private String word;
    private int challengeId;
    private int contextId;
    private int userId;
    private String sound;
    private String videoUrl;
    private int image;


    public static final String DEFAULT_CHALLENGE_WORD = "Empty Challenge";
    public static final int DEFAULT_CHALLENGE_ID = -1;


    public Challenge(){
        this(DEFAULT_CHALLENGE_WORD, DEFAULT_CHALLENGE_ID, User.DEFAULT_USER_ID, SisContext.DEFAULT_CONTEXT_ID, 0, null, null);
    }

    public Challenge(String word,int challengeId, int userId, int contextId, int image,
    String sound, String videoUrl) {
        super();
        this.word = word;
        this.challengeId = challengeId;
        this.userId = userId;
        this.contextId = contextId;
        this.image = image;
        this.sound = sound;
        this.videoUrl = videoUrl;

    }

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getChallengeId() {
        return challengeId;
    }


    public void setChallengeId(int challengeId) {
        this.challengeId = challengeId;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public int getContextId() {
        return contextId;
    }


    public void setContextId(int contextId) {
        this.contextId = contextId;
    }


    public String getSound() {
        return sound;
    }


    public void setSound(String sound) {
        this.sound = sound;
    }


    public String getVideoUrl() {
        return videoUrl;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Challenge [word=" + word + ", challengeId=" + challengeId + ", userId=" + userId + ", contextId="
                + contextId + ", sound=" + sound + ", videoUrl=" + videoUrl + ", image=" + image + "]";
    }


}
