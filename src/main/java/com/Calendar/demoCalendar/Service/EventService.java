package com.Calendar.demoCalendar.Service;

import com.Calendar.demoCalendar.Models.Event;
import com.Calendar.demoCalendar.Models.EventRequest;

import java.util.List;

public interface EventService {
    Event createEvent(Long calendarId, String title, String description, String date, String startTime, String repetition);

    void modifyEvent(Long calendarId, Long eventId, EventRequest newDetails);

    void deleteEvent(Long calendarId, Long eventId);

    void inviteParticipants(Long eventId, List<String> participants);
}
