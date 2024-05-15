package com.jobhunter.model;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.Accessors;

@Entity
@Table(schema = "categories", name = "industry_category")
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
//@SuperBuilder(toBuilder = true)
//@NoArgsConstructor
//@ToString(callSuper = true)
//@EqualsAndHashCode(callSuper = true)
//public class IndustryCategoryModel extends CategoryModel {
public class IndustryCategoryModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String name;
}
