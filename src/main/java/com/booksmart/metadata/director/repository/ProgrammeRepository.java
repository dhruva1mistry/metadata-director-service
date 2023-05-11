package com.booksmart.metadata.director.repository;

import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import com.booksmart.metadata.director.model.ProgrammeEntity;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends CrudRepository<ProgrammeEntity, UUID> {

    @Query(nativeQuery = true)
    Page<MetadataRecommendationResponse> search(String keyword, Pageable pageable);
}


