package br.ufpb.dcx.sisalfa.models;

import java.util.List;

/**
 * Created by rynzler on 18/02/18.
 */

public class Theme {
    private String name;
    private String themeId;
    private String userId;
    private String image;
    private String sound;
    private String videoUrl;

    public static final String DEFAULT_CONTEXT_NAME = "Empty Challenge";
    public static final String DEFAULT_CONTEXT_ID = "-1";

    private List<Challenge> challenges;
    public Theme() {
        this(DEFAULT_CONTEXT_NAME, DEFAULT_CONTEXT_ID, User.DEFAULT_USER_ID, null,null,null);
    }

    public Theme(String name, String themeId, String userId, String image, String sound, String videoUrl) {
        this.name = name;
        this.themeId = themeId;
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

    public String getThemeId() {
        return themeId;
    }

    public void setThemeId(String themeId) {
        this.themeId = themeId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
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
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((themeId == null) ? 0 : themeId.hashCode());
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
        Theme other = (Theme) obj;
        if (themeId == null) {
            if (other.themeId != null)
                return false;
        } else if (!themeId.equals(other.themeId))
            return false;
        return true;
    }

    @Override
    public String toString() {
        return "Context [name=" + name + ", themeId=" + themeId + ", userId=" + userId + ", image=" + image
                + ", sound=" + sound + ", videoUrl=" + videoUrl + "]";
    }
}
