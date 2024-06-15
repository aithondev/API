package dev.aithon.player;

import dev.aithon.API;
import org.bukkit.OfflinePlayer;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;

public class Player {

    public static @NotNull OfflinePlayer offline(@NotNull UUID uuid) {
        return API.plugin.getServer().getOfflinePlayer(uuid);
    }
}
