package com.example.plan.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 마켓플레이스 기본 회원 정보
 *
 */
@Table(name = "app_users")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class AppUser extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "USER_ID")
    private Long id;

    @Column(name = "USER_ACCOUNT", nullable = false, unique = true)
    private String account;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "appUser", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions = new ArrayList<>();

    // SKIP : Authorizations
}
