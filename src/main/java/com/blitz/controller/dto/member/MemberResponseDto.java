package com.blitz.controller.dto.member;

import com.blitz.domain.member.Address;
import com.blitz.domain.member.Member;
import lombok.Getter;


@Getter
public class MemberResponseDto {

    private Long id;
    private String account;
    private String password;
    private String name;
    private Address address;
    private String nickName;

    public MemberResponseDto(Member entity) {
        this.account = entity.getAccount();
        this.password = entity.getPassword();
        this.name = entity.getName();
        this.address = entity.getAddress();
        this.nickName = entity.getNickName();
    }
}
