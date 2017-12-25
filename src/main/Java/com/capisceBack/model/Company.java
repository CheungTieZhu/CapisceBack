package com.capisceBack.model;

public class Company {
    private String company;
    private String apartment;
    private String team;
    private int level;

    public  String getCompany(){
        return  company;
    }
    public void setCompany(String company){
        this.company = company;
    }
    public String getApartment(){
        return apartment;
    }
    public void setApartment(String apartment){
        this.apartment = apartment;
    }
    public String getTeam(){
        return team;
    }
    public void setTeam(String team) {
        this.team = team;
    }
    public int getLevel(){
        return level;
    }
    public void setLevel(int level) {
        this.level = level;
    }
}
