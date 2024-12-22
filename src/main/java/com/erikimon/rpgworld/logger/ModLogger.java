package com.erikimon.rpgworld.logger;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class ModLogger {
    private static final Logger LOGGER = LogManager.getLogger("RPGWorld");

    public static void showLog(String message) {
        ModLogger.LOGGER.info("[DEBUG-RPGWORLD]{}", message);
    }
}
