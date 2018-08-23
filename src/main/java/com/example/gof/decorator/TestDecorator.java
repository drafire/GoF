package com.example.gof.decorator;

import org.slf4j.Logger;
import org.springframework.stereotype.Component;

public class TestDecorator  {
    private static final Logger logger = JsonLogger.JsonLoggerFactory.getLogger(Component.class);
    public static void main(String[] args) {
        logger.error("哈克深蹲是的呢");
    }
}
