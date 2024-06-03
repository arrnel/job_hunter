package com.jobhunter.dto.experience;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;

// INFO: Use for create, get and update experience
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class ExperienceResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_profile_id")
    private Long userProfileId;

    @JsonProperty("user")
    private Long userId;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("position")
    private String position;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_from")
    private LocalDate from;

    @JsonProperty("date_to")
    private LocalDate to;

    @JsonProperty("date_created")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime dateCreated;

    @JsonProperty("date_updated")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDateTime dateUpdated;

}
