package dev.aithon.command;

import dev.aithon.API;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.PluginCommand;
import org.bukkit.command.SimpleCommandMap;
import org.bukkit.command.TabCompleter;
import org.bukkit.plugin.java.JavaPlugin;

import java.lang.reflect.Field;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class CommandBuilder {

    private final JavaPlugin plugin;
    private final String name;
    private String description = "";
    private String usageMessage = "";
    private List<String> aliases = Collections.emptyList();
    private BiConsumer<CommandSender, String[]> executor;
    private BiFunction<CommandSender, String[], List<String>> tabCompleter;

    private CommandBuilder(String name) {
        this.plugin = (JavaPlugin) API.plugin;
        this.name = name;
    }

    public static CommandBuilder cmd(String name) {
        return new CommandBuilder(name);
    }

    public CommandBuilder description(String description) {
        this.description = description;
        return this;
    }

    public CommandBuilder usage(String usageMessage) {
        this.usageMessage = usageMessage;
        return this;
    }

    public CommandBuilder aliases(List<String> aliases) {
        this.aliases = aliases;
        return this;
    }

    public CommandBuilder executes(BiConsumer<CommandSender, String[]> executor) {
        this.executor = executor;
        return this;
    }

    public CommandBuilder completes(BiFunction<CommandSender, String[], List<String>> tabCompleter) {
        this.tabCompleter = tabCompleter;
        return this;
    }

    public void register() {
        try {
            SimpleCommandMap commandMap = getCommandMap();

            Command command = new Command(name, description, usageMessage, aliases) {
                @Override
                public boolean execute(CommandSender sender, String label, String[] args) {
                    if (executor != null) {
                        executor.accept(sender, args);
                        return true;
                    }
                    return false;
                }

                @Override
                public List<String> tabComplete(CommandSender sender, String alias, String[] args) {
                    if (tabCompleter != null) {
                        return tabCompleter.apply(sender, args);
                    }
                    return Collections.emptyList();
                }
            };

            commandMap.register(plugin.getDescription().getName(), command);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SimpleCommandMap getCommandMap() throws ReflectiveOperationException {
        Field commandMapField = Bukkit.getServer().getClass().getDeclaredField("commandMap");
        commandMapField.setAccessible(true);
        return (SimpleCommandMap) commandMapField.get(Bukkit.getServer());
    }
}
