package com.hy.hongyeon.member.repository;

import com.hy.hongyeon.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {

}
