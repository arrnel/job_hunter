package com.jobhunter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.SuperBuilder;

import java.util.HashSet;
import java.util.Set;

@Entity
@Table(schema = "categories", name = "specialization_subcategory")
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
//public class SpecializationSubCategoryModel extends SubCategoryModel {
public class SpecializationSubCategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "category")
    private SpecializationCategoryModel category;

//    @ManyToMany(mappedBy = "specializationSubCategories")
//    Set<Job> jobs = new HashSet<>();

}
