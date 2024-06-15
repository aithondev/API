package dev.aithon.color;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.minimessage.MiniMessage;
import net.md_5.bungee.api.ChatColor;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Colorize {

    public static Component component(String string){
        return MiniMessage.miniMessage().deserialize(string);
    }

    public static Component color(String text) {
        return component(text);
    }

    @SuppressWarnings("deprecation")
    public static String chatColor(String text) {
        text = text.replaceAll("<black>", ChatColor.BLACK.toString());
        text = text.replaceAll("<dark_blue>", ChatColor.DARK_BLUE.toString());
        text = text.replaceAll("<dark_green>", ChatColor.DARK_GREEN.toString());
        text = text.replaceAll("<dark_aqua>", ChatColor.DARK_AQUA.toString());
        text = text.replaceAll("<dark_light_blue>", ChatColor.DARK_AQUA.toString());
        text = text.replaceAll("<dark_red>", ChatColor.DARK_RED.toString());
        text = text.replaceAll("<dark_purple>", ChatColor.DARK_PURPLE.toString());
        text = text.replaceAll("<dark_pink>", ChatColor.DARK_PURPLE.toString());
        text = text.replaceAll("<gold>", ChatColor.GOLD.toString());
        text = text.replaceAll("<dark_yellow>", ChatColor.GOLD.toString());
        text = text.replaceAll("<gray>", ChatColor.GRAY.toString());
        text = text.replaceAll("<grey>", ChatColor.GRAY.toString());
        text = text.replaceAll("<dark_gray>", ChatColor.DARK_GRAY.toString());
        text = text.replaceAll("<dark_grey>", ChatColor.DARK_GRAY.toString());
        text = text.replaceAll("<blue>", ChatColor.BLUE.toString());
        text = text.replaceAll("<green>", ChatColor.GREEN.toString());
        text = text.replaceAll("<lime>", ChatColor.GREEN.toString());
        text = text.replaceAll("<aqua>", ChatColor.AQUA.toString());
        text = text.replaceAll("<light_blue>", ChatColor.AQUA.toString());
        text = text.replaceAll("<red>", ChatColor.RED.toString());
        text = text.replaceAll("<pink>", ChatColor.LIGHT_PURPLE.toString());
        text = text.replaceAll("<purple>", ChatColor.LIGHT_PURPLE.toString());
        text = text.replaceAll("<light_purple>", ChatColor.LIGHT_PURPLE.toString());
        text = text.replaceAll("<light_pink>", ChatColor.LIGHT_PURPLE.toString());
        text = text.replaceAll("<magenta>", ChatColor.LIGHT_PURPLE.toString());
        text = text.replaceAll("<yellow>", ChatColor.YELLOW.toString());
        text = text.replaceAll("<light_yellow>", ChatColor.YELLOW.toString());
        text = text.replaceAll("<white>", ChatColor.WHITE.toString());
        text = text.replaceAll("<bold>", ChatColor.BOLD.toString());
        text = text.replaceAll("<reset>", ChatColor.RESET.toString());
        text = text.replaceAll("<underline>", ChatColor.UNDERLINE.toString());
        text = text.replaceAll("<italic>", ChatColor.ITALIC.toString());
        text = text.replaceAll("<strikethrough>", ChatColor.STRIKETHROUGH.toString());
        text = text.replaceAll("<strike>", ChatColor.STRIKETHROUGH.toString());
        text = text.replaceAll("<obfuscated>", ChatColor.MAGIC.toString());
        text = text.replaceAll("<magic>", ChatColor.MAGIC.toString());
        text = text.replaceAll("<random>", ChatColor.MAGIC.toString());
        text = text.replaceAll("<newline>", "\n");
        text = text.replaceAll("<nl>", "\n");
        return text;
    }

    public static String translateFromLegacy(String text){
        text = text.replaceAll("<black>", "§0");
        text = text.replaceAll("<dark_blue>", "§1");
        text = text.replaceAll("<dark_green>", "§2");
        text = text.replaceAll("<dark_aqua>", "§3");
        text = text.replaceAll("<dark_light_blue>", "§3");
        text = text.replaceAll("<dark_red>", "§4");
        text = text.replaceAll("<dark_purple>", "§5");
        text = text.replaceAll("<dark_pink>", "§5");
        text = text.replaceAll("<gold>", "§6");
        text = text.replaceAll("<dark_yellow>", "§6");
        text = text.replaceAll("<gray>", "§7");
        text = text.replaceAll("<grey>", "§7");
        text = text.replaceAll("<dark_gray>", "§8");
        text = text.replaceAll("<dark_grey>", "§8");
        text = text.replaceAll("<blue>", "§9");
        text = text.replaceAll("<green>", "§a");
        text = text.replaceAll("<lime>", "§a");
        text = text.replaceAll("<aqua>", "§b");
        text = text.replaceAll("<light_blue>", "§b");
        text = text.replaceAll("<red>", "§c");
        text = text.replaceAll("<pink>", "§d");
        text = text.replaceAll("<purple>", "§d");
        text = text.replaceAll("<light_purple>", "§d");
        text = text.replaceAll("<light_pink>", "§d");
        text = text.replaceAll("<magenta>", "§d");
        text = text.replaceAll("<yellow>", "§e");
        text = text.replaceAll("<light_yellow>", "§e");
        text = text.replaceAll("<white>", "§f");
        text = text.replaceAll("<bold>", "§l");
        text = text.replaceAll("<reset>", "§r");
        text = text.replaceAll("<underline>", "§n");
        text = text.replaceAll("<italic>", "§o");
        text = text.replaceAll("<strikethrough>", "§m");
        text = text.replaceAll("<strike>", "§m");
        text = text.replaceAll("<obfuscated>", "§k");
        text = text.replaceAll("<magic>", "§k");
        text = text.replaceAll("<random>", "§k");
        text = text.replaceAll("<newline>", "\n");
        text = text.replaceAll("<nl>", "\n");
        return text;
    }

    @SuppressWarnings("deprecation")
    public static String translateFromColorCode(String message) {
        Pattern pattern = Pattern.compile("&#([A-Fa-f0-9]{6})");
        Matcher matcher = pattern.matcher(message);
        StringBuffer buffer = new StringBuffer();
        while (matcher.find()) {
            matcher.appendReplacement(buffer, ChatColor.of("#" + matcher.group(1)).toString());
        }
        matcher.appendTail(buffer);
        return org.bukkit.ChatColor.translateAlternateColorCodes('&', buffer.toString());
    }
}
