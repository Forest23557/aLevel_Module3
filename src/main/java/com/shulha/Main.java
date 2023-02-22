package com.shulha;

import com.shulha.action.Actions;
import com.shulha.builder.SubjectBuilder;
import com.shulha.builder.SubjectBuilderInterface;
import com.shulha.config.FlywayUtil;
import com.shulha.enums.Groups;
import com.shulha.enums.Subjects;
import com.shulha.model.Student;
import com.shulha.model.Subject;
import com.shulha.service.UniversityService;
import com.shulha.util.UserInput;
import org.flywaydb.core.Flyway;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.UUID;
import java.util.stream.Collectors;

public class Main {
    private static final Logger LOGGER = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        LOGGER.info("The program is starting...");
        LOGGER.info("{} is starting...", FlywayUtil.class.getName());
        final Flyway flyway = FlywayUtil.getFlyway();
        LOGGER.info("Migration is starting...");
        flyway.migrate();
        LOGGER.info("Migration was successfully completed!");

        final Actions[] values = Actions.values();
        String[] names = Arrays.stream(values)
                .map(value -> value.getName())
                .collect(Collectors.toCollection(LinkedList::new))
                .toArray(new String[0]);

        while (true) {
            final int userChoice = UserInput.menu(names);
            values[userChoice].execute();
        }
    }
}
