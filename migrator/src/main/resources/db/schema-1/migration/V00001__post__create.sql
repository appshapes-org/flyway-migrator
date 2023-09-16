-- noinspection SqlDialectInspectionForFile
-- @formatter:off
CREATE TABLE IF NOT EXISTS `post`
(
    `id`    int          NOT NULL,
    `title` varchar(100) NOT NULL,
    PRIMARY KEY (`id`)
    ) ENGINE = InnoDB
    DEFAULT CHARSET = utf8mb4
    COLLATE = utf8mb4_0900_ai_ci;