package com.jobhunter.dto.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhunter.model.UserProfile;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

// INFO: Use for get user profile
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class CourseResponseShort {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_profile_id")
    private UserProfile userProfile;

    @JsonProperty("user")
    private Long user;

    @JsonProperty("school_id")
    private Long companyId;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("position")
    private String position;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_from")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate from;

    @JsonProperty("date_to")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate to;

}
