package org.example.linkedin3.Model;

import java.util.ArrayList;
import java.util.Date;

public class Education extends Model {
    private String University_or_Institution;
    private String degree;
    private String field_of_study;
    private double grade;
    private String activities;
    private Date startYear;
    //implementing with data picker
    private Date endYear;
    private String description;
    private ArrayList<String> skills;

    @Override
    public String toString() {
        return "Education{" +
                "University_or_Institution='" + University_or_Institution + '\'' +
                ", degree='" + degree + '\'' +
                ", field_of_study='" + field_of_study + '\'' +
                ", grade=" + grade +
                ", activities='" + activities + '\'' +
                ", startYear=" + startYear +
                ", endYear=" + endYear +
                ", description='" + description + '\'' +
                ", skills=" + skills +
                '}';
    }
}
