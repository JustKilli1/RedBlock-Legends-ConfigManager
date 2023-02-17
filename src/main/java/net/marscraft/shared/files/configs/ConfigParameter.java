package net.marscraft.shared.files.configs;


public class ConfigParameter {

    private static final char idChar = '#';
    private String name, paramName, value, comment;

    public ConfigParameter(String name, String value, String comment) {
        this.name = name;
        this.value = value;
        paramName = idChar + name + idChar;
        this.comment = comment;
    }

    public ConfigParameter(String name, String comment) {
        this(name, new String(), comment);
    }

    public String getName() {
        return name;
    }

    public String getParamName() {
        return paramName;
    }

    public String getComment() {
        return comment;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
