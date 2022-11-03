package net.foulest.moblimiter.util;

import net.foulest.moblimiter.MobLimiter;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Chunk;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;

import java.util.logging.Level;

public final class MessageUtil {

    public static void messagePlayer(CommandSender sender, String message) {
        sender.sendMessage(colorize(message));
    }

    public static void messageChunk(Chunk chunk, String message) {
        for (Entity entity : chunk.getEntities()) {
            if (entity instanceof Player player) {
                messagePlayer(player, message);
            }
        }
    }

    public static void log(Level level, String message) {
        Bukkit.getLogger().log(level, "[" + MobLimiter.name + "] " + message);
    }

    public static void broadcast(String message) {
        for (Player online : Bukkit.getOnlinePlayers()) {
            messagePlayer(online, message);
        }
    }

    public static String colorize(String message) {
        return ChatColor.translateAlternateColorCodes('&', message);
    }
}
