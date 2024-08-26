package edu.csula.cs3220stu06.hw2.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.nio.channels.InterruptedByTimeoutException;
import java.time.Year;

@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String gender;
    private int birthYear;
    private int team;

    public Player(String name, String gender, int birthYear, int team) {
        this();
        this.name = name;
        this.gender = gender;
        this.birthYear = birthYear;
        this.team = team;
    }

    public Player() {

    }

    public Integer getId() {return id;}

    public void setId(Integer id) {this.id = id;}

    public String getName() {return name;}

    public void setName(String name) { this.name = name;}

    public String getGender() {return gender;}

    public void setGender(String gender) {this.gender = gender;}

    public int getBirthYear() {return birthYear;}

    public void setBirthYear(int birthYear) {this.birthYear = birthYear;}

    public int getTeam() {return team;}

    public void setTeam(int team) {this.team = team;}

    public int getAge() {
        return Year.now().getValue()-getBirthYear();
    }

}
