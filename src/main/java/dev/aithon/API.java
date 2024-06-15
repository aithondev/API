package dev.aithon;

import org.bukkit.plugin.Plugin;
import org.jetbrains.annotations.NotNull;

public class API {

    public static Plugin plugin;
    private API api;

    public API(Plugin plugin){
        this.plugin = plugin;
        this.api = this;
    }

    public static @NotNull API api(){
        return api();
    }
}
