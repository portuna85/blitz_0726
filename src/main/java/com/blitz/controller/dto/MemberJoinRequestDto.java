package com.blitz.controller.dto;

import com.blitz.domain.member.Address;
import com.blitz.domain.member.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@NoArgsConstructor
public class MemberJoinRequestDto {
    private String account;
    private String password;
    private String name;
    private Address address;

    @Builder
    public MemberJoinRequestDto(String account, String password, String name, Address address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public Member toEntity() {
        return Member.builder()
                .account(account)
                .password(password)
                .name(name)
                .address(address)
                .build();
    }
}
