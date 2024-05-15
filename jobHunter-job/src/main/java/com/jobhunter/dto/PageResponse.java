package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class PageResponse {

    @JsonProperty("current_page")
    @Builder.Default
    private Integer currentPage = 0;

    @JsonProperty("pages")
    @Builder.Default
    private Integer totalPages = 0;

    @JsonProperty("items_per_page")
    @Builder.Default
    private Integer itemsPerPage = 0;

    @JsonProperty("total_items")
    @Builder.Default
    private Long totalItems = 0L;

    @JsonProperty("data")
    @Builder.Default
    private List<?> data = new ArrayList<>();

}
