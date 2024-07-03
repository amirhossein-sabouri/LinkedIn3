package org.example.linkedin3.Model;

public class Comment extends Model {
    private String text;
    private String username;

    public Comment(String text, String username) {
        this.text = text;
        this.username = username;
    }

    public Comment() {

    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        return "Comment{" +
                "text='" + text + '\'' +
                ", username='" + username + '\'' +
                '}';
    }
}
