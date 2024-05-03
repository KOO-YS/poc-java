package com.example.plan.model;


import jakarta.persistence.*;
import lombok.*;

import java.util.List;

/**
 * 마켓플레이스 기본 회원정보
 *
 */
@Table(name = "customers")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CUSTOMER_ID")
    private Long idx;

    @Column(name = "CUSTOMER_ACCOUNT", nullable = false, unique = true)
    private String account;

    @Column(name = "FIRST_NAME", nullable = false)
    private String firstName;

    @Column(name = "LAST_NAME", nullable = false)
    private String lastName;

    @OneToMany(mappedBy = "customer", cascade = CascadeType.ALL)
    private List<Subscription> subscriptions;

    // SKIP : Authorizations
}
