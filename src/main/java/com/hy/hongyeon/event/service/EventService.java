package com.hy.hongyeon.event.service;

import com.hy.hongyeon.event.entity.Event;
import com.hy.hongyeon.event.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EventService {

    private final EventRepository eventRepository;

    @Autowired
    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }

    @Transactional
    public Event createEvent(){
        Event newEvent = Event.builder().
                build();

        return eventRepository.save(newEvent);
    }
}
