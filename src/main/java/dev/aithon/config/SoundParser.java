package dev.aithon.config;

import org.bukkit.Sound;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;

public class SoundParser {

    public static Sound parseSound(String path, YamlConfiguration config){
        if(config.getString(path) == null){
            throw new NullPointerException();
        }
        if(!config.contains(path)){
            throw new NullPointerException();
        }
        return Sound.valueOf(config.getString(path));
    }
}
