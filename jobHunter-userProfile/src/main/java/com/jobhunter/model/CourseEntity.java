package com.jobhunter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(schema = "profiles", name = "course")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
@EqualsAndHashCode
public class CourseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_profile_id", referencedColumnName = "id", nullable = false, updatable = false)
    private UserProfile userProfile;

    @Column(name = "user_id", nullable = false, updatable = false)
    private Long user;

    @Column(name = "company_id", nullable = false)
    private Long companyId;

    @Column(name = "company_name", nullable = false)
    private String companyName;

    @Column(name = "position", nullable = false)
    private String position;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_from", nullable = false)
    private LocalDate from;

    @Column(name = "date_to", nullable = false)
    private LocalDate to;

    @Column(name = "date_created", nullable = false, updatable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

}
