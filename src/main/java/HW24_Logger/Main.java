package HW24_Logger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {
    private static final Logger loggerWarn = LoggerFactory.getLogger("logger.warn");
    private static final Logger loggerError = LoggerFactory.getLogger("logger.error");

    private static final Logger loggerInfo = LoggerFactory.getLogger("logger.info");

    public static void main(String[] args) {
        loggerWarn.warn("warn");
        loggerError.error("error");

        loggerInfo.info("info");
    }
}
