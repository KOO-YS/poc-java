package com.example.plan.model;

import jakarta.persistence.*;

import java.util.ArrayList;
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
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "DESC", nullable = false)
    private String desc;

    @OneToMany(mappedBy = "app", fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<AppFunction> functions = new ArrayList<>();

}
