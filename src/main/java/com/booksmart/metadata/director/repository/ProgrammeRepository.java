package com.booksmart.metadata.director.repository;

import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import com.booksmart.metadata.director.model.Programme;
import java.util.UUID;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends CrudRepository<Programme, UUID> {

    String FULLTEXT_SEARCH_QUERY = "SELECT new com.booksmart.metadata.director.bo.MetadataRecommendationResponse" +
            "(" +
                "ProgrammeUuid, SeasonUuid, SeriesUuid, episodeId, title, synopsis" +
            ") " +
            "FROM booksmart.Programme " +
            "WHERE MATCH " +
            "(" +
                "VQ_Title, VQ_EpisodeName, DQ_SeriesName, DQ_ProgrammeGenre, DQ_ProgrammeSubGenre, DQ_SeriesSubGenre, " +
                "DQ_ProgrammeTags, DQ_SeriesTags, VQ_TitleShortSynopsis, VQ_TitleLongSynopsis" +
            ") " +
            "AGAINST (?1 IN NATURAL LANGUAGE MODE)";


    @Query(value = FULLTEXT_SEARCH_QUERY, nativeQuery = true)
    Page<MetadataRecommendationResponse> search(String keyword, Pageable pageable);
}


