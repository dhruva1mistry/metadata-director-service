package com.booksmart.metadata.director.model;

import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import java.io.Serializable;
import java.util.UUID;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity
@Table(name = "Programme")
@SqlResultSetMapping(
        name = "ProgrammeMapping",
        classes = {
                @ConstructorResult(
                        targetClass = MetadataRecommendationResponse.class,
                        columns = {
                                @ColumnResult(name = "programmeUuid", type = UUID.class),
                                @ColumnResult(name = "seasonUuid", type = UUID.class),
                                @ColumnResult(name = "seriesUuid", type = UUID.class),
                                @ColumnResult(name = "episodeId", type = Integer.class),
                                @ColumnResult(name = "title", type = String.class),
                                @ColumnResult(name = "title", type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "ProgrammeEntity.search",
        query = "SELECT new " +
                "com.booksmart.metadata.director.bo.MetadataRecommendationResponse(" +
                "UUID.fromString(programmeUuid), UUID.fromString(seasonUuid), UUID.fromString(seriesUuid), episodeId, title, synopsis" +
                ") " +
                "FROM Programme" +
                "WHERE MATCH " +
                "(" +
                "VQ_Title, VQ_EpisodeName, DQ_SeriesName, DQ_ProgrammeGenre, DQ_ProgrammeSubGenre, DQ_SeriesSubGenre, " +
                "DQ_ProgrammeTags, DQ_SeriesTags, VQ_TitleShortSynopsis, VQ_TitleLongSynopsis" +
                ") " +
                "AGAINST (?1 IN NATURAL LANGUAGE MODE)",
        resultSetMapping = "ProgrammeMapping",
        resultClass = MetadataRecommendationResponse.class
)
public class ProgrammeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID programmeUuid;
    private UUID seasonUuid;
    private UUID seriesUuid;
    private String contentType;
    private String vqTitle;
    private int vqEpisodeNumber;
    private String vqEpisodeName;
    private int vqSeasonNumber;
    private String dqSeriesName;
    private String vqContentSegments;
    private String dqProgrammeGenre;
    private String dqProgrammeSubgenre;
    private String dqSeriesSubgenre;
    private int vqProductionYear;
    private String vqTargetAudience;
    private String dqProgrammeTags;
    private String dqSeriesTags;
    private String vqTitleShortSynopsis;
    private String vqTitleLongSynopsis;
    private String vqKafkaKey;
}
