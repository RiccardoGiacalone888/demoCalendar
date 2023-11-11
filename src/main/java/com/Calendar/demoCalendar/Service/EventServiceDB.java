package com.Calendar.demoCalendar.Service;

import com.Calendar.demoCalendar.Models.*;
import com.Calendar.demoCalendar.Repository.CalendarRepository;
import com.Calendar.demoCalendar.Repository.EventRepository;
import com.Calendar.demoCalendar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventServiceDB {
    @Autowired
    private EventRepository eventRepository;
    @Autowired
    private CalendarRepository calendarRepository;
    @Autowired
    private UserRepository userRepository;

    public Event createEvent (Long calendarId, EventRequest request){
        Calendar calendar= calendarRepository.findById(calendarId)
                .orElseThrow(()->new IllegalArgumentException("Calendar not found with ID: \" + calendarId)"));
            Event newEvent= new Event();
            newEvent.setTitle(request.getTitle());
            newEvent.setDescription(request.getDescription());
            newEvent.setDate(request.getDate());
            newEvent.setStartTime(request.getStartTime());
            newEvent.setRepetition(request.getRepetition());
            newEvent.setCalendar(calendar);
        return eventRepository.save(newEvent);

    }

    public void modifyEvent(Long calendarId, Long eventId, EventRequest newDetails){
        Calendar calendar=calendarRepository.findById(calendarId)
                .orElseThrow(()-> new IllegalArgumentException("Event not found with ID: " + calendarId));
        Event event= eventRepository.findById(eventId)
                .orElseThrow(()->new IllegalArgumentException("Event not found with ID: " + eventId));
        event.setTitle(newDetails.getTitle());
        event.setDescription(newDetails.getDescription());
        event.setDate(newDetails.getDate());
        event.setStartTime(newDetails.getStartTime());
        event.setRepetition(newDetails.getRepetition());
        event.setCalendar(calendar);
        eventRepository.save(event);
    }

    public void deleteEvent (Long calendarId, Long eventId){
        Calendar calendar= calendarRepository.findById(calendarId)
                .orElseThrow(()-> new IllegalArgumentException("Event not found with ID: " + calendarId));
        Event event = eventRepository.findById(eventId)
                .orElseThrow(()-> new IllegalArgumentException("Event not found with ID: " + eventId));
        calendar.getEvents().remove(event);
        eventRepository.delete(event);
    }

    public void inviteParticipants (Long eventId, List<String> participants){
        Event event= eventRepository.findById(eventId)
                .orElseThrow(()-> new IllegalArgumentException("Event not found with ID: " + eventId));
        List<User> invitedUsers = userRepository.findAllByEmailIn(participants);
        event.getParticipants().addAll(invitedUsers);
        for (User participant : invitedUsers ){
            participant.getParticipantsEvent().add(event);
        }
    }



}
