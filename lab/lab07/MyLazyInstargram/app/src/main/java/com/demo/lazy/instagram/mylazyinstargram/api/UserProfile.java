package com.demo.lazy.instagram.mylazyinstargram.api;

/**
 * Created by student on 10/6/2017 AD.
 */

//ต้องให้ ชื่อ attribute map ชื่อตรงกับ json
public class UserProfile {
    private  String user;
    private  String urlProfile;
    private  String bio;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {this.user = user; }


    public String getUrlProfile() {
        return urlProfile;
    }

    public void setUrlProfile(String urlProfile) {
        this.urlProfile = urlProfile;
    }

    public String getBio() {
        return bio;
    }

    public void setBio(String bio) {
        this.bio = bio;
    }
}
