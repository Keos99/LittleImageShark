package ru.keos99.littleinsta.mvp.model.entity.user;

import java.util.List;

public class Result {
    private boolean isOwner;
    private int cacheVersion;
    private int userid;
    private String email;
    private String username;
    private String description;
    private int creationDate;
    private String location;
    private String gender;
    private String firstName;
    private String lastName;
    private Image avatar;
    private String membership;
    private boolean isFolowing;
    private boolean followingAllowed;
    private List<Image> latestImages;

    public boolean getIsOwner() {
        return isOwner;
    }

    public void setIsOwner(boolean isOwner) {
        this.isOwner = isOwner;
    }

    public int getCacheVersion() {
        return cacheVersion;
    }

    public void setCacheVersion(int cacheVersion) {
        this.cacheVersion = cacheVersion;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(int creationDate) {
        this.creationDate = creationDate;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
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

    public Image getAvatar() {
        return avatar;
    }

    public void setAvatar(Image avatar) {
        this.avatar = avatar;
    }

    public String getMembership() {
        return membership;
    }

    public void setMembership(String membership) {
        this.membership = membership;
    }

    public boolean getIsFolowing() {
        return isFolowing;
    }

    public void setIsFolowing(boolean isFolowing) {
        this.isFolowing = isFolowing;
    }

    public boolean getFollowingAllowed() {
        return followingAllowed;
    }

    public void setFollowingAllowed(boolean followingAllowed) {
        this.followingAllowed = followingAllowed;
    }

    public List<Image> getLatestImages() {
        return latestImages;
    }

    public void setLatestImages(List<Image> latestImages) {
        this.latestImages = latestImages;
    }
}
