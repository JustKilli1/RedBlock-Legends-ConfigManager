package net.marscraft;

import net.marscraft.shared.logging.ILogger;
import net.marscraft.shared.logging.LogCategory;
import net.marscraft.shared.logging.LogLevel;
import net.marscraft.shared.logging.type.ConsoleLogger;
import net.marscraft.shared.logging.type.FileLogger;

public class MainLogger extends ConsoleLogger implements ILogger {

    private String name;

    public MainLogger(String name) {
        super(LogCategory.SYSTEM);
        this.name = name;
    }

    @Override
    public void log(LogLevel logLevel, String message, Exception ex) {
        logToConsole(formatMessage(logLevel, name, message, ex));
    }

    @Override
    public void log(LogLevel logLevel, String message) {
        log(logLevel, message, null);
    }

    @Override
    public void log(LogLevel logLevel, Exception ex) {
        log(logLevel, null, ex);
    }

    @Override
    public String getName() {
        return name;
    }
}
