package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */

public class SisContext {
    private String name;
    private int id;
    private int authorId;
    private String image;
    private String sound;
    private String video;
    private String createdAt;
    private String updatedAt;

    public static final String DEFAULT_CONTEXT_NAME = "Empty Challenge";
    public static final int DEFAULT_CONTEXT_ID = -1;

    public SisContext() {
        this(DEFAULT_CONTEXT_NAME, DEFAULT_CONTEXT_ID, User.DEFAULT_USER_ID, null,null,null, null, null);
    }

    public SisContext(String name, int id, int authorId, String image, String sound, String video, String createdAt, String updatedAt) {
        this.name = name;
        this.id = id;
        this.authorId = authorId;
        this.image = image;
        this.sound = sound;
        this.video = video;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getContextId() {
        return id;
    }

    public void setContextId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return authorId;
    }

    public void setUserId(int userId) {
        this.authorId = userId;
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
        return video;
    }

    public void setVideoUrl(String video) {
        this.video = video;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public void setAuthorId(int authorId) {
        this.authorId = authorId;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getAuthorId() {
        return authorId;
    }

    public String getVideo() {
        return video;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "SisContext [name=" + name + ", themeId=" + id + ", userId=" + authorId + ", image=" + image
                + ", sound=" + sound + ", video=" + video + "]";
    }
}
