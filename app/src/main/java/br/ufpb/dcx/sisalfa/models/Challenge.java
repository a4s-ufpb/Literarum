package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */

public class Challenge{


    private String word;
    private int id;
    private int contextId;
    private int authorId;
    private String sound;
    private String video;
    private String image;


    public static final String DEFAULT_CHALLENGE_WORD = "Empty Challenge";
    public static final int DEFAULT_CHALLENGE_ID = -1;


    public Challenge(){
        this(DEFAULT_CHALLENGE_WORD, DEFAULT_CHALLENGE_ID, User.DEFAULT_USER_ID, SisContext.DEFAULT_CONTEXT_ID, null, null, null);
    }

    public Challenge(String word,int id, int authorId, int contextId, String image,
    String sound, String videoUrl) {
        super();
        this.word = word;
        this.id = id;
        this.authorId = authorId;
        this.contextId = contextId;
        this.image = image;
        this.sound = sound;
        this.video = videoUrl;

    }

    public void setVideoUrl(String videoUrl) {
        this.video = videoUrl;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public int getChallengeId() {
        return id;
    }


    public void setChallengeId(int challengeId) {
        this.id = challengeId;
    }


    public int getUserId() {
        return authorId;
    }


    public void setUserId(int authorId) {
        this.authorId = authorId;
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
        return video;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Challenge [word=" + word + ", challengeId=" + id + ", userId=" + authorId + ", contextId="
                + contextId + ", sound=" + sound + ", videoUrl=" + video + ", image=" + image + "]";
    }


}
