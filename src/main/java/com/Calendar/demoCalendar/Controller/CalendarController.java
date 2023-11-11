package com.Calendar.demoCalendar.Controller;

import com.Calendar.demoCalendar.Models.Calendar;
import com.Calendar.demoCalendar.Models.CalendarRequest;
import com.Calendar.demoCalendar.Service.CalendarServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/calendars")
public class CalendarController {
    @Autowired
    private CalendarServiceDB calendarServiceDB;
    @PostMapping
    public ResponseEntity<Calendar> createCalendar (@RequestBody CalendarRequest request){
        Calendar createCalendar= calendarServiceDB.createCalendar(request);
        return  new ResponseEntity<>(createCalendar, HttpStatus.CREATED);
    }
    @PutMapping("/{calendarId}")
    public ResponseEntity<Void> modifyCalendar (@PathVariable Long calendarId,
                                                @RequestBody CalendarRequest newDetails){
        calendarServiceDB.modifyCalendar(calendarId,newDetails);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
    @DeleteMapping("/{calendarId}")
    public ResponseEntity<Void> deleteCalendar (@PathVariable Long calendarId){
        calendarServiceDB.deleteCalendar(calendarId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("/{calendarId}")
    public ResponseEntity<Calendar> findCalendarById (@PathVariable Long calendarId){
        Calendar calendar = calendarServiceDB.findCalendarById(calendarId);
        return new ResponseEntity<>(calendar,HttpStatus.OK);

    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<Calendar>> findCalendarForUser(@PathVariable Long userId){
        List<Calendar> userCalendar = calendarServiceDB.findCalendarForUser(userId);
        return new ResponseEntity<>(userCalendar, HttpStatus.OK);
    }
}
