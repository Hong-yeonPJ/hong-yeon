package com.hy.hongyeon.event.repository;

import com.hy.hongyeon.event.entity.Event;
import com.hy.hongyeon.event.entity.EventCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EventRepository extends JpaRepository<Event, Long> {
    List<Event> findAllByEventCategory(EventCategory category);

}
