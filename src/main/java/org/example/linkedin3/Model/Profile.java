package org.example.linkedin3.Model;

import java.util.ArrayList;

public class Profile extends Model {
    private String name;
    private String lastname;
    private String additionalName;
    //profile picture
    //background picture;
    private ArrayList<String> mediaPaths;
    private JobPosition jobPosition;
    private Education education;

    public Profile(String name, String lastname, String additionalName, ArrayList<String> mediaPaths, JobPosition jobPosition, Education education) {
        this.name = name;
        this.lastname = lastname;
        this.additionalName = additionalName;
        this.mediaPaths = mediaPaths;
        this.jobPosition = jobPosition;
        this.education = education;
    }

    public Profile() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAdditionalName() {
        return additionalName;
    }

    public void setAdditionalName(String additionalName) {
        this.additionalName = additionalName;
    }

    public ArrayList<String> getMediaPaths() {
        return mediaPaths;
    }

    public void setMediaPaths(ArrayList<String> mediaPaths) {
        this.mediaPaths = mediaPaths;
    }

    public JobPosition getJobPosition() {
        return jobPosition;
    }

    public void setJobPosition(JobPosition jobPosition) {
        this.jobPosition = jobPosition;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", additionalName='" + additionalName + '\'' +
                ", mediaPaths=" + mediaPaths +
                ", jobPosition=" + jobPosition +
                ", education=" + education +
                '}';
    }
}
