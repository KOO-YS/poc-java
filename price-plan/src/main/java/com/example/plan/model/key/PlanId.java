package com.example.plan.model.key;

import com.example.plan.model.PlanTier;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;

import java.io.Serializable;

@Embeddable
public class PlanId implements Serializable {

    @Column(name = "APP_ID", nullable = false)
    private Long appId;

    @Enumerated(EnumType.STRING)
    @Column(name = "PLAN_TIER", nullable = false)
    private PlanTier plantier;

}
