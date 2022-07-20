package com.blitz.controller.dto.member;

import com.blitz.domain.member.Address;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter
@NoArgsConstructor
public class MemberUpdateRequestDto {
    private String password;
    private Address address;
    private String nickName;

    @Builder
    public MemberUpdateRequestDto(String password, Address address, String nickName) {
        this.password = password;
        this.address = address;
        this.nickName = nickName;
    }
}
