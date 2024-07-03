package org.example.linkedin3.Model;

import java.util.ArrayList;
import java.util.Date;

public class Post extends Model {
    private String text;
    //photo
    //video
    private Date date;
    //mediaPaths for paths in media
    private ArrayList<String> mediaPaths;
    private ArrayList<User> likers;
    private ArrayList<Comment> comments;
    private ArrayList<String> hashtags;

    public Post(String text, Date date, ArrayList<String> mediaPaths, ArrayList<User> likers, ArrayList<Comment> comments, ArrayList<String> hashtags) {
        this.text = text;
        this.date = date;
        this.mediaPaths = mediaPaths;
        this.likers = likers;
        this.comments = comments;
        this.hashtags = hashtags;
    }

    public Post() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public ArrayList<String> getMediaPaths() {
        return mediaPaths;
    }

    public void setMediaPaths(ArrayList<String> mediaPaths) {
        this.mediaPaths = mediaPaths;
    }

    public ArrayList<User> getLikers() {
        return likers;
    }

    public void setLikers(ArrayList<User> likers) {
        this.likers = likers;
    }

    public ArrayList<Comment> getComments() {
        return comments;
    }

    public void setComments(ArrayList<Comment> comments) {
        this.comments = comments;
    }

    public ArrayList<String> getHashtags() {
        return hashtags;
    }

    public void setHashtags(ArrayList<String> hashtags) {
        this.hashtags = hashtags;
    }

    @Override
    public String toString() {
        return "Post{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", mediaPaths=" + mediaPaths +
                ", likers=" + likers +
                ", comments=" + comments +
                ", hashtags=" + hashtags +
                '}';
    }
}
