package com.blitz.controller.dto;

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

    @Builder
    public MemberUpdateRequestDto(String password, Address address) {
        this.password = password;
        this.address = address;
    }
}
