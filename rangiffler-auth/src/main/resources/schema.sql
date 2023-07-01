CREATE DATABASE IF NOT EXISTS `rangiffler-auth`;
USE `rangiffler-auth`;

CREATE TABLE IF NOT EXISTS `users` (
    `id`                        CHAR(36)        NOT NULL DEFAULT (UUID()),
    `username`                  VARCHAR(50)     NOT NULL,
    `password`                  VARCHAR(255)    NOT NULL,
    `enabled`                   TINYINT(1)      NOT NULL,
    `account_non_expired`       TINYINT(1)      NOT NULL,
    `account_non_locked`        TINYINT(1)      NOT NULL,
    `credentials_non_expired`   TINYINT(1)      NOT NULL,
    PRIMARY KEY (`id`),
    UNIQUE (`username`)
    );

CREATE TABLE IF NOT EXISTS `authorities` (
    `id`                        CHAR(36) NOT NULL DEFAULT (UUID()),
    `user_id`                   CHAR(36) NOT NULL,
    `authority`                 VARCHAR(50) NOT NULL,
    PRIMARY KEY (`id`),
    FOREIGN KEY (`user_id`)     REFERENCES `users` (`id`),
    UNIQUE `ix_auth_username`   (`user_id`, `authority`)
    );
