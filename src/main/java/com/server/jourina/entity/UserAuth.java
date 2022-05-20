package com.server.jourina.entity;

public class UserAuth {
    public User user;
    public int accessAuth;

    public void successAuth() {
        this.accessAuth = 1;
    }

    public void unsucessAuth() {
        this.user = null;
        this.accessAuth = 0;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + user.getId() +
                ", login='" + user.getLogin() + '\'' +
                ", password='" + user.getPassword() + '\'' +
                ", name='" + user.getName() + '\'' +
                ", role=" + user.getRole() +
                ", department=" + user.getDepartment().getId() +
                ", note=" + user.getNote() +
                ", journal=" + user.getJournal() +
                '}' +
                "AccessAuth{" +
                "isSuccess=" + accessAuth +
                '}';
    }
}
