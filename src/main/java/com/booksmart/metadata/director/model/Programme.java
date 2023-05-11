package com.booksmart.metadata.director.model;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Programme {
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
