package com.example.plan.model;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

/**
 * 마켓플레이스 앱별로 제공할 구독 범위 유형
 * 앱, 유형에 따라 제공하는 서비스가 달라진다
 */
@Table(name = "plans")
@Entity
public class Plan {

    @Id
    @Column(name = "PLAN_ID")
    private Long id;



    @CreationTimestamp
    @Column(name = "pm_created_at")
    private LocalDateTime create_at;

    @UpdateTimestamp
    @Column(name = "pm_updated_at")
    private LocalDateTime updated_at;


}
