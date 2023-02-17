package net.marscraft.shared.files.configs;

/**
 * A Storage Object for a ConfigValue. Contains the ConfigPath and its value.
 * */
public class ConfigValue {

    private String path, value;

    public ConfigValue(String path, String value) {
        this.path = path;
        this.value = value;
    }

    public String getPath() {
        return path;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
