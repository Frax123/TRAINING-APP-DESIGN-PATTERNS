package Loggers;


import java.util.logging.Logger;

public class MyLogger {
    private final Logger logger1= Logger.getLogger(this.getClass().getSimpleName());
    public static void logStatements(Logger logger, String message) {
        logger.info(message);
    }
}