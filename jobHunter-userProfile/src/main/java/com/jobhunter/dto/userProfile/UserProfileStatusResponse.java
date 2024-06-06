package com.jobhunter.dto.userProfile;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.jobhunter.enums.UserProfileStatus;
import lombok.*;
import lombok.experimental.Accessors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@ToString
public class UserProfileStatusResponse {

    @JsonProperty("id")
    private Integer id;

    @JsonProperty("name")
    private UserProfileStatus name;

}
