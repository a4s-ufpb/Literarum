package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 29/03/18.
 */

public class User {

    public static final String DEFAULT_USER_NAME = "Anonymous";
    public static final int DEFAULT_USER_ID = -1;

    private int userId;
    private int contextId;
    private String user_name;
    private String password;
    private String email;
    private String first_name;
    private String last_name;
    private String photo;


    public User(int userId, String user_name, String password, String email, String first_name, String last_name, String photo) {
        this.userId = userId;
        this.user_name = user_name;
        this.password = password;
        this.email = email;
        this.first_name = first_name;
        this.last_name = last_name;
        this.photo = photo;
    }

    public User() {
        this.user_name = DEFAULT_USER_NAME;
        this.userId = DEFAULT_USER_ID;
    }

    public String getUserName() {
        return user_name;
    }


    public void setUserName(String user_name) {
        this.user_name = user_name;
    }


    public int getUserId() {
        return userId;
    }


    public void setUserId(int userId) {
        this.userId = userId;
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    @Override
    public String toString() {
        return "User{" +
                "userId='" + userId + '\'' +
                ", user_name='" + user_name + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ", first_name='" + first_name + '\'' +
                ", last_name='" + last_name + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }


}
