package com.example.gof.decorator;

import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsonLogger extends DecoratorLogger {
    public JsonLogger(Logger logger) {
        super(logger);
    }

    @Override
    public void error(String s) {
        JSONObject result = composeBasicJsonResult();
        try {
            result.put("MESSAGE", s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        logger.error(result.toString());
    }

    @Override
    public void info(String s) {
        JSONObject result = composeBasicJsonResult();
        try {
            result.put("MESSAGE", s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        logger.info(result.toString());
    }

    public void error(Exception e) {

        JSONObject result = composeBasicJsonResult();
        try {
            result.put("EXCEPTION", e.getClass().getName());
            String exceptionStackTrace = e.getStackTrace().toString();
            result.put("STACKTRACE", exceptionStackTrace);
        } catch (JSONException e1) {
            e1.printStackTrace();
        }
        logger.error(result.toString());
    }

    public static class JsonLoggerFactory {

        @SuppressWarnings("rawtypes")
        public static JsonLogger getLogger(Class clazz) {

            Logger logger = LoggerFactory.getLogger(clazz);
            return new JsonLogger(logger);
        }
    }

    private JSONObject composeBasicJsonResult() {//拼装了一些运行时信息
        return null;
    }
}
