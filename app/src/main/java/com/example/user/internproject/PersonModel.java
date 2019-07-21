package com.example.user.internproject;

class PersonModel {
    private String name;
    private String designation;
    private String team;
    private String image;
    public  PersonModel() {

    }

    public String getName() {
        return name;
    }

    public String getDesignation() {
        return designation;
    }

    public String getTeam() {
        return team;
    }

    public String getImage(){return image;}

    public void setName(String name) {
        this.name = name;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
