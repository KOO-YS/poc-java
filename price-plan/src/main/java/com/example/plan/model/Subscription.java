package com.example.plan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.ArrayList;
import java.util.List;

/**
 * 한 회원이 앱에 대해 신청한 구독 정보
 */
@Table(name = "subscriptions")
@Entity
public class Subscription extends AuditEntity{

    @Id
    @Column(name = "SUB_ID")
    private Integer id;

    @Column(name = "APP_ID", nullable = false)
    private Integer appId;

    @ManyToOne
    @JoinColumn(name = "USER_ID", referencedColumnName = "USER_ID")
    private AppUser appUser;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan_tier", nullable = false)
    private PlanTier planTier = PlanTier.FREE;

    @OneToMany(mappedBy = "subscription", fetch = FetchType.LAZY)
    @OrderBy("startDate")
    private List<SubscriptionPeriod> periods = new ArrayList<>();



}
