package com.jobhunter.dto.userProfile;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class UserProfileRequest {

    @JsonProperty("email")
    private String email;

    @JsonProperty("first_name")
    private String firstName;

    @JsonProperty("last_name")
    private String lastName;

    @JsonProperty("position")
    private String position;

    @JsonProperty("description")
    private String description;

    @JsonProperty("birth_date")
    @JsonFormat(pattern = "dd.MM.yyyy")
    private LocalDate birthDate;

    @JsonProperty("is_birth_date_visible")
    private Boolean isBirthDateVisible;

    @JsonProperty("city_id")
    private Integer cityId;

    @JsonProperty("avatar_id")
    private Integer avatarId;

    @JsonProperty("status_name")
    private String status;

}
