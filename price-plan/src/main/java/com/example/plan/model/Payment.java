package com.example.plan.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Table(name = "payments")
@Entity
public class Payment {

    @Id
    @Column(name = "pm_id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "ct_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "plan_id")
    private PricingPlan pricingPlan;

    @CreationTimestamp
    @Column(name = "pm_created_at")
    private LocalDateTime create_at;

    @UpdateTimestamp
    @Column(name = "pm_updated_at")
    private LocalDateTime updated_at;


}
