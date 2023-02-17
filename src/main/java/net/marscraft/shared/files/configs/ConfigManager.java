package net.marscraft.shared.files.configs;

import net.marscraft.shared.logging.ILogger;
import net.marscraft.shared.logging.LogLevel;
import org.simpleyaml.configuration.MemorySection;
import org.simpleyaml.configuration.file.YamlFile;

import java.io.IOException;
import java.util.*;

import static net.marscraft.shared.logging.LogLevel.*;

public class ConfigManager implements IConfigManager {

    private ILogger logger;
    private YamlFile config;

    public ConfigManager(ILogger logger, String path) {
        this.logger = logger;
        config = new YamlFile(path);
        config.options().copyDefaults(true);
    }

    @Override
    public void create() {
        try {
            if (!config.exists()) {
                config.createNewFile();
                logger.log(INFO, "New Configuration File has been Created at: " + config.getFilePath());
            } else {
                logger.log(INFO, "Loading " + config.getConfigurationFile().getName() + " configuration File...");
                config.load();
                //With Comments
                //Write Auto Comments over Default Values. All Parameters with Explanation and their name as Comment if present parameters
                //config.loadWithComments();
                logger.log(INFO, config.getConfigurationFile().getName() + " configuration File loaded");

            }
        } catch (IOException ex) {
            logger.log(ERROR, "[ErrorCode] Could not create Default Configuration File with Path: " + config.getFilePath(), ex);
        }
    }

    @Override
    public void save() {
        try {
            config.save();
        } catch (IOException ex) {
            logger.log(WARN, "[ErrorCode] Could not save Configuration File with Path: " + config.getFilePath(), ex);
        }
    }

    @Override
    public void reload() {
        //With Comments
        //Write Auto Comments over Default Values. All Parameters with Explanation and their name as Comment if present parameters
        //config.loadWithComments();
        try {
            config.load();
        } catch (IOException ex) {
            logger.log(WARN, "[ErrorCode] Could not reload Configuration File with Path: " + config.getFilePath(), ex);
        }
    }

    @Override
    public void addConfigParameter(List<ConfigParameter> parameters) {

    }

    @Override
    public void addConfigParameter(ConfigParameter parameter) {

    }

    @Override
    public List<ConfigValue> getConfigValue() {
        List<ConfigValue> configValues = new ArrayList<>();
        Map<String, Object> values = config.getValues(true);
        values.forEach((path, value) -> configValues.add(new ConfigValue(path, (String) value)));
        return configValues;
    }

    @Override
    public Optional<ConfigValue> getConfigValue(String path) {
        return Optional.ofNullable(new ConfigValue(path, config.getString(path)));
    }

    @Override
    public void setConfigValue(List<ConfigValue> values) {
        values.forEach(value -> config.set(value.getPath(), value.getValue()));
    }

    @Override
    public void setConfigValue(ConfigValue value) {
        setConfigValue(Arrays.asList(value));
    }

    @Override
    public void addDefaultConfigValue(List<ConfigValue> defaultValues) {
        defaultValues.forEach(value -> config.addDefault(value.getPath(), value.getValue()));
    }

    @Override
    public void addDefaultConfigValue(ConfigValue defaultValue) {
        addDefaultConfigValue(Arrays.asList(defaultValue));
    }
}
