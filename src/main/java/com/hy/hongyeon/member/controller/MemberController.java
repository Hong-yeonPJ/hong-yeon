package com.hy.hongyeon.member.controller;

import com.hy.hongyeon.member.dto.MemberDto;
import com.hy.hongyeon.member.entity.MemberType;
import com.hy.hongyeon.member.service.MemberService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
@RequestMapping("/member")
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/signup")
    public String signup(MemberDto memberDto){
        return "member/signup";
    }

    @PostMapping("/signup")
    public String signup(@Valid MemberDto memberDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "member/signup";
        }

        if(!memberDto.getPassword().equals(memberDto.getPasswordCheck())){
            bindingResult.rejectValue("passwordCheck", "passwordCheckFail", "패스워드 확인이 일치하지 않습니다.");
            return "member/signup";
        }


        memberService.createMember(memberDto.getUsername(), memberDto.getEmail(), memberDto.getPassword(), memberDto.getName(), memberDto.getPhoneNumber(), memberDto.getBirthday(), MemberType.valueOf("NON_CERTIFIED"), memberDto.getMemberRole());

        return "redirect:/";
    }

    @GetMapping("/signin")
    public String signin(){
        return "member/signin";
    }
}
