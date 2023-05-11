package com.booksmart.metadata.director.controller;

import com.booksmart.metadata.director.bo.MetadataRecommendationRequest;
import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import com.booksmart.metadata.director.service.MetadataRecommService;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "/keybert-db")
@AllArgsConstructor
public class MetadataRecommController {

    @Autowired
    private MetadataRecommService metadataRecommService;

    @GetMapping
    public Map<String, List<MetadataRecommendationResponse>> getRecommendation(
            @RequestBody List<MetadataRecommendationRequest> recommendationRequest) {
        return metadataRecommService.getMetadata(recommendationRequest);
    }

}
