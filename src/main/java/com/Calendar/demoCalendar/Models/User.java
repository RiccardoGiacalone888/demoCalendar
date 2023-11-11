package com.Calendar.demoCalendar.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;
    private String name;
    private String surname;
    private String email;
    @ManyToMany(mappedBy = "participants")
    private List<Event> participantsEvent;

    public User() {
    }

    public User(String name, String surname, String email, List<Event> participantsEvent) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.participantsEvent = participantsEvent;
    }

    public User(Long id, String name, String surname, String email, List<Event> participantsEvent) {
        this.userId = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.participantsEvent = participantsEvent;
    }

    public Long getId() {
        return userId;
    }

    public void setId(Long id) {
        this.userId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Event> getParticipantsEvent() {
        return participantsEvent;
    }

    public void setParticipantsEvent(List<Event> participantsEvent) {
        this.participantsEvent = participantsEvent;
    }
}
