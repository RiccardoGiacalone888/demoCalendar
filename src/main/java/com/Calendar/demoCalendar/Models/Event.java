package com.Calendar.demoCalendar.Models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Event {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventId;

    private String title;

    private String description;

    private String date;

    private String startTime;

    private String repetition;
    @ManyToOne
    @JoinColumn(name="calendar_id")
    private Calendar calendar;
    @ManyToMany
    @JoinTable(name = "participants_event",
            joinColumns=@JoinColumn(name = "id_event"),
    inverseJoinColumns = @JoinColumn(name = "id_parpecipant")
    )
    private List<User> participants;

    public Event() {
    }

    public Event(String title, String description, String date,
                 String startTime, String repetition, Calendar calendar, List<User> participants) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.repetition = repetition;
        this.calendar = calendar;
        this.participants = participants;
    }

    public Event(Long id, String title, String description, String date,
                 String startTime, String repetition, Calendar calendar, List<User> participants) {
        this.eventId = id;
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.repetition = repetition;
        this.calendar = calendar;
        this.participants = participants;
    }

    public Long getId() {
        return eventId;
    }

    public void setId(Long id) {
        this.eventId = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getRepetition() {
        return repetition;
    }

    public void setRepetition(String repetition) {
        this.repetition = repetition;
    }

    public Calendar getCalendar() {
        return calendar;
    }

    public void setCalendar(Calendar calendar) {
        this.calendar = calendar;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }
}
