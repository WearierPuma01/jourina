package com.server.jourina.entity;

import org.hibernate.Hibernate;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

public class UserJournalId implements Serializable {
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_user", referencedColumnName = "id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "id_journal", referencedColumnName = "id")
    private Journal journal;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserJournalId that = (UserJournalId) o;
        return Objects.equals(user, that.user) && Objects.equals(journal, that.journal);
    }

    @Override
    public int hashCode() {
        return Objects.hash(user, journal);
    }

    @Override
    public String toString() {
        return "UserJournalId{" +
                "user=" + user +
                ", journal=" + journal +
                '}';
    }

    public UserJournalId() {
    }
}