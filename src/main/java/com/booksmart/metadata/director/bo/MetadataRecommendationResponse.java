package com.booksmart.metadata.director.bo;

import java.util.UUID;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MetadataRecommendationResponse {
    private UUID ProgrammeUuid;
    private UUID SeasonUuid;
    private UUID SeriesUuid;
    private int episodeId;
    private String title;
    private String synopsys;
}
