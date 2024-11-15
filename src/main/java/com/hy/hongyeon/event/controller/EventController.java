package com.hy.hongyeon.event.controller;

import com.hy.hongyeon.event.dto.EventDto;
import com.hy.hongyeon.event.entity.Event;
import com.hy.hongyeon.event.service.EventService;
import com.hy.hongyeon.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.security.Principal;
import java.util.List;

@RequiredArgsConstructor
@Controller
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;
    private final MemberService memberService;

    @GetMapping("/register")
    public String register(EventDto eventDto){
        return "event/event_register";
    }

    @PostMapping("/register")
    public String register(@Valid EventDto eventDto, BindingResult bindingResult, Principal principal){
        if(bindingResult.hasErrors()){
            return "event/event_register";
        }

        Event event = eventService.createEvent(eventDto);
        //Event event = eventService.createEvent(eventDto, memberService.getMember(principal.getName()));

        return "redirect:/event/detail/" + event.getEventId();
    }

    @GetMapping(value = "/detail/{id}")
    public String detail(Model model, @PathVariable("id") Long id) {
        Event event = this.eventService.getEvent(id);
        model.addAttribute("event", event);

        return "event/event_detail";
    }

    @GetMapping("/list")
    public String list(Model model) {
        List<Event> eventList = this.eventService.findAll();
        model.addAttribute("eventList", eventList);

        return "event/event_list";
    }
}