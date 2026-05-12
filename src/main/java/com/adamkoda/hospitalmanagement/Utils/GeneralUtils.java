package com.adamkoda.hospitalmanagement.Utils;

import java.io.IOException;

public class GeneralUtils {
    private GeneralUtils() {
        // prevent object creation
    }

    public static void clearConsole() {
        try {
            if (System.getProperty("os.name").contains("Windows")) {
                // Specifically for Windows CMD
                new ProcessBuilder("cmd", "/c", "cls").inheritIO().start().waitFor();
            } else {
                // For Linux/macOS
                new ProcessBuilder("clear").inheritIO().start().waitFor();
            }
        } catch (IOException | InterruptedException ex) {
            ex.printStackTrace();
        }
    }
}
