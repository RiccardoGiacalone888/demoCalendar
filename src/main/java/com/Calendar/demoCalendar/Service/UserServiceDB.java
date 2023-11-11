package com.Calendar.demoCalendar.Service;

import com.Calendar.demoCalendar.Models.Event;
import com.Calendar.demoCalendar.Models.User;
import com.Calendar.demoCalendar.Repository.EventRepository;
import com.Calendar.demoCalendar.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceDB {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EventRepository eventRepository;

    public User createUser (String name,String surname, String email){
        User newUser= new User();
        newUser.setName(name);
        newUser.setSurname(surname);
        newUser.setEmail(email);
        return userRepository.save(newUser);
    }

    public User findUserById (Long userId){
        return userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("User not found with ID: " + userId));

    }

    public List<User> findUsersByEmailIn (List<String> email){
        return  userRepository.findAllByEmailIn(email);
    }

    public void addParticipantEvent (Long userId, Long eventId){
        User user= userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("User not found with ID: " + userId));
        Event event= eventRepository.findById(eventId)
                .orElseThrow(()-> new IllegalArgumentException("Event not found with ID: " + eventId));
        user.getParticipantsEvent().add(event);
        userRepository.save(user);
    }

    public void removeParticipants (Long userId,Long eventId){
        User user= userRepository.findById(userId)
                .orElseThrow(()-> new IllegalArgumentException("User not found with ID: " + userId));
        Event event= eventRepository.findById(eventId)
                .orElseThrow(()-> new IllegalArgumentException("Event not found with ID: " + eventId));

        user.getParticipantsEvent().remove(event);
        userRepository.delete(user);
    }
}
