package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */

public class SisContext {

    private int id;
    private String name;
    private String image;
    private String sound;
    private String video;
    private long author;
    private transient byte[] imageBytes;

    public SisContext(int id, String name, String image, String sound, String video, long author, byte[] imageBytes) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.sound = sound;
        this.video = video;
        this.author = author;
        this.imageBytes = imageBytes;
    }



    public SisContext(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public String toString(){
        return Long.toString(this.id);
    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }
}