package net.marscraft.shared.files.configs;

import java.util.List;
import java.util.Optional;

/**
 * Interface to implement a Config Manger that can create and Manage a Configuration File
 * @see ConfigValue
 * */
public interface IConfigManager {


    /**
     * Creates the default Configuration File.
     * */
    void create();

    /**
     * Saves the Configuration File
     * */
    void save();
    /**
     * Reloads the Configuration File
     * */
    void reload();

    /**
     * Adds ConfigParameters to the Configuration File
     * @param parameters ConfigParameters that get added
     * */
    void addConfigParameter(List<ConfigParameter> parameters);

    /**
     * Adds a ConfigParameter to the Configuration File
     * @param parameter ConfigParameter that gets added
     * */
    void addConfigParameter(ConfigParameter parameter);

    /**
     * Loads all Values from the Configuration File and returns them as ConfigValue List.
     * @return All ConfigValues from the Configuration File.<p> An Empty List if the Configuration file is Empty.
     * @see ConfigValue
     * */
    List<ConfigValue> getConfigValue();

    /**
     * Gets a ConfigValue with the given path.
     * @return An Optional that contains the ConfigValue if found. <p> An Empty Optional if the requested ConfigValue wasn't found.
     * @see ConfigValue
     * */
    Optional<ConfigValue> getConfigValue(String path);

    /**
     * Sets the Given Values to the Configuration File.
     * @param values ConfigValues that get set.
     * @see ConfigValue
     * */
    void setConfigValue(List<ConfigValue> values);

    /**
     * Sets the Given Value to the Configuration File.
     * @param value ConfigValue that gets set.
     * @see ConfigValue
     * */
    void setConfigValue(ConfigValue value);

    /**
     * Adds a new Default ConfigValue to the Configuration File.
     * @param defaultValues The default ConfigValues that get set.
     * @see ConfigValue
     * */
    void addDefaultConfigValue(List<ConfigValue> defaultValues);

    /**
     * Adds a new Default ConfigValue to the Configuration File.
     * @param defaultValue The default ConfigValue that gets set.
     * @see ConfigValue
     * */
    void addDefaultConfigValue(ConfigValue defaultValue);


}
