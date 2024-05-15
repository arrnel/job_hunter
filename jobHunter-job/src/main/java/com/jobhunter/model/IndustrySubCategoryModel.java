package com.jobhunter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "categories", name = "industry_subcategory")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
//@SuperBuilder(toBuilder = true)
//@NoArgsConstructor
//@Accessors(chain = true)
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
//public class IndustrySubCategoryModel extends SubCategoryModel {
public class IndustrySubCategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private IndustryCategoryModel category;

//    @ManyToMany(mappedBy = "industriesSubCategories")
//    Set<Job> jobs = new HashSet<>();

}
