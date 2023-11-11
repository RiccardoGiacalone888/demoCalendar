package com.Calendar.demoCalendar.Models;

import com.fasterxml.jackson.annotation.JsonAutoDetect;

@JsonAutoDetect(fieldVisibility = JsonAutoDetect.Visibility.ANY)

public class EventRequest {
    private String title;

    private String description;

    private String date;

    private String startTime;

    private String repetition;

    public EventRequest(String title, String description, String date, String startTime, String repetition) {
        this.title = title;
        this.description = description;
        this.date = date;
        this.startTime = startTime;
        this.repetition = repetition;
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
}
