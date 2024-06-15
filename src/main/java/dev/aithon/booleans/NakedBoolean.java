package dev.aithon.booleans;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.jetbrains.annotations.NotNull;

import javax.annotation.Nullable;

public class NakedBoolean {

    public static boolean isNakedWithElytra(Player player){
        int v = 0;
        @Nullable ItemStack @NotNull [] armor = player.getInventory().getArmorContents();
        for(ItemStack itemStack : armor){
            if(itemStack == null){
                v++;
                continue;
            }
            if(itemStack.getType() == Material.ELYTRA) v++;
        }
        return v == 4;
    }

    public static boolean isNaked(Player player){
        int v = 0;
        @Nullable ItemStack @NotNull [] armor = player.getInventory().getArmorContents();
        for(ItemStack itemStack : armor){
            if(itemStack == null){
                v++;
            }
        }
        return v == 4;
    }
}
