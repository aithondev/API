package dev.aithon.scheduler;

import dev.aithon.API;
import org.bukkit.Bukkit;
import org.bukkit.scheduler.BukkitTask;
import org.jetbrains.annotations.NotNull;

public class Scheduler {

    public static void run(Runnable runnable){
        Bukkit.getScheduler().runTask(API.plugin, runnable);
    }

    public static void runAsync(Runnable runnable){
        Bukkit.getScheduler().runTaskAsynchronously(API.plugin, runnable);
    }

    public static @NotNull BukkitTask wait(Runnable runnable, long delay) {
        return Bukkit.getScheduler().runTaskLater(API.plugin, runnable, delay);
    }

    public static BukkitTask async(Runnable runnable, long delay, long p){
        return Bukkit.getScheduler().runTaskTimerAsynchronously(API.plugin, runnable,delay,p);
    }

    public static BukkitTask sync(Runnable runnable, long delay, long p){
        return Bukkit.getScheduler().runTaskTimer(API.plugin, runnable,delay,p);
    }
}
