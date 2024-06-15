package dev.aithon.config;

import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.Plugin;

import java.io.File;

public class ConfigManager {

    private YamlConfiguration yamlConfiguration;
    private File file;


    public ConfigManager(String fileName, Plugin plugin){
        this.file = new File(fileName);
        if(!file.exists()){
            plugin.saveResource(fileName, false);
        }
        this.yamlConfiguration = YamlConfiguration.loadConfiguration(file);
    }

    public <T> T parse(Class <T> o, String path) {
        return o.cast(yamlConfiguration.get(path));
    }
}
