package dev.aithon.item;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import dev.aithon.API;
import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.material.MaterialData;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

public class ItemBuilder implements Listener {

    private static final Plugin plugin = API.plugin;
    private static boolean listener = false;
    private static final HashMap<String, PotionEffect> effects = new HashMap<String, PotionEffect>();

    private final ItemStack is;

    public ItemBuilder(final Material mat) {
        is = new ItemStack(mat);
    }

    public ItemBuilder(final ItemStack is) {
        this.is = is;
    }

    public ItemBuilder amount(final int amount) {
        is.setAmount(amount);
        return this;
    }

    public ItemBuilder setName(final String name) {
        final ItemMeta meta = is.getItemMeta();
        meta.setDisplayName(name);
        is.setItemMeta(meta);
        return this;
    }

    public ItemBuilder lore(final String name) {
        final ItemMeta meta = is.getItemMeta();
        List<String> lore = meta.getLore();
        if (lore == null) {
            lore = new ArrayList<String>();
        }
        lore.add(name);
        meta.setLore(lore);
        is.setItemMeta(meta);
        return this;
    }

    public ItemBuilder setDurability(final int durability) {
        is.setDurability((short) durability);
        return this;
    }

    @SuppressWarnings("deprecation")
    public ItemBuilder data(final int data) {
        is.setData(new MaterialData(is.getType(), (byte) data));
        return this;
    }

    public ItemBuilder addEnchantment(final Enchantment enchantment, final int level) {
        is.addUnsafeEnchantment(enchantment, level);
        return this;
    }

    public ItemBuilder addEnchantment(final Enchantment enchantment) {
        is.addUnsafeEnchantment(enchantment, 1);
        return this;
    }

    public ItemBuilder type(final Material material) {
        is.setType(material);
        return this;
    }

    public ItemBuilder clearEnchantments() {
        for (final Enchantment e : is.getEnchantments().keySet()) {
            is.removeEnchantment(e);
        }
        return this;
    }

    public ItemBuilder addColor(Color color) {
        if (is.getType() == Material.LEATHER_BOOTS || is.getType() == Material.LEATHER_CHESTPLATE || is.getType() == Material.LEATHER_HELMET
                || is.getType() == Material.LEATHER_LEGGINGS) {
            LeatherArmorMeta meta = (LeatherArmorMeta) is.getItemMeta();
            meta.setColor(color);
            is.setItemMeta(meta);
            return this;
        } else {
            throw new IllegalArgumentException("color() only applicable for leather armor!");
        }
    }

    public ItemBuilder addEffect(PotionEffectType type, int duration, int amplifier, boolean ambient) {
        addEffect(new PotionEffect(type, duration, amplifier, ambient));
        return this;
    }

    public ItemBuilder addEffect(PotionEffect effect) {
        if (!listener) {
            Bukkit.getPluginManager().registerEvents(this, plugin);
            listener = true;
        }
        String name = is.getItemMeta().getDisplayName();
        while (effects.containsKey(name)) {
            name = name + "#";
        }
        effects.put(name, effect);
        return this;
    }

    public ItemBuilder addEffect(PotionEffectType type, int duration, int amplifier) {
        addEffect(new PotionEffect(type, duration == -1 ? 1000000 : duration, amplifier));
        return this;
    }

    public ItemBuilder addEffect(PotionEffectType type, int duration) {
        addEffect(new PotionEffect(type, duration == -1 ? 1000000 : duration, 1));
        return this;
    }

    public ItemStack build() {
        return is;
    }
}
