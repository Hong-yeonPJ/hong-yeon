package com.hy.hongyeon.event.repository;

import com.hy.hongyeon.event.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
