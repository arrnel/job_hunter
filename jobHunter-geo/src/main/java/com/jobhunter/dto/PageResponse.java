package com.jobhunter.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
public class PageResponse {

    @JsonProperty("page")
    Integer currentPage;

    @JsonProperty("per_page")
    Integer perPage;

    @JsonProperty("total")
    Integer total;

    @JsonProperty("total_pages")
    Integer totalPages;

    @JsonProperty("data")
    List<?> data;

}
