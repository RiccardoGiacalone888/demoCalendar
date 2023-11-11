package com.Calendar.demoCalendar.Controller;

import com.Calendar.demoCalendar.Models.Event;
import com.Calendar.demoCalendar.Models.EventRequest;
import com.Calendar.demoCalendar.Service.EventServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/events")
public class EventController {
    @Autowired
    private EventServiceDB eventServiceDB;

    @PostMapping("/{calendarID}")
    public ResponseEntity<Event> createEvent(@PathVariable Long calendarId, @RequestBody EventRequest request) {
        Event createdEvent = eventServiceDB.createEvent(calendarId, request);
        return new ResponseEntity<>(createdEvent, HttpStatus.CREATED);

    }
    @PutMapping("/{calendarId}/{eventId}")
    public ResponseEntity<Void> modifyEvent(@PathVariable Long calendarId, @PathVariable Long eventId, @RequestBody EventRequest newDetails) {
        eventServiceDB.modifyEvent(calendarId, eventId, newDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{calendarId}{eventId}")
    public ResponseEntity<Void> deleteEvent(@PathVariable Long calendarId, @PathVariable Long eventId) {
        eventServiceDB.deleteEvent(calendarId, eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @PostMapping("/{eventId}/invite")
    public ResponseEntity<Void> inviteParticipants(@PathVariable Long eventId, @RequestBody List<String> participants) {
        eventServiceDB.inviteParticipants(eventId, participants);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
