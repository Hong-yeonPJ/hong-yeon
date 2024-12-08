package com.hy.hongyeon.reservation.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/event")
public class reservationController {
    @GetMapping("/reservation")
    public String signup(){
        return "event/event_reservation";
    }
}
