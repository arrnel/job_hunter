package com.jobhunter.dto.userProfile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhunter.dto.course.CourseResponseShort;
import com.jobhunter.dto.education.EducationResponseShort;
import com.jobhunter.dto.experience.ExperienceResponseShort;
import com.jobhunter.enums.UserProfileStatus;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class UserProfileResponse {

    @JsonProperty("id")
    private Long id;

    @JsonProperty("user_id")
    private Long userId;

    @JsonProperty("email")
    private String email;

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("title")
    private String title;

    @JsonProperty("description")
    private String description;

    @JsonProperty("birth_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    @JsonProperty("is_birth_date_visible")
    private Boolean isBirthDateVisible;

    @JsonProperty("cityId")
    private Integer cityId;

    @JsonProperty("avatar_id")
    private Integer avatarId;

    @JsonProperty("status")
    private UserProfileStatus status;

    @Builder.Default
    @JsonProperty("experiences")
    private Set<ExperienceResponseShort> experiences = new HashSet<>();

    @Builder.Default
    @JsonProperty("courses")
    private Set<CourseResponseShort> courses = new HashSet<>();

    @Builder.Default
    @JsonProperty("educations")
    private Set<EducationResponseShort> educations = new HashSet<>();

    @JsonProperty("date_created")
    private LocalDateTime dateCreated;

    @JsonProperty("date_updated")
    private LocalDateTime dateUpdated;

}
