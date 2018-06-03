package br.ufpb.dcx.sisalfa.models;

/**
 * Created by rynzler on 29/03/18.
 */

public class User {

    public static final String DEFAULT_USER_NAME = "Anonymous";
    public static final int DEFAULT_USER_ID = -1;

    private int id;
    private String username;
    private String password;
    private String email;
    private String firstName;
    private String lastName;
    private String photo;


    public User(int id, String username, String password, String email, String firstName, String lastName, String photo) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.photo = photo;
    }

    public User() {
        this.username = DEFAULT_USER_NAME;
        this.id = DEFAULT_USER_ID;
    }

    public String getUserName() {
        return username;
    }


    public void setUserName(String user_name) {
        this.username = user_name;
    }


    public int getUserId() {
        return id;
    }


    public void setUserId(int userId) {
        this.id = userId;
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
        return firstName;
    }

    public void setFirst_name(String first_name) {
        this.firstName = first_name;
    }

    public String getLast_name() {
        return lastName;
    }

    public void setLast_name(String last_name) {
        this.lastName = last_name;
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
                "userId='" + id + '\'' +
                ", user_name='" + username + '\'' +
                ", password=" + password +
                ", email='" + email + '\'' +
                ", first_name='" + firstName + '\'' +
                ", last_name='" + lastName + '\'' +
                ", photo='" + photo + '\'' +
                '}';
    }


}
