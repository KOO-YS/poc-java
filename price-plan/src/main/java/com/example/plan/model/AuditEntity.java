package com.example.plan.model;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.Instant;

@MappedSuperclass
public abstract class AuditEntity {

    @Size(max = 50)
    @NotNull
    @Column(name = "CREATED_BY", nullable = false, length = 50)
    private String createdBy;

    @CreationTimestamp
    @NotNull
    @Column(name = "CREATED_DATE", nullable = false)
    private Instant createdDate = Instant.now();

    @Size(max = 50)
    @NotNull
    @Column(name = "LAST_MODIFIED_BY", nullable = false, length = 50)
    private String lastModifiedBy;

    @UpdateTimestamp
    @NotNull
    @Column(name = "LAST_MODIFIED_DATE", nullable = false)
    private Instant lastModifiedDate = Instant.now();


}
