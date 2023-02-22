package com.shulha.util;

import org.apache.commons.lang3.StringUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class UserInput {
    private static BufferedReader reader;

    public static int menu(final String[] names) {
        int userChoice = -1;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(System.in));

            do {
                System.out.println("Choose your action: ");

                for (int i = 0; i < names.length; i++) {
                    System.out.println(i + ". " + names[i]);
                }

                final String answer = reader.readLine();

                if (!StringUtils.isNumeric(answer)) {
                    System.out.println("You wrote a wrong command! Enter an existing command from the screen, please.");
                    continue;
                }

                userChoice = Integer.parseInt(answer);

                if (userChoice < 0 || userChoice >= names.length) {
                    System.out.println("You wrote a wrong command! Enter an existing command from the screen, please.");
                    continue;
                }
                break;
            } while (true);

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return userChoice;
    }

    public static String getNonNullString(final String option, final String error) {
        String line = null;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(System.in));

            do {
                System.out.println(option);

                final String answer = reader.readLine();

                if (StringUtils.isBlank(answer)) {
                    System.out.println(error);
                    continue;
                }

                line = answer;
                break;
            } while (true);

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return line;
    }

    public static int getLowerBoundMark(final String option, final String error) {
        int lowerBoundMark = -1;

        try {
            reader = new BufferedReader(
                    new InputStreamReader(System.in));

            do {
                System.out.println(option);

                final String answer = reader.readLine();

                if (!StringUtils.isNumeric(answer)) {
                    System.out.println(error);
                    continue;
                }

                lowerBoundMark = Integer.parseInt(answer);

                if (lowerBoundMark < 0 || lowerBoundMark > 11) {
                    System.out.println(error);
                    continue;
                }
                break;
            } while (true);

            reader.close();

        } catch (IOException ex) {
            ex.printStackTrace();
        }

        return lowerBoundMark;
    }
}
