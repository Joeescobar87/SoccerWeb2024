package edu.csula.cs3220stu06.hw2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String uniformColor;
    private String gender;
    private int minAge;
    private int maxAge;

    public Team( String uniformColor, String gender, int minAge, int maxAge) {

        this.uniformColor = uniformColor;
        this.gender = gender;
        this.minAge = minAge;
        this.maxAge = maxAge;
    }

    public Team() {

    }


    public Integer getId() {
        return id;
    }

    public String getUniformColor() {
        return uniformColor;
    }

    public String getGender() {
        return gender;
    }

    public int getMinAge() {
        return minAge;
    }

    public int getMaxAge() {
        return maxAge;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUniformColor(String uniformColor) {
        this.uniformColor = uniformColor;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setMinAge(int minAge) {
        this.minAge = minAge;
    }

    public void setMaxAge(int maxAge) {
        this.maxAge = maxAge;
    }
}
