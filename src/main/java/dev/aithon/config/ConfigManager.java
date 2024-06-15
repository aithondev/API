package dev.aithon.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {
    private final File file;
    private final YamlConfiguration yamlConfiguration;

    public ConfigManager(String fileName, Plugin plugin){
        this.file = new File(fileName);
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
        if(!this.file.exists()){
            plugin.saveResource(fileName, false);
        }
    }

    public <T> T parse(Class <T> o, String path) {
        return o.cast(yamlConfiguration.get(path));
    }

    public static void createFile(String fileName, Plugin plugin) {
        File file = new File(fileName);
        if (!file.exists()) {
            plugin.saveResource(fileName, false);
        }
    }
}
