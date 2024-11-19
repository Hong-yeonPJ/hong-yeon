package com.hy.hongyeon.main;

import com.hy.hongyeon.event.entity.Event;
import com.hy.hongyeon.event.service.EventService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@RequiredArgsConstructor
@Controller
public class MainController {
    private final EventService eventService;

    // 루트 URL을 /hongyeon으로 리다이렉트
    @GetMapping("/")
    public String redirectToHongyeon() {
        return "redirect:/hongyeon";
    }

    @GetMapping("/hongyeon")
    public String  main(Model model){
        List<Event> eventList = this.eventService.findAll();
        model.addAttribute("eventList", eventList);

        return "home/home";
    }
}