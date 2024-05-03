package com.example.plan.model;

import jakarta.persistence.*;

import java.util.List;

/**
 * 마켓플레이스에 제공되어 있는 애플리케이션 정보
 * 회원이 구독할 대상
 */
@Table(name = "marketplace_apps")
@Entity
public class MarketplaceApp extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "APP_ID")
    private Long idx;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESC", nullable = false)
    private String desc;

    @OneToMany
    @JoinColumn(name = "plan_id")
    private List<Subscription> subscriptions;

    @OneToMany
    @JoinColumn(name = "per_id")
    private List<AppPermission> permissions;
}
