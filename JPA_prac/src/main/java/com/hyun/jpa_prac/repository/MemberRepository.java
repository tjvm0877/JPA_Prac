package com.hyun.jpa_prac.repository;

import com.hyun.jpa_prac.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<Member, Long> {
}
