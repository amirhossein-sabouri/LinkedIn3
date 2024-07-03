package org.example.linkedin3.Model;

import java.util.ArrayList;
import java.util.Date;

public class PrivateMesseage extends Model {
    private String text;
    private Date date;
    private ArrayList<String> mediaPaths;

    public PrivateMesseage(String text, Date date, ArrayList<String> mediaPaths) {
        this.text = text;
        this.date = date;
        this.mediaPaths = mediaPaths;
    }

    public PrivateMesseage() {

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

    @Override
    public String toString() {
        return "PrivateMesseage{" +
                "text='" + text + '\'' +
                ", date=" + date +
                ", mediaPaths=" + mediaPaths +
                '}';
    }
}
