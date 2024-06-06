package com.jobhunter.model;

import com.jobhunter.enums.Currency;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "jobs", name = "job")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Job {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "company", nullable = false)
    private Long companyId;

    @Column(name = "name", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "min_price", nullable = false)
    private BigDecimal minPrice;

    @Column(name = "min_price_in_default_currency", nullable = false)
    private BigDecimal minPriceInDefaultCurrency;

    @Column(name = "max_price", nullable = false)
    private BigDecimal maxPrice;

    @Column(name = "max_price_in_default_currency", nullable = false)
    private BigDecimal maxPriceInDefaultCurrency;

    @Enumerated(EnumType.STRING)
    @Column(name = "currency")
    private Currency currency;

    @ManyToOne
    @JoinColumn(name = "price_type", referencedColumnName = "id")
    private PriceTypeEntity priceType;

    @Column(name = "city")
    private Integer cityId;

    @Column(name = "region")
    private Integer regionId;

    @Column(name = "country")
    private Integer countryId;

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "jobs",
            name = "job_job_type",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "job_type_id", referencedColumnName = "id"))
    private Set<JobTypeEntity> jobTypes = new HashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "jobs",
            name = "job_industry_subcategory",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"))
    private Set<IndustrySubCategoryModel> industriesSubCategories = new HashSet<>();

    @Builder.Default
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            schema = "jobs",
            name = "job_specialization_subcategory",
            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"))
    private Set<SpecializationSubCategoryModel> specializationSubCategories = new HashSet<>();

    @Column(name = "date_created", nullable = false)
    private LocalDateTime dateCreated;

    @Column(name = "date_updated")
    private LocalDateTime dateUpdated;

}


//@Entity
//@Table(schema = "jobs", name = "job")
//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
//@Accessors(chain = true)
//public class Job {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id", nullable = false)
//    private Long id;
//
//    @Column(name = "company", nullable = false)
//    private Long companyId;
//
//    @Column(name = "name", nullable = false)
//    private String title;
//
//    @Column(name = "description", nullable = false)
//    private String description;
//
//    @Column(name = "min_price", nullable = false)
//    private BigDecimal minPrice;
//
//    @Column(name = "min_price_in_default_currency", nullable = false)
//    private BigDecimal minPriceInDefaultCurrency;
//
//    @Column(name = "max_price", nullable = false)
//    private BigDecimal maxPrice;
//
//    @Column(name = "max_price_in_default_currency", nullable = false)
//    private BigDecimal maxPriceInDefaultCurrency;
//
//    @Enumerated(EnumType.STRING)
//    @Column(name = "currency")
//    private Currency currency;
//
//    @ManyToOne
//    @JoinColumn(name = "price_type", referencedColumnName = "id")
//    private PriceTypeEntity priceType;
//
//    @Column(name = "city")
//    private Integer cityId;
//
//    @Column(name = "region")
//    private Integer regionId;
//
//    @Column(name = "country")
//    private Integer countryId;
//
//
////    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    @JoinTable(
////            schema = "jobs",
////            name = "job_job_type",
////            joinColumns = @JoinColumn(name = "job_id"),
////            inverseJoinColumns = @JoinColumn(name = "job_type_id"))
//    @Builder.Default
//    @ManyToMany
//    @JoinTable(
//            schema = "jobs",
////            name = "job_type",
//            name = "job_job_type",
//            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "job_type_id", referencedColumnName = "id"))
//    private Set<JobTypeEntity> jobTypes = new HashSet<>();
//
////    @Builder.Default
////    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    @JoinTable(
////            schema = "jobs",
////            name = "job_industry_subcategory",
////            joinColumns = @JoinColumn(name = "job_id"),
////            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
//    @Builder.Default
//    @ManyToMany
//    @JoinTable(
////            schema = "categories",
////            name = "industry_subcategory",
//            schema = "jobs",
//            name = "job_industry_subcategory",
//            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"))
//    private Set<IndustrySubCategoryModel> industriesSubCategories = new HashSet<>();
//
////    @Builder.Default
////    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
////    @JoinTable(
////            schema = "jobs",
////            name = "job_specialization_subcategory",
////            joinColumns = @JoinColumn(name = "job_id"),
////            inverseJoinColumns = @JoinColumn(name = "subcategory_id"))
//    @Builder.Default
//    @ManyToMany
//    @JoinTable(
////            schema = "categories",
////            name = "industry_subcategory",
//            schema = "jobs",
//            name = "job_specialization_subcategory",
//            joinColumns = @JoinColumn(name = "job_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "subcategory_id", referencedColumnName = "id"))
//    private Set<SpecializationSubCategoryModel> specializationSubCategories = new HashSet<>();
//
//    @Column(name = "date_created", nullable = false)
//    private LocalDateTime dateCreated;
//
//    @Column(name = "date_updated")
//    private LocalDateTime dateUpdated;
//
//}
