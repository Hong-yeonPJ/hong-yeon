package com.hy.hongyeon.event.service;

import com.hy.hongyeon.event.dto.EventDto;
import com.hy.hongyeon.event.entity.Event;
import com.hy.hongyeon.event.entity.EventCategory;
import com.hy.hongyeon.event.repository.EventRepository;
import com.hy.hongyeon.global.exception.DataNotFoundException;
import com.hy.hongyeon.global.image.entity.Image;
import com.hy.hongyeon.global.image.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ImageService imageService;

    @Autowired
    public EventService(EventRepository eventRepository, ImageService imageService) {
        this.eventRepository = eventRepository;
        this.imageService = imageService;
    }

    @Transactional
    //public Event createEvent(EventDto eventDto, Member writer){
    public Event createEvent(EventDto eventDto){

        Image header = imageService.uploadImage(eventDto.getHeader());
        Image detail = imageService.uploadImage(eventDto.getDetail());

        Event newEvent = Event.builder().
                createDate(LocalDateTime.now()).
                title(eventDto.getTitle()).
                //writer(writer).
                eventCategory(eventDto.getEventCategory()).
                seatCapacity(eventDto.getSeatCapacity()).
                eventStatus(eventDto.getEventStatus()).
                entranceFee(eventDto.getEntranceFee()).
                location(eventDto.getLocation()).
                date(eventDto.getDate()).
                //eventOpenDate(eventDto.getEventOpenDate()).
                header(header).
                detail(detail).
                build();

        return eventRepository.save(newEvent);
    }

    public Event getEvent(Long id){
        Optional<Event> event = this.eventRepository.findById(id);
        if (event.isPresent()) {
            return event.get();
        } else {
            throw new DataNotFoundException("event not found");
        }
    }

    public List<Event> findAll(){
        return this.eventRepository.findAll();
    }

    public List<Event> findPerformance(){
        return this.eventRepository.findAllByEventCategory(EventCategory.PERFORMANCE);
    }

    public List<Event> findUniversityEvent(){
        return this.eventRepository.findAllByEventCategory(EventCategory.UNIVERSITY_EVENT);
    }

    public List<Event> findPub(){
        return this.eventRepository.findAllByEventCategory(EventCategory.PUB);
    }
}
