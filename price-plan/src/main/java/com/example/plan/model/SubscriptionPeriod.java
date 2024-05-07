package com.example.plan.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

/**
 * 구독이 유효한 기간
 */
@Table(name = "subscription_periods")
@Entity
public class SubscriptionPeriod extends AuditEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "SUB_PERIOD_ID")
    private Long id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "SUB_ID", referencedColumnName = "SUB_ID")
    private Subscription subscription;

    @Column(name = "SUB_PERIOD_START_DATE")
    private LocalDate startDate;

    @Column(name = "SUB_PERIOD_END_DATE")
    private LocalDate endDate;
}

