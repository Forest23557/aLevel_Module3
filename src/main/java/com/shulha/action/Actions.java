package com.shulha.action;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public enum Actions {
    GET_STUDENT_NUMBER_FROM_GROUPS("Get student number from groups", new StudentNumberAction()),
    GET_AVERAGE_MARKS_FROM_GROUPS("Get average marks from all groups", new GroupAverageMarksAction()),
    GET_SUBJECTS_WITH_THE_WORST_AND_THE_BEST_RESULTS("Get subjects with the worst and the best results",
            new WorstBestResultAction()),
    GET_GROUP_BY_NAME("Get a group by name", new GroupByNameAction()),
    GET_LECTURER_BY_NAME_OR_SURNAME("Get a lecturer by name or surname", new GetLecturerAction()),
    GET_STUDENTS_WHOSE_MARKS_ARE_HIGHER_THAN("Get students whose average marks are higher than your value",
            new HigherMarksAction()),
    EXIT("Exit from the program", new ExitAction());

    private Logger logger;
    private final String name;
    private final Action action;

    Actions(final String name, final Action action) {
        this.name = name;
        this.action = action;
        this.logger = LoggerFactory.getLogger(action.getClass());
    }

    public String getName() {
        return name;
    }

    public Action getAction() {
        return action;
    }

    public void execute() {
        logger.info("{} method is starting!", name);
        action.execute();
        logger.info("{} method was finished!", name);
    }
}
