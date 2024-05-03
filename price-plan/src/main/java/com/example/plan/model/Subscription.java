package com.example.plan.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.List;

@Builder
@RequiredArgsConstructor
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "subscriptions")
@Entity
public class Subscription {

    @Id
    @Column(name = "SUB_ID")
    private Integer id;

    @Column(name = "APP_ID", nullable = false)
    private Integer appId;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan_type", nullable = false)
    @Builder.Default
    private PlanType planType = PlanType.FREE;

    @Column(name = "plan_price", nullable = false)
    @Builder.Default
    private Integer price = 0;

    @OneToMany(mappedBy = "pricingPlan")
    private List<Plan> plans;

}
