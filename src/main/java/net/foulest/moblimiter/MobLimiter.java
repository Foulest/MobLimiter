package net.foulest.moblimiter;

import lombok.Getter;
import lombok.SneakyThrows;
import net.foulest.moblimiter.cmds.MainCmd;
import net.foulest.moblimiter.listeners.EventListener;
import net.foulest.moblimiter.util.Settings;
import net.foulest.moblimiter.util.command.CommandFramework;
import org.bukkit.Bukkit;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

@Getter
public class MobLimiter extends JavaPlugin {

    public static String name = "MobLimiter";
    public static MobLimiter instance;
    public static boolean loaded = false;
    private CommandFramework framework;

    @Override
    @SneakyThrows
    public void onEnable() {
        instance = this;
        framework = new CommandFramework(this);

        // Creates the default settings config.
        Bukkit.getLogger().info("[" + name + "] - Loading Settings...");
        Settings.setupSettings();
        Settings.loadSettings();

        // Loads the plugin's listeners.
        if (Settings.config.getBoolean("enabled")) {
            Bukkit.getLogger().info("[" + name + "] - Loading Listeners...");
            loadListeners(new EventListener());
        } else {
            Bukkit.getLogger().info("[" + name + "] - Listeners not loaded; plugin is disabled in config...");
        }

        // Loads the plugin's commands.
        Bukkit.getLogger().info("[" + name + "] - Loading Commands...");
        loadCommands(new MainCmd());

        Bukkit.getLogger().info("[" + name + "] Loaded successfully.");
        loaded = true;
    }

    @Override
    public void onDisable() {
        Bukkit.getLogger().info("[" + name + "] Shut down successfully.");
    }

    /**
     * Loads the plugin's listeners.
     *
     * @param listeners Listener to load.
     */
    private void loadListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            Bukkit.getPluginManager().registerEvents(listener, this);
        }
    }

    /**
     * Unloads the plugin's listeners.
     *
     * @param listeners Listener to load.
     */
    private void unloadListeners(Listener... listeners) {
        for (Listener listener : listeners) {
            HandlerList.unregisterAll(listener);
        }
    }

    /**
     * Loads the plugin's commands.
     *
     * @param commands Command to load.
     */
    private void loadCommands(Object... commands) {
        for (Object command : commands) {
            framework.registerCommands(command);
        }
    }
}
