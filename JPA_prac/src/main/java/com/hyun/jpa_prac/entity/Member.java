package com.hyun.jpa_prac.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String memberName;

    @OneToMany(mappedBy = "member", fetch = FetchType.EAGER)
    private List<Orders> orders = new ArrayList<>();

    public Member(String memberName) {
        this.memberName = memberName;
    }
}
