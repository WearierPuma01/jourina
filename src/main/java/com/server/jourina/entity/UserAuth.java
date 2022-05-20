package com.server.jourina.entity;

public class UserAuth {
    public User user;
    public boolean accessAuth;

    public void successAuth() {
        this.accessAuth = true;
    }

    public void unsucessAuth() {
        this.user = null;
        this.accessAuth = false;
    }

    public User getUser() {
        return user;
    }
}
