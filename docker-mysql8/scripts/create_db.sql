SET GLOBAL local_infile = true;
SET sql_mode="";

USE booksmart_metadata;

CREATE TABLE programmes
(
    ProgrammeUuid         VARCHAR(255) NOT NULL,
    SeasonUuid            VARCHAR(255),
    SeriesUuid            VARCHAR(255),
    ContentType           VARCHAR(255) NOT NULL,
    VQ_Title              VARCHAR(255) NOT NULL,
    VQ_EpisodeNumber      INT NULL,
    VQ_EpisodeName        VARCHAR(255),
    VQ_SeasonNumber       INT NULL,
    DQ_SeriesName         VARCHAR(255),
    VQ_ContentSegments    VARCHAR(255) NOT NULL,
    DQ_ProgrammeGenre     VARCHAR(255),
    DQ_ProgrammeSubGenre  VARCHAR(255),
    DQ_SeriesSubGenre     VARCHAR(255),
    VQ_ProductionYear     INT(4) NULL,
    VQ_TargetAudience     VARCHAR(255),
    DQ_ProgrammeTags      VARCHAR(255) NOT NULL,
    DQ_SeriesTags         VARCHAR(255) NOT NULL,
    VQ_TitleShortSynopsis VARCHAR(255) NOT NULL,
    VQ_TitleLongSynopsis  VARCHAR(255) NOT NULL,
    VQ_KafkaKey           VARCHAR(255) NOT NULL,

    PRIMARY KEY (ProgrammeUuid)
);

LOAD DATA INFILE '/var/lib/mysql-files/docker-resources/data/booksmart_programmes_metadata_db.csv'
INTO TABLE booksmart_metadata.programmes
FIELDS TERMINATED BY ','
ENCLOSED BY '"'
LINES TERMINATED BY '\n'
IGNORE 1 ROWS;



-- GRANT ALL ON *.* TO 'dhruva'@'localhost' WITH GRANT OPTION;
