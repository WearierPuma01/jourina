package com.server.jourina.bodies;

public class AddUserJournalBody {
    private String login;
    private Integer journal;

    public AddUserJournalBody() {
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
