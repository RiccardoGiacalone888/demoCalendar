package com.Calendar.demoCalendar.Service;

import com.Calendar.demoCalendar.Models.CalendarRequest;
import com.Calendar.demoCalendar.Models.Event;

import java.util.Calendar;
import java.util.List;

public interface CalendarService {

    Calendar createCalendar(String name, String description);

    void modifyCalendar(Long calendarId, CalendarRequest newDetails);

    void deleteCalendar(Long calendarId);

    Calendar findCalendarById(Long calendarId);

    List<Calendar> findCalendarsForUser(Long userId);


}


