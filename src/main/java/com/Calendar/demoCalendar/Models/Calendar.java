package com.Calendar.demoCalendar.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Calendar {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long calendarId;
    private String name;
    private String description;
    @OneToMany(mappedBy = "calendar", cascade = CascadeType.ALL)
    private List<Event> events;

    public Calendar() {
    }

    public Calendar(String name, String description, List<Event> events) {
        this.name = name;
        this.description = description;
        this.events = events;
    }

    public Calendar(Long id, String name, String description, List<Event> events) {
        this.calendarId = id;
        this.name = name;
        this.description = description;
        this.events = events;
    }

    public Long getId() {
        return calendarId;
    }

    public void setId(Long id) {
        this.calendarId = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
