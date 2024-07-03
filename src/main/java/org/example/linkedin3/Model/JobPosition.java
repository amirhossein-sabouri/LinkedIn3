package org.example.linkedin3.Model;

import java.util.ArrayList;
import java.util.Date;

public class JobPosition extends Model {
    private String Company;
    private String Title;
    private boolean currently_working;
    private Date start;
    private Date end;
    private String location;
    private String description;
    private ArrayList<String> skills;

    public JobPosition(String company, String title, boolean currently_working, Date start, Date end, String location, String description, ArrayList<String> skills) {
        Company = company;
        Title = title;
        this.currently_working = currently_working;
        this.start = start;
        this.end = end;
        this.location = location;
        this.description = description;
        this.skills = skills;
    }

    public JobPosition() {

    }

    public String getCompany() {
        return Company;
    }

    public void setCompany(String company) {
        Company = company;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public boolean isCurrently_working() {
        return currently_working;
    }

    public void setCurrently_working(boolean currently_working) {
        this.currently_working = currently_working;
    }

    public Date getStart() {
        return start;
    }

    public void setStart(Date start) {
        this.start = start;
    }

    public Date getEnd() {
        return end;
    }

    public void setEnd(Date end) {
        this.end = end;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<String> getSkills() {
        return skills;
    }

    public void setSkills(ArrayList<String> skills) {
        this.skills = skills;
    }

    @Override
    public String toString() {
        return "JobPosition{" +
                "Company='" + Company + '\'' +
                ", Title='" + Title + '\'' +
                ", currently_working=" + currently_working +
                ", start=" + start +
                ", end=" + end +
                ", location='" + location + '\'' +
                ", description='" + description + '\'' +
                ", skills=" + skills +
                '}';
    }
}
