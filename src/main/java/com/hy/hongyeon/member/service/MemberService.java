package com.hy.hongyeon.member.service;

import com.hy.hongyeon.global.exception.DataNotFoundException;
import com.hy.hongyeon.member.entity.Member;
import com.hy.hongyeon.member.entity.MemberRole;
import com.hy.hongyeon.member.entity.MemberType;
import com.hy.hongyeon.member.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class MemberService {
    private final MemberRepository memberRepository;
    @Autowired
    private PasswordEncoder passwordEncoder; // 필드 주입

    @Autowired
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Transactional
    public Member createMember(String username, String email, String password, String name, String phoneNumber, LocalDate birthDay, MemberType memberType, MemberRole role) {

        // Member 객체 생성
        Member newMember = Member.builder()
                .username(username)
                .createDate(LocalDateTime.now())
                .email(email)
                .password(passwordEncoder.encode(password))
                .name(name)
                .phoneNumber(phoneNumber)
                .birthDay(birthDay)
                .memberType(memberType)
                .role(role)
                .build();

        // Member 객체 저장
        return memberRepository.save(newMember);
    }

    public Member getMember(String username){
        Optional<Member> member = this.memberRepository.findByUsername(username);
        if(member.isPresent()){
            return member.get();
        } else {
            throw new DataNotFoundException("member not found");
        }
    }
}
