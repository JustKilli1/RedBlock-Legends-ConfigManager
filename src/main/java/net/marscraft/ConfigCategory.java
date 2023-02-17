package net.marscraft;

public enum ConfigCategory {

    SERVER("Server", "server-"),
    PLAYERMESSAGES("Messages/PlayerMessages", "pm-"),
    GUIMESSAGES("Messages/GUIMessages", "gm-"),
    NPCMESSAGES("Messages/NPCMessages", "nm-")
    ;

    private String folderName, filePrefix;

    ConfigCategory(String folderName, String filePrefix) {
        this.folderName = folderName;
        this.filePrefix = filePrefix;
    }

    public String getFolderName() {
        return folderName;
    }

    public String getFilePrefix() {
        return filePrefix;
    }
}
