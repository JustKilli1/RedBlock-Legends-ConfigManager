package net.marscraft.shared.logging.type;

import net.marscraft.shared.files.FileHandler;
import net.marscraft.shared.logging.LogCategory;
import net.marscraft.shared.logging.LogLevel;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Arrays;
import java.util.List;

/**
 * Class that provides default Methods to Write Logs to a File
 * */
public class FileLogger {

    //FileHandler that Manages the LogFile
    private FileHandler fileHandler;
    protected LogCategory logCategory;

    public FileLogger(LogCategory logCategory, String logFileName) {
        this.logCategory = logCategory;
        fileHandler = new FileHandler("Logs/" + logCategory.getFolderName() + "/" + logFileName);

    }

    /**
     * Writes A LogMessage to a File
     * @param message The Message that gets written to the File
     * @see FileHandler
     * */
    public void logToFile(List<String> message) {
        try {
            fileHandler.write(message, fileHandler.fileExists());
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Writes A LogMessage to a File
     * @param message The Message that gets written to the File
     * */
    public void logToFile(String message) {
        logToFile(Arrays.asList(message));
    }

}
