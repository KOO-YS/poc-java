package com.example.plan.model;

import jakarta.persistence.*;
import lombok.Builder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "marketplace_apps")
@Entity
public class MarketplaceApp {

    @Id
    @Column(name = "app_id")
    private int id;

    @Column(name = "app_name", nullable = false)
    private String name;

    @Column(name = "app_content", nullable = false)
    private String content;

    @CreationTimestamp
    @Column(name = "app_created_at")
    private LocalDateTime create_at;

    @UpdateTimestamp
    @Column(name = "app_updated_at")
    private LocalDateTime updated_at;

    @OneToMany
    @JoinColumn(name = "plan_id")
    private List<PricingPlan> pricingPlans;

    @OneToMany
    @JoinColumn(name = "per_id")
    private List<AppPermission> permissions;
}
