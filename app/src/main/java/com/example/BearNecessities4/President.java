package com.example.BearNecessities4;

public class President {


    private int id;
    private String name;
    private double dateOfElection;
    private  String imageURL;

    public President (int id , String name , double dateOfElection , String imageURL) {
        this.id = id;
        this.name = name;
        this.dateOfElection = dateOfElection;
        this.imageURL = imageURL;
    }

    @Override
    public String toString () {
        return "President{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dateOfElection=" + dateOfElection +
                ", imageURL='" + imageURL + '\'' +
                '}';
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public double getDateOfElection () {
        return dateOfElection;
    }

    public void setDateOfElection (int dateOfElection) {
        this.dateOfElection = dateOfElection;
    }

    public String getImageURL () {
        return imageURL;
    }

    public void setImageURL (String imageURL) {
        this.imageURL = imageURL;
    }
}
