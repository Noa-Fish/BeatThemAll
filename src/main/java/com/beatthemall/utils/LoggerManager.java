package com.beatthemall.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;
import java.io.IOException;

public class LoggerManager {

    private static final LoggerManager instance = new LoggerManager();

    private LoggerManager() {
        // Private constructor for Singleton
    }

    public static LoggerManager getInstance() {
        return instance;
    }

    public Logger getLogger(String name) {
        Logger logger = Logger.getLogger(name);

        if (logger.getHandlers().length == 0) {
            // Console handler
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getMessage() + System.lineSeparator();
                }
            });

            // File handler
            Handler fileHandler = null;
            try {
                fileHandler = new FileHandler("game_log.log", true);  // true to append to the file
                fileHandler.setFormatter(new SimpleFormatter());
            } catch (IOException e) {
                e.printStackTrace();
            }

            // Set logger configurations
            logger.setUseParentHandlers(false);
            logger.addHandler(consoleHandler);
            if (fileHandler != null) {
                logger.addHandler(fileHandler);
            }
            logger.setLevel(Level.INFO);
        }

        return logger;
    }
}