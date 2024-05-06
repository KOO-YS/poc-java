package com.example.plan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name = "app_functions")
@Entity
public class AppFunction extends AuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "FUNC_ID")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "APP_ID", nullable = false)
    private MarketplaceApp app;

    @Column(name = "TITLE")
    private String title;

    @Column(name = "DESC")
    private String desc;

    @Enumerated(EnumType.STRING)
    @Column(name = "FUNCTION_TIER")
    private PlanTier tier = PlanTier.FREE;
}
