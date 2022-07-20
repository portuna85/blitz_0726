package com.blitz.repository;

import com.blitz.domain.member.Member;
import com.blitz.domain.posts.Posts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface MemberRepository extends JpaRepository<Member, Long> {

    @Query("SELECT m FROM Member m ORDER BY m.id DESC")
    List<Member> findAllDesc();
}
