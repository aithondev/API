package dev.aithon.config;

import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigManager {

    public static  <T> T parse(Class <T> o, String path, String fileName) throws IOException {
        File file = new File(fileName);
        if(!file.exists()){
            if(!file.createNewFile()){
                System.out.println("e");
            }
        }
        YamlConfiguration config = YamlConfiguration.loadConfiguration(file);
        return o.cast(config.get(path));
    }
}
