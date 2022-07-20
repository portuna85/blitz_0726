package com.blitz.controller.dto.member;

import com.blitz.domain.member.Address;
import com.blitz.domain.member.Member;
import lombok.Getter;

@Getter
public class MemberListResponseDto {
    private Long id;
    private String account;
    private String nickName;
    private String name;
    private Address address;

    public MemberListResponseDto(Member entity) {
        this.id = entity.getId();
        this.account = entity.getAccount();
        this.nickName = entity.getNickName();
        this.name = entity.getName();
        this.address = entity.getAddress();
    }
}
