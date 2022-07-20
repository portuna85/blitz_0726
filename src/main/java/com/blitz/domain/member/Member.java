package com.blitz.domain.member;

import com.blitz.domain.BaseTimeEntity;
import com.blitz.domain.posts.Posts;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

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

    @Column(name = "nickname", nullable = false)
    private String nickName;

    @Column(name = "user_name", nullable = false)
    private String name;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Posts> postsList = new ArrayList<>();

    @Embedded
    private Address address;

    @Builder
    public Member(String account, String password, String name, Address address, String nickName) {
        this.account = account;
        this.password = password;
        this.name = name;
        this.address = address;
        this.nickName = nickName;
    }

    public void update(String password, Address address, String nickName) {
        this.password = password;
        this.address = address;
        this.nickName = nickName;
    }
}
