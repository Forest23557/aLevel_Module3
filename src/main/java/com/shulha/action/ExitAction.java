package com.shulha.action;

import com.shulha.util.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExitAction implements Action {
    private static final Logger LOGGER = LoggerFactory.getLogger(ExitAction.class);

    @Override
    public void execute() {
        UserInput.closeReader();
        System.out.println("Goodbye!");
        LOGGER.info("The program has been successfully finished!");
        System.exit(0);
    }
}
