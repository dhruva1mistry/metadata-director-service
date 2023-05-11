package com.booksmart.metadata.director.model;

import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@Entity(name = "ProgrammeEntity")
@Table(name = "Programme")
@SqlResultSetMapping(
        name = "ProgrammeMapping",
        classes = {
                @ConstructorResult(
                        targetClass = MetadataRecommendationResponse.class,
                        columns = {
                                @ColumnResult(name = "programmeUuid", type = String.class),
                                @ColumnResult(name = "seasonUuid", type = String.class),
                                @ColumnResult(name = "seriesUuid", type = String.class),
                                @ColumnResult(name = "VQ_EpisodeNumber", type = Integer.class),
                                @ColumnResult(name = "VQ_Title", type = String.class),
                                @ColumnResult(name = "VQ_TitleLongSynopsis", type = String.class)
                        }
                )
        }
)
@NamedNativeQuery(
        name = "ProgrammeEntity.search",
        query = "SELECT p.ProgrammeUuid, p.SeasonUuid, p.SeriesUuid, p.VQ_EpisodeNumber, p.VQ_Title, p.VQ_TitleLongSynopsis " +
                "FROM Programme p " +
                "WHERE MATCH " +
                "(" +
                "p.VQ_Title, p.VQ_EpisodeName, p.DQ_SeriesName, p.DQ_ProgrammeGenre, p.DQ_ProgrammeSubGenre, p.DQ_SeriesSubGenre, " +
                "p.DQ_ProgrammeTags, p.DQ_SeriesTags, p.VQ_TitleShortSynopsis, p.VQ_TitleLongSynopsis" +
                ") " +
                "AGAINST (?1 IN NATURAL LANGUAGE MODE)",
        resultSetMapping = "ProgrammeMapping"
//        resultClass = MetadataRecommendationResponse.class
)
public class ProgrammeEntity implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ProgrammeUuid")
    private String programmeUuid;
    @Column(name="SeasonUuid")
    private String seasonUuid;
    @Column(name="SeriesUuid")
    private String seriesUuid;
    @Column(name="ContentType")
    private String contentType;
    @Column(name="VQ_Title")
    private String vqTitle;
    @Column(name="VQ_EpisodeNumber")
    private int vqEpisodeNumber;
    @Column(name="VQ_EpisodeName")
    private String vqEpisodeName;
    @Column(name="VQ_SeasonNumber")
    private int vqSeasonNumber;
    @Column(name="DQ_SeriesName")
    private String dqSeriesName;
    @Column(name="VQ_ContentSegments")
    private String vqContentSegments;
    @Column(name="DQ_ProgrammeGenre")
    private String dqProgrammeGenre;
    @Column(name="DQ_ProgrammeSubGenre")
    private String dqProgrammeSubgenre;
    @Column(name="DQ_SeriesSubGenre")
    private String dqSeriesSubgenre;
    @Column(name="VQ_ProductionYear")
    private int vqProductionYear;
    @Column(name="VQ_TargetAudience")
    private String vqTargetAudience;
    @Column(name="DQ_ProgrammeTags")
    private String dqProgrammeTags;
    @Column(name="DQ_SeriesTags")
    private String dqSeriesTags;
    @Column(name="VQ_TitleShortSynopsis")
    private String vqTitleShortSynopsis;
    @Column(name="VQ_TitleLongSynopsis")
    private String vqTitleLongSynopsis;
    @Column(name="VQ_KafkaKey")
    private String vqKafkaKey;
}
