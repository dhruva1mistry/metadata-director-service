package com.booksmart.metadata.director.bo;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Data
@AllArgsConstructor
public class MetadataRecommendationResponse {
    private UUID programmeUuid;
    private UUID seasonUuid;
    private UUID seriesUuid;
    private int episodeId;
    private String title;
    private String synopsys;
}
