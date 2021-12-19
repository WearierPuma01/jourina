package com.server.jourina.bodies;

public class UserJournalBody {
    private String login;
    private Integer journal;

    public UserJournalBody() {
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public Integer getJournal() {
        return journal;
    }

    public void setJournal(Integer journal) {
        this.journal = journal;
    }
}
