package com.blitz.controller;

import com.blitz.controller.dto.member.MemberJoinRequestDto;
import com.blitz.controller.dto.member.MemberListResponseDto;
import com.blitz.controller.dto.member.MemberResponseDto;
import com.blitz.controller.dto.member.MemberUpdateRequestDto;
import com.blitz.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MemberApiController {

    private final MemberService memberService;

    @PostMapping("/api/v1/member")
    public Long join(@RequestBody MemberJoinRequestDto requestDto) {
        return memberService.join(requestDto);
    }

    @PutMapping("/api/v1/member/{id}")
    public Long update(@PathVariable Long id, @RequestBody MemberUpdateRequestDto requestDto) {
        return memberService.update(id, requestDto);
    }

    @GetMapping("/api/v1/member/{id}")
    public MemberResponseDto findById(@PathVariable Long id) {
        return memberService.findById(id);
    }

    @DeleteMapping("/api/v1/member/{id}")
    public void deleteUser(@PathVariable Long id) {
        memberService.delete(id);
    }

    @GetMapping("/api/v1/member/list")
    public List<MemberListResponseDto> findAll() {
        return memberService.findAllDesc();
    }
}
