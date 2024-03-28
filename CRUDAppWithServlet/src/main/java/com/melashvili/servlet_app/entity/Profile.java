package com.melashvili.servlet_app.entity;

import java.sql.Blob;
import java.util.Arrays;

public class Profile {
    private int id;

    private String firstName;

    private byte[] profilePicture;

    public Profile() {
    }

    public Profile(int id, String firstName, byte[] profilePicture) {
        this.id = id;
        this.firstName = firstName;
        this.profilePicture = profilePicture;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public byte[] getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(byte[] profilePicture) {
        this.profilePicture = profilePicture;
    }

    @Override
    public String toString() {
        return "Profile{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", profilePicture=" + Arrays.toString(profilePicture) +
                '}';
    }
}
