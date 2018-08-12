package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 18/02/18.
 */
public class Challenge {

    private int id;
    private String word;
    private String image;
    private String sound;
    private String video;
    private long author;
    private SisContext context;
    private transient byte[] imageBytes;

    public Challenge(int id, String word, String image, String sound, String video, long author,byte[] imageBytes) {
        this.id = id;
        this.word = word;
        this.image = image;
        this.sound = sound;
        this.video = video;
        this.author = author;
        this.imageBytes = imageBytes;
    }

    public Challenge(){

    }

    public byte[] getImageBytes() {
        return imageBytes;
    }

    public void setImageBytes(byte[] imageBytes) {
        this.imageBytes = imageBytes;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getWord() {
        return word;
    }

    public void setWord(String word) {
        this.word = word;
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

    public long getAuthor() {
        return author;
    }

    public void setAuthor(long author) {
        this.author = author;
    }

    public SisContext getContext() {
        return context;
    }

    public void setContext(SisContext context) {
        this.context = context;
    }
}