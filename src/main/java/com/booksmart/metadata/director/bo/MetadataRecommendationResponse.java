package com.booksmart.metadata.director.bo;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MetadataRecommendationResponse {
    private String programmeUuid;
    private String seasonUuid;
    private String seriesUuid;
    private int episodeId;
    private String title;
    private String synopsys;
}
