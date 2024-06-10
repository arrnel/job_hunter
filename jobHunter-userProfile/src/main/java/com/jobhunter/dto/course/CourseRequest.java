package com.jobhunter.dto.course;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

// INFO: Use for create, get and update course
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class CourseRequest {

    @JsonIgnore
    private Long userProfileId;

    @JsonProperty("company_id")
    private Long companyId;

    @JsonProperty("company_name")
    private String companyName;

    @JsonProperty("position")
    private String position;

    @JsonProperty("description")
    private String description;

    @JsonProperty("date_from")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate from;

    @JsonProperty("date_to")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private LocalDate to;

}
