package com.Calendar.demoCalendar.Controller;

import com.Calendar.demoCalendar.Models.User;
import com.Calendar.demoCalendar.Service.UserServiceDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    private UserServiceDB userServiceDB;
    @PostMapping
    public ResponseEntity<User> createUser(@RequestParam String firstName, @RequestParam String lastName, @RequestParam String email) {
        User createdUser = userServiceDB.createUser(firstName, lastName, email);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @GetMapping("/{userId}")
    public ResponseEntity<User> findUserById(@PathVariable Long userId) {
        User user = userServiceDB.findUserById(userId);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/byEmail")
    public ResponseEntity<List<User>> findUsersByEmailIn(@RequestParam List<String> emails) {
        List<User> users = userServiceDB.findUsersByEmailIn(emails);
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PostMapping("/{userId}/participate/{eventId}")
    public ResponseEntity<Void> addParticipatedEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        userServiceDB.addParticipantEvent(userId, eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @DeleteMapping("/{userId}/participate/{eventId}")
    public ResponseEntity<Void> removeParticipatedEvent(@PathVariable Long userId, @PathVariable Long eventId) {
        userServiceDB.removeParticipants(userId, eventId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
