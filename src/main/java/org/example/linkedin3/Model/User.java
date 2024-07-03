package org.example.linkedin3.Model;
import com.fasterxml.jackson.annotation.JsonProperty;


import org.example.linkedin3.DataBase.DataBase;

import java.sql.SQLException;
import java.util.ArrayList;


public class User extends Model {
    @JsonProperty("additionalName")
    private String additionalName;
    @JsonProperty("headline")
    private String headline;
    @JsonProperty("city")
    private String city;
    @JsonProperty("id")
    private int id = -1;

    @JsonProperty("firstName")
    private String name;

    @JsonProperty("lastName")
    private String lastname;

    @JsonProperty("email")
    private String email;

    @JsonProperty("username")
    private String username;

    @JsonProperty("password")
    private String password;

    @JsonProperty("country")
    private String country;
    @JsonProperty("skills")
    private ArrayList<String> skills;
    @JsonProperty("posts")
    private ArrayList<Post> posts;
    @JsonProperty("currentPosition")
    private JobPosition currentPosition;
    @JsonProperty("education")
    private Education education;
    public User(int id,String additionalName, String headlines, String city, String country, String name, String lastname, String email, String password, String username, ArrayList<String> skills, ArrayList<Post> posts, JobPosition currentPosition, Education education) {
        this.additionalName = additionalName;
        this.headline = headlines;
        this.city = city;
        this.country = country;
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.skills = skills;
        this.posts = posts;
        this.currentPosition = currentPosition;
        this.education = education;
    }

    public User(String name,String lastname, String email, String password, String username, ArrayList<String> skills, ArrayList<Post> posts, JobPosition currentPosition, Education education) {
        this.name = name;
        this.lastname= lastname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.skills = skills;
        this.posts = posts;
        this.currentPosition = currentPosition;
        this.education = education;
    }

    public User(int id, String name, String lastname, String email, String password, String username, ArrayList<String> skills, ArrayList<Post> posts, JobPosition currentPosition, Education education) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
        this.skills = skills;
        this.posts = posts;
        this.currentPosition = currentPosition;
        this.education = education;
    }

    public User(String name, String lastname, String email, String password, String username) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public User(int id, String name, String lastname, String email, String password, String username) {
        this.id = id;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.password = password;
        this.username = username;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public static ArrayList<User> getAllUsers(){
        try {
            return DataBase.getAllUsers();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public void save(){
        if(this.id == -1){
            try {
                id = DataBase.createUser(this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }else{
            try {
                DataBase.updateUser(this);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public void delete(){
        try {
            DataBase.deleteUser(this);
            id = -1;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User() {

    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    public ArrayList<Post> getPosts() {
        return posts;
    }

    public void setPosts(ArrayList<Post> posts) {
        this.posts = posts;
    }

    public JobPosition getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(JobPosition currentPosition) {
        this.currentPosition = currentPosition;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "User{" +
                "name'" + name + '\'' +
                  ",  lastname='"+ '\''+
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", username='" + username + '\'' +
                ", skills=" + skills +
                ", posts=" + posts +
                ", currentPosition=" + currentPosition +
                ", education=" + education +
                '}';
    }
}
