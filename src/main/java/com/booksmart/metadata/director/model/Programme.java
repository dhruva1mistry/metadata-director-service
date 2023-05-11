package com.booksmart.metadata.director.model;

import com.booksmart.metadata.director.bo.MetadataRecommendationResponse;
import java.io.Serializable;
import java.time.Instant;
import java.util.UUID;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
//@SqlResultSetMapping(
//        name = "userEntityMapping",
//        classes = {
//                @ConstructorResult(
//                        targetClass = MetadataRecommendationResponse.class,
//                        columns = {
//                                @ColumnResult(name = "campId", type = Integer.class),
//                                @ColumnResult(name = "userCount", type = Byte.class),
//                                @ColumnResult(name = "modifiedAt", type = Instant.class)
//                        }
//                )
//        }
//)
//@NamedNativeQuery(
//        name = "UserEntity.getStatsDTO",
//        query = "YOUR_QUERY",
//        resultSetMapping = "userEntityMapping"
//)
public class Programme implements Serializable {
    @Id
    private UUID ProgrammeUuid;
    private UUID SeasonUuid;
    private UUID SeriesUuid;
    private String ContentType;
    private String VQ_Title;
    private int VQ_EpisodeNumber;
    private String VQ_EpisodeName;
    private int VQ_SeasonNumber;
    private String DQ_SeriesName;
    private String VQ_ContentSegments;
    private String DQ_ProgrammeGenre;
    private String DQ_ProgrammeSubGenre;
    private String DQ_SeriesSubGenre;
    private int VQ_ProductionYear;
    //  complex string eg. type:TVPG&value:TVMA|type:BSkyBca&value:7
    private String VQ_TargetAudience;
    //  complex string eg. Defiance|Pro Wrestling|Special|Sports|Sports non-event
    //  complex string eg. 8th Century|9th Century|Action|Action & Adventure|Adventure|Adventures|Animosity
    private String DQ_ProgrammeTags;
    private String DQ_SeriesTags;
    private String VQ_TitleShortSynopsis;
    private String VQ_TitleLongSynopsis;
    private String VQ_KafkaKey;
}
