package com.booksmart.metadata.director.service;

import com.booksmart.metadata.director.bo.MetadataRecommendationRequest;
import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import com.booksmart.metadata.director.repository.ProgrammeRepository;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class MetadataRecommService {

    @Autowired
    private ProgrammeRepository programmeRepository;

    public Map<String, List<MetadataRecommendationResponse>> getMetadata(List<MetadataRecommendationRequest> recommendationRequest) {

        Set<String> topics = recommendationRequest.stream()
                .map(MetadataRecommendationRequest::getTopic)
                .collect(Collectors.toSet());

        Pageable pageable = PageRequest.of(2, 10);

        return topics.stream()
                .map(topic -> Map.of(topic, programmeRepository.search(topic, pageable).getContent()))
                .flatMap(map -> map.entrySet().stream())
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }
}
