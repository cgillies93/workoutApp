package com.example.gymapp;

public class Trainer {
    private String firstName;
    private String lastName;
    private String certifications;
    private String bio;

    public Trainer(String firstName,String lastName, String certifications, String bio) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.certifications = certifications;
        this.bio = bio;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getCertifications() {
        return certifications;
    }

    public void setCertifications(String certifications) {
        this.certifications = certifications;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
