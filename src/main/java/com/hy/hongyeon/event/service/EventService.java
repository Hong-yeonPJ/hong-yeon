package com.hy.hongyeon.event.service;

import com.hy.hongyeon.event.dto.EventDto;
import com.hy.hongyeon.event.entity.Event;
import com.hy.hongyeon.event.repository.EventRepository;
import com.hy.hongyeon.global.image.entity.Image;
import com.hy.hongyeon.global.image.service.ImageService;
import com.hy.hongyeon.member.entity.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;

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
    public Event createEvent(EventDto eventDto, Member writer){

        Image header = imageService.uploadImage(eventDto.getHeader());
        Image detail = imageService.uploadImage(eventDto.getDetail());

        Event newEvent = Event.builder().
                createDate(LocalDateTime.now()).
                title(eventDto.getTitle()).
                writer(writer).
                eventCategory(eventDto.getEventCategory()).
                eventStatus(eventDto.getEventStatus()).
                entranceFee(eventDto.getEntranceFee()).
                eventOpenDate(eventDto.getEventOpenDate()).
                headerImage(header).
                detailImage(detail).
                build();

        return eventRepository.save(newEvent);
    }
}
