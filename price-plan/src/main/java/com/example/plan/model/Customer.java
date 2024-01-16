package com.example.plan.model;


import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Table(name = "customers")
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ct_idx")
    private Long idx;

    @Column(name = "ct_account", nullable = false, unique = true)
    private String account;

    @Column(name = "ct_first_name", nullable = false)
    private String firstName;

    @Column(name = "ct_last_name", nullable = false)
    private String lastName;

    @Column(name = "ct_vaild_code", nullable = false, unique = true)
    private String validCode;

    @OneToMany(mappedBy = "customer")
    private List<Payment> payments;

    @CreationTimestamp
    @Column(name = "ct_created_at")
    private LocalDateTime create_at;

    @UpdateTimestamp
    @Column(name = "ct_updated_at")
    private LocalDateTime updated_at;


}
