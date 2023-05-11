package com.booksmart.metadata.director.repository;

import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import com.booksmart.metadata.director.model.ProgrammeEntity;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgrammeRepository extends JpaRepository<ProgrammeEntity, UUID> {

    String COUNT_NATIVE_QUERY = "SELECT COUNT(*) "+
            "FROM Programme p " +
            "WHERE MATCH " +
            "(" +
            "p.VQ_Title, p.VQ_EpisodeName, p.DQ_SeriesName, p.DQ_ProgrammeGenre, p.DQ_ProgrammeSubGenre, p.DQ_SeriesSubGenre, " +
            "p.DQ_ProgrammeTags, p.DQ_SeriesTags, p.VQ_TitleShortSynopsis, p.VQ_TitleLongSynopsis" +
            ") " +
            "AGAINST (?1)";
    @Query(nativeQuery = true,
            countQuery = "COUNT_NATIVE_QUERY"
    )
    List<MetadataRecommendationResponse> search(String keyword);
}


