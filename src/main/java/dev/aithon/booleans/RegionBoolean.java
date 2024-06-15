package dev.aithon.booleans;

import org.bukkit.Location;
import org.bukkit.entity.Player;

public class RegionBoolean {

    public static boolean isInRegion(Player player, int minY, int minX, int maxX, int minZ, int maxZ, int maxY) {
        Location loc = player.getLocation();
        return loc.getBlockX() >= minX && loc.getBlockX() <= maxX && loc.getBlockZ() >= minZ && loc.getBlockZ() <= maxZ && loc.getBlockY() <= maxY && loc.getBlockY() >= minY;
    }
}
