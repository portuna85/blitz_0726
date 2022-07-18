package com.blitz.controller;

import com.blitz.controller.dto.MemberJoinRequestDto;
import com.blitz.controller.dto.MemberResponseDto;
import com.blitz.controller.dto.MemberUpdateRequestDto;
import com.blitz.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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
}
