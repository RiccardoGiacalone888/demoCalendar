package com.Calendar.demoCalendar.Service;

import com.Calendar.demoCalendar.Models.Calendar;
import com.Calendar.demoCalendar.Models.CalendarRequest;
import com.Calendar.demoCalendar.Repository.CalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CalendarServiceDB {
    @Autowired CalendarRepository calendarRepository;

   public Calendar createCalendar(CalendarRequest request){
       Calendar newCalendar = new Calendar();
       newCalendar.setName(request.getName());
       newCalendar.setDescription(request.getDescription());
       return calendarRepository.save(newCalendar);
   }

   public void modifyCalendar(Long calendarId, CalendarRequest newDetails){
       Calendar calendar = calendarRepository.findById(calendarId)
               .orElseThrow(() -> new IllegalArgumentException("Calendar not found with ID: " + calendarId));

       calendar.setName(newDetails.getName());
       calendar.setDescription(newDetails.getDescription());
       calendarRepository.save(calendar);
   }

   public void deleteCalendar (Long calendarId){
     Calendar calendar=calendarRepository.findById(calendarId)
             .orElseThrow(()-> new IllegalArgumentException("Calendar not found with ID: " + calendarId));
     calendarRepository.delete(calendar);
   }

   public Calendar findCalendarById(Long calendarId){
       return calendarRepository.findById(calendarId)
               .orElseThrow(()-> new IllegalArgumentException("Calendar not found with ID: " + calendarId));
   }

   public List<Calendar> findCalendarForUser (Long userId){
       return null;
   }
}