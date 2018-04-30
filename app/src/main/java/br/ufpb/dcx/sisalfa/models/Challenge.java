package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */

public class Challenge{
    private String word;
    private String challengeId;
    private String userId;
    private String contextId;
    private String sound;
    private String videoUrl;
    private int image;


    public static final String DEFAULT_CHALLENGE_WORD = "Empty Challenge";
    public static final String DEFAULT_CHALLENGE_ID = "-1";


    public Challenge(){
        this(DEFAULT_CHALLENGE_WORD, DEFAULT_CHALLENGE_ID, User.DEFAULT_USER_ID, Theme.DEFAULT_CONTEXT_ID, 0, null, null);
    }

    public Challenge(String word,String challengeId, String userId, String contextId, int image,
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

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
    }

    public String getChallengeId() {
        return challengeId;
    }


    public void setChallengeId(String challengeId) {
        this.challengeId = challengeId;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }


    public String getContextId() {
        return contextId;
    }


    public void setContextId(String contextId) {
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

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((challengeId == null) ? 0 : challengeId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Challenge other = (Challenge) obj;
        if (challengeId == null) {
            if (other.challengeId != null)
                return false;
        } else if (!challengeId.equals(other.challengeId))
            return false;
        return true;
    }
}
