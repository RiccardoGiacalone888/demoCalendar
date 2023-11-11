package com.Calendar.demoCalendar.Repository;

import com.Calendar.demoCalendar.Models.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event,Long> {
}
