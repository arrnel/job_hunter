package com.jobhunter.dto.education;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhunter.model.UserProfile;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

// INFO: Use for create, get and update course
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class EducationResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_profile_id")
    private Long userProfile;

    @JsonProperty("user")
    private Long user;

    @JsonProperty("company_id")
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

    @JsonProperty("date_created")
    private LocalDateTime dateCreated;

    @JsonProperty("date_updated")
    private LocalDateTime dateUpdated;

}
