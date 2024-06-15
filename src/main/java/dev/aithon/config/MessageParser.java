package dev.aithon.config;

import dev.aithon.color.Colorize;
import net.kyori.adventure.text.Component;
import org.bukkit.configuration.file.YamlConfiguration;

public class MessageParser {

    public static Component parseWithColorize(String path, YamlConfiguration config){
        String s = config.getString(path);
        if(!config.contains(path)){
            return Colorize.color("<red>" + path);
        }
        if(s == null){
            return Colorize.color("<red>" + path);
        }
        return Colorize.color(s);
    }

    public static String parseLegacy(String path, YamlConfiguration config){
        String s = config.getString(path);
        if(!config.contains(path)){
            return Colorize.translateFromLegacy("<red>" + path);
        }
        if(s == null){
            return Colorize.translateFromLegacy("<red>" + path);
        }
        return Colorize.translateFromLegacy(s);
    }

    public static String parseInHex(String path, YamlConfiguration config){
        String s = config.getString(path);
        if(!config.contains(path)){
            return Colorize.translateFromColorCode("#FF1A14" + path);
        }
        if(s == null){
            return Colorize.translateFromColorCode("#FF1A14" + path);
        }
        return Colorize.translateFromColorCode(s);
    }

    public static Component parseWithBoolean(String path, YamlConfiguration config){
        if(config.getBoolean(path + ".enabled")){
            return Colorize.color(config.getString(path + ".message"));
        }
        return null;
    }
}
