package com.blitz.service;

import com.blitz.controller.dto.member.MemberJoinRequestDto;
import com.blitz.controller.dto.member.MemberListResponseDto;
import com.blitz.controller.dto.member.MemberResponseDto;
import com.blitz.controller.dto.member.MemberUpdateRequestDto;
import com.blitz.domain.member.Member;
import com.blitz.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
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
        member.update(requestDto.getPassword(), requestDto.getAddress(), requestDto.getNickName());
        return id;
    }

    @Transactional(readOnly = true)
    public MemberResponseDto findById(Long id) {
        Member entity = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당 사용자가 없습니다. id = " + id));
        return new MemberResponseDto(entity);
    }

    @Transactional(readOnly = true)
    public void delete(Long id) {
        Member entity = memberRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("해당사용자가 없습니다 id = " + id));
        memberRepository.delete(entity);
    }

    @Transactional(readOnly = true)
    public List<MemberListResponseDto> findAllDesc() {
        return memberRepository.findAllDesc().stream()
                .map(MemberListResponseDto::new)
                .collect(Collectors.toList());
    }
}
