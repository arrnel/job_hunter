package com.jobhunter.dto.requestParam;

import lombok.*;
import lombok.experimental.Accessors;

import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class UserProfileFilterValues {

    private String partialTitle;
    private String partialDescription;
    private String partialContent;
    private String statusName;
    private Integer statusId;
    private Long user;
    private String email;
    private Integer ageMin;
    private Integer ageMax;
    private Integer city;
    private Integer region;
    private Integer country;
    private Set<String> partExperienceTitle; //???
    private String from;
    private String to;

}
