package com.jobhunter.dto.requestParam;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.HashSet;
import java.util.Set;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class ExperienceFilter {

    @Builder.Default
    private Set<Long> ids = new HashSet<>();

    private Long userProfile;

}
