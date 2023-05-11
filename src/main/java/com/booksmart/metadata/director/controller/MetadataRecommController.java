package com.booksmart.metadata.director.controller;

import com.booksmart.metadata.director.bo.MetadataRecommendationRequest;
import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import com.booksmart.metadata.director.service.MetadataRecommService;
import java.util.List;
import java.util.Map;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/keybert-db")
@AllArgsConstructor
public class MetadataRecommController {

    @Autowired
    private MetadataRecommService metadataRecommService;

    @PostMapping(consumes = APPLICATION_JSON_VALUE,
            produces = APPLICATION_JSON_VALUE)
    public @ResponseBody Map<String, List<MetadataRecommendationResponse>> getRecommendation(
            @RequestBody List<MetadataRecommendationRequest> recommendationRequest) {
        return metadataRecommService.getMetadata(recommendationRequest);
    }

}
