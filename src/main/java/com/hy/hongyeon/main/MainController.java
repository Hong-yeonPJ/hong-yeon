package com.hy.hongyeon.main;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
    // 루트 URL을 /hongyeon으로 리다이렉트
    @GetMapping("/")
    public String redirectToHongyeon() {
        return "redirect:/hongyeon";
    }

    @GetMapping("/hongyeon")
    public String  main(){
        return "home/home";
    }
}
