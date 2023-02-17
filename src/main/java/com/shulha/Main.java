package com.shulha;

import com.shulha.config.FlywayUtil;
import org.flywaydb.core.Flyway;

public class Main {
    public static void main(String[] args) {
        final Flyway flyway = FlywayUtil.getFlyway();
        flyway.migrate();
    }
}
