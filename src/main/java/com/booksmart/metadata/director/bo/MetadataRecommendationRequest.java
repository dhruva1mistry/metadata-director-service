package com.booksmart.metadata.director.bo;

import java.math.BigDecimal;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class MetadataRecommendationRequest {
    private String topic;
    private BigDecimal weight;

}
