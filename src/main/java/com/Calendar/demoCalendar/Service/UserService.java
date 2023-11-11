package com.Calendar.demoCalendar.Service;

import com.Calendar.demoCalendar.Models.User;

import java.util.List;

public interface UserService {
    User createUser(String name,String surname, String email );
    User findUserById(Long id);
    List<String> findUsersByEmailIn(List<String> emails);

    void addParticipatedEvent(Long userId, Long eventId);

    void removeParticipatedEvent(Long userId, Long eventId);
}
