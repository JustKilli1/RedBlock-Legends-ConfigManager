package net.marscraft.shared.logging.type;

import net.marscraft.shared.files.FileHandler;
import net.marscraft.shared.logging.LogCategory;
import net.marscraft.shared.logging.LogLevel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

public class ConsoleLogger {
    protected LogCategory logCategory;

    public ConsoleLogger(LogCategory logCategory) {
        this.logCategory = logCategory;

    }

    /**
     * Writes A LogMessage to a File
     * @param message The Message that gets written to the File
     * @see FileHandler
     * */
    public void logToConsole(List<String> message) {
        message.forEach(System.out::println);
    }

    /**
     * Writes A LogMessage to a File
     * @param message The Message that gets written to the File
     * */
    public void logToConsole(String message) {
        logToConsole(Arrays.asList(message));
    }

    /**
     * Utils Method for Logger to get the StackTrace of an Exception as String
     * @param ex Exception that gets turned into a String
     * @return StackTrace from Exception as String
     * */
    protected String getStackTraceAsStr(Exception ex) {
        if(ex == null) return null;
        StringWriter strWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(strWriter);
        ex.printStackTrace(printWriter);
        return strWriter.toString();
    }

    /**
     * Utils Method for Logger to Format a LogMessage
     * @param logLevel LogLevel
     * @param loggerName Name of the calling logger
     * @param message Custom Message
     * @param ex occurring Exception
     * @return Formatted LogMessage
     * @see LogLevel
     * */
    protected String formatMessage(LogLevel logLevel, String loggerName, String message, Exception ex) {
        String exceptionMSG = ex == null ? "" : "\nException: " + getStackTraceAsStr(ex);
        String messageMSG = message == null ? "" : "\nMessage: " + message;
        return "Level: " + logLevel.getName() + "\n" +
                "Logger Name: " + loggerName +
                messageMSG +
                exceptionMSG;
    }

}
