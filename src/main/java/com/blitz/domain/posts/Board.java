package com.blitz.domain.posts;

import com.blitz.domain.BaseTimeEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Board extends BaseTimeEntity {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "boardlist_id")
    private Long id;

    @Column(name = "boardlist_name", nullable = false)
    private String name;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "posts_id")
    private Posts posts;

    @Builder
    public Board(String name) {
        this.name = name;
    }

    public void update(String name) {
        this.name = name;
    }
}
