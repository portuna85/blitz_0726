package com.blitz.service;

import com.blitz.controller.dto.MemberJoinRequestDto;
import com.blitz.controller.dto.MemberResponseDto;
import com.blitz.controller.dto.MemberUpdateRequestDto;
import com.blitz.domain.member.Member;
import com.blitz.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    /**
     * 회원 가입
     */
    @Transactional
    public Long join(MemberJoinRequestDto requestDto) {
        return memberRepository.save(requestDto.toEntity()).getId();
    }

    @Transactional
    public Long update(Long id, MemberUpdateRequestDto requestDto) {
        Member member = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        member.update(requestDto.getPassword(), requestDto.getAddress());
        return id;
    }

    @Transactional
    public MemberResponseDto findById(Long id) {
        Member entity = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new MemberResponseDto(entity);
    }

    @Transactional
    public void delete(Long id) {
        Member entity = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다 id = " + id));
        memberRepository.delete(entity);
    }
}
