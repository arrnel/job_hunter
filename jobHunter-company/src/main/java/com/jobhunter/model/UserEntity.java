package com.jobhunter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "companies", name = "user")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @OneToMany(mappedBy = "user")
    @JoinColumn(name = "company_id")
    private Set<UserCompanyRole> companies = new HashSet<>();

    @Column(name = "date_added", nullable = false)
    private LocalDateTime dateAdded;

}
