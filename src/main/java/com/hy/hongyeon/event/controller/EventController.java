package com.hy.hongyeon.event.controller;

import com.hy.hongyeon.event.dto.EventDto;
import com.hy.hongyeon.event.service.EventService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/event")
public class EventController {

    private final EventService eventService;

    @GetMapping("/register")
    public String register(EventDto eventDto){
        return "event/register";
    }

    @PostMapping("/register")
    public String register(@Valid EventDto eventDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "event/register";
        }

        return "redirect:/";
    }
}
