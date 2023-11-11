package com.Calendar.demoCalendar.Repository;

import com.Calendar.demoCalendar.Models.Calendar;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CalendarRepository extends JpaRepository<Calendar,Long> {
}
