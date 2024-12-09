package com.beatthemall.utils;

import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

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
            Handler consoleHandler = new ConsoleHandler();
            consoleHandler.setFormatter(new SimpleFormatter() {
                @Override
                public String format(LogRecord record) {
                    return record.getMessage() + System.lineSeparator();
                }
            });

            logger.setUseParentHandlers(false);
            logger.addHandler(consoleHandler);
            logger.setLevel(Level.INFO);
        }
        return logger;
    }
}