package com.shulha;

import com.shulha.config.FlywayUtil;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("The program is starting...");
        LOGGER.info("{} is starting...", FlywayUtil.class.getName());
        final Flyway flyway = FlywayUtil.getFlyway();
        LOGGER.info("Migration is starting...");
        flyway.migrate();
        LOGGER.info("Migration was successfully completed!");

    }
}
