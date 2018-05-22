/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.pronoia.junit.sftp.listener;

import java.util.LinkedHashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.event.Level;

public class EventLoggingListenerSupport {
    static final Map<String, Level> STRING_LEVEL_MAP;
    static final Map<Integer, Level> INTEGER_LEVEL_MAP;

    static {
        STRING_LEVEL_MAP = new LinkedHashMap<>();

        STRING_LEVEL_MAP.put("ERROR", Level.ERROR);
        STRING_LEVEL_MAP.put("ERR", Level.ERROR);
        STRING_LEVEL_MAP.put("Error", Level.ERROR);
        STRING_LEVEL_MAP.put("error", Level.ERROR);
        STRING_LEVEL_MAP.put("Err", Level.ERROR);
        STRING_LEVEL_MAP.put("err", Level.ERROR);

        STRING_LEVEL_MAP.put("WARNING", Level.WARN);
        STRING_LEVEL_MAP.put("WARN", Level.WARN);
        STRING_LEVEL_MAP.put("Warning", Level.WARN);
        STRING_LEVEL_MAP.put("Warn", Level.WARN);
        STRING_LEVEL_MAP.put("warning", Level.WARN);
        STRING_LEVEL_MAP.put("warn", Level.WARN);

        STRING_LEVEL_MAP.put("INFORMATIONAL", Level.INFO);
        STRING_LEVEL_MAP.put("INFORMATION", Level.INFO);
        STRING_LEVEL_MAP.put("INFO", Level.INFO);
        STRING_LEVEL_MAP.put("Informational", Level.INFO);
        STRING_LEVEL_MAP.put("Information", Level.INFO);
        STRING_LEVEL_MAP.put("Info", Level.INFO);
        STRING_LEVEL_MAP.put("informational", Level.INFO);
        STRING_LEVEL_MAP.put("information", Level.INFO);
        STRING_LEVEL_MAP.put("info", Level.INFO);

        STRING_LEVEL_MAP.put("DEBUGGING", Level.DEBUG);
        STRING_LEVEL_MAP.put("DEBUG", Level.DEBUG);
        STRING_LEVEL_MAP.put("DBG", Level.DEBUG);
        STRING_LEVEL_MAP.put("Debugging", Level.DEBUG);
        STRING_LEVEL_MAP.put("Debug", Level.DEBUG);
        STRING_LEVEL_MAP.put("debugging", Level.DEBUG);
        STRING_LEVEL_MAP.put("debug", Level.DEBUG);

        STRING_LEVEL_MAP.put("TRACE", Level.TRACE);
        STRING_LEVEL_MAP.put("TRC", Level.TRACE);
        STRING_LEVEL_MAP.put("trace", Level.TRACE);

        INTEGER_LEVEL_MAP = new LinkedHashMap<>();
        INTEGER_LEVEL_MAP.put(Level.ERROR.toInt(), Level.ERROR);
        INTEGER_LEVEL_MAP.put(Level.WARN.toInt(), Level.WARN);
        INTEGER_LEVEL_MAP.put(Level.INFO.toInt(), Level.INFO);
        INTEGER_LEVEL_MAP.put(Level.DEBUG.toInt(), Level.DEBUG);
        INTEGER_LEVEL_MAP.put(Level.TRACE.toInt(), Level.TRACE);
    }

    protected Level defaultLevel;

    protected Logger log = LoggerFactory.getLogger(this.getClass());

    public EventLoggingListenerSupport() {
        this.defaultLevel = Level.INFO;
    }

    public EventLoggingListenerSupport(int level) {
        this(toLevel(level));
    }

    public EventLoggingListenerSupport(String level) {
        this(toLevel(level));
    }

    public EventLoggingListenerSupport(Level level) {
        this.defaultLevel = level;
    }

    /**
     * Determing the logging Level from the supplied int.
     *
     * @param level the logging level as an int
     *
     * @return the logging Level for the supplied int
     *
     * @throws IllegalArgumentException if the Level cannot be determined from supplied int
     */
    protected static Level toLevel(int level) {
        if (INTEGER_LEVEL_MAP.containsKey(level)) {
            return INTEGER_LEVEL_MAP.get(level);
        }

        throw new IllegalArgumentException(String.format("Supplied int '%s' is not in the list of recognized values: %s", level, INTEGER_LEVEL_MAP.keySet()));
    }

    /**
     * Determing the logging Level from the supplied String.
     *
     * @param level the logging level as a String
     *
     * @return the logging Level for the supplied String
     *
     * @throws IllegalArgumentException if the Level cannot be determined from supplied String
     */
    protected static Level toLevel(String level) {
        if (level != null && STRING_LEVEL_MAP.containsKey(level)) {
            return STRING_LEVEL_MAP.get(level);
        }

        throw new IllegalArgumentException(String.format("Supplied String '%s' is not in the list of recognized values: %s", level, STRING_LEVEL_MAP.keySet()));
    }

    public Level getDefaultLevel() {
        return defaultLevel;
    }

    public void setDefaultLevel(String defaultLevel) {
        this.defaultLevel = toLevel(defaultLevel);
    }

    public void setDefaultLevel(Level defaultLevel) {
        this.defaultLevel = defaultLevel;
    }

    public void setDefaultLevel(int defaultLevel) {
        this.defaultLevel = toLevel(defaultLevel);
    }

    /**
     * Log the event at the specified Level.  If the Level is null, silently ignore the call.
     *
     * @param level     the logging Level, or null to skip logging the event
     * @param format    the log message format
     * @param arguments the log message arguments
     *
     * @throws IllegalArgumentException if the supplied Level is unknown (i.e. a custom logging level)
     */
    protected void doLog(Level level, String format, Object... arguments) {
        switch (level != null ? level : defaultLevel) {
            case ERROR:
                log.error(format, arguments);
                break;
            case WARN:
                log.warn(format, arguments);
                break;
            case INFO:
                log.info(format, arguments);
                break;
            case DEBUG:
                log.debug(format, arguments);
                break;
            case TRACE:
                log.trace(format, arguments);
                break;
        }
    }

    /**
     * Log the event at the specified level
     *
     * @param level     the logging level as an int
     * @param format    the log message format
     * @param arguments the log message arguments
     *
     * @throws IllegalArgumentException if the Level cannot be determined from supplied int
     */
    protected void doLog(int level, String format, Object... arguments) {
        doLog(toLevel(level), format, arguments);
    }

    /**
     * Log the event at the specified Level.  If the level is null or empty, silently ignore the call.
     *
     * @param level     the logging level as a String, or null/empty to skip logging the event
     * @param format    the log message format
     * @param arguments the log message arguments
     *
     * @throws IllegalArgumentException if the Level cannot be determined from supplied String
     */
    protected void doLog(String level, String format, Object... arguments) {
        if (level != null && !level.isEmpty()) {
            doLog(toLevel(level), format, arguments);
        }
    }
}
