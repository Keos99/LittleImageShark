package ru.keos99.littleinsta.mvp.model.entity.user;

public class Auth {
    private String authToken;
    private int userId;
    private String email;
    private String username;
    private Image avatar;
    private String membership;
    private String membershipItemNumber;
    private String membershipCookie;

    public String getAuthToken() {
        return authToken;
    }

    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
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

    public String getMembershipItemNumber() {
        return membershipItemNumber;
    }

    public void setMembershipItemNumber(String membershipItemNumber) {
        this.membershipItemNumber = membershipItemNumber;
    }

    public String getMembershipCookie() {
        return membershipCookie;
    }

    public void setMembershipCookie(String membershipCookie) {
        this.membershipCookie = membershipCookie;
    }
}
