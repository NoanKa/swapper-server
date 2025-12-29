package com.noanka.swapper.configuration.logger;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LoggerConfig {

    private static final Logger log = LoggerFactory.getLogger("BUSINESS_LOG");

    public void warn(String message, Object... args) {
        log.warn(message, args);
    }

    public void info(String message, Object... args) {
        log.info(message, args);
    }

    public void error(String message, Object... args) {
        log.error(message, args);
    }
}
