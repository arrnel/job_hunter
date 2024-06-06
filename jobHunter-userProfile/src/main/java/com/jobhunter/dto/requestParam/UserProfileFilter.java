package com.jobhunter.dto.requestParam;

import com.jobhunter.model.UserProfileStatusEntity;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class UserProfileFilter {

    private String partialTitle;
    private String partialDescription;
    private String partialContent;
    private String statusName;
    private Integer statusId;
    private UserProfileStatusEntity status;
    private Long user;
    private String email;
    private Integer ageMin;
    private Integer ageMax;
    private Integer city;
    private Integer region;
    private Integer country;
    private Set<String> partExperienceTitle; //???
    private LocalDate from;
    private LocalDate to;

}
