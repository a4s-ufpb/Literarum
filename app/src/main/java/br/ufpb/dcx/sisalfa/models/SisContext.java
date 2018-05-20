package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */

public class SisContext {
    private String name;
    private int contextId;
    private int userId;
    private String image;
    private String sound;
    private String videoUrl;

    public static final String DEFAULT_CONTEXT_NAME = "Empty Challenge";
    public static final int DEFAULT_CONTEXT_ID = -1;

    public SisContext() {
        this(DEFAULT_CONTEXT_NAME, DEFAULT_CONTEXT_ID, User.DEFAULT_USER_ID, null,null,null);
    }

    public SisContext(String name, int contextId, int userId, String image, String sound, String videoUrl) {
        this.name = name;
        this.contextId = contextId;
        this.userId = userId;
        this.image = image;
        this.sound = sound;
        this.videoUrl = videoUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContextId() {
        return contextId;
    }

    public void setContextId(int contextIdId) {
        this.contextId = contextId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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

    public void setVideoUrl(String videoUrl) {
        this.videoUrl = videoUrl;
    }

    @Override
    public String toString() {
        return "SisContext [name=" + name + ", themeId=" + contextId + ", userId=" + userId + ", image=" + image
                + ", sound=" + sound + ", videoUrl=" + videoUrl + "]";
    }
}
