package com.example.plan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Table(name = "app_permission")
@Entity
public class AppPermission {

    @Id
    @Column(name = "per_id")
    private Long id;

    @Column(name = "app_id")
    private Integer appId;

    @Column(name = "plan_type")
    private PricingPlanType planType;

    @Column(name = "per_content")
    private String content;



}
