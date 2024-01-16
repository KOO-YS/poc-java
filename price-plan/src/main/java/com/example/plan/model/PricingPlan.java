package com.example.plan.model;

import jakarta.persistence.*;
import lombok.Builder;

import java.util.List;

@Table(name = "pricing_plans")
@Entity
public class PricingPlan {

    @Id
    @Column(name = "plan_id")
    private Integer id;

    @Column(name = "app_id", nullable = false)
    private Integer appId;

    @Enumerated(EnumType.STRING)
    @Column(name = "plan_type", nullable = false)
    @Builder.Default
    private PricingPlanType planType = PricingPlanType.FREE;

    @Column(name = "plan_price", nullable = false)
    @Builder.Default
    private Integer price = 0;

    @OneToMany(mappedBy = "pricingPlan")
    private List<Payment> payments;

}
