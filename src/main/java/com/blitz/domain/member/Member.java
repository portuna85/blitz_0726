package com.blitz.domain.member;

import com.blitz.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
public class Member extends BaseTimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "member_id")
    private Long id;

    @Column(name = "account", nullable = false)
    private String account;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "user_name", nullable = false)
    private String name;

    @Embedded
    private Address address;

    @Builder
    public Member(String account, String password, String name, Address address) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
    }

    public void update(String password, Address address) {
        this.password = password;
        this.address = address;
    }
}
