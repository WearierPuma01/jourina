package com.server.jourina.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "log")
public class Log {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "\"time\"", nullable = false)
    private String time;

    @ManyToOne(optional = false)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @ManyToOne(optional = false)
    @JoinColumn(name = "journal_id", nullable = false)
    private Journal journal;

    @Column(name = "coordinate", nullable = false)
    private String coordinate;

    @Column(name = "old_value")
    private String oldValue;

    @Column(name = "new_value")
    private String newValue;

    public String getNewValue() {
        return newValue;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getOldValue() {
        return oldValue;
    }

    public void setOldValue(String oldValue) {
        this.oldValue = oldValue;
    }

    public String getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(String coordinate) {
        this.coordinate = coordinate;
    }

    public Journal getJournal() {
        return journal;
    }

    public void setJournal(Journal journal) {
        this.journal = journal;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Log log = (Log) o;
        return Objects.equals(id, log.id) && Objects.equals(time, log.time) && Objects.equals(user, log.user) && Objects.equals(journal, log.journal) && Objects.equals(coordinate, log.coordinate) && Objects.equals(oldValue, log.oldValue) && Objects.equals(newValue, log.newValue);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, time, user, journal, coordinate, oldValue, newValue);
    }

    @Override
    public String toString() {
        return "Log{" +
                "id=" + id +
                ", time='" + time + '\'' +
                ", user=" + user +
                ", journal=" + journal +
                ", coordinate='" + coordinate + '\'' +
                ", oldValue='" + oldValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }

    public Log() {
    }
}