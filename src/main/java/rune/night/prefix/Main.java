package rune.night.prefix;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin {

    private static JavaPlugin plugin;
    private Listeners listeners;

    @Override
    public void onEnable() {
        saveDefaultConfig();
        FileConfiguration config = getConfig();

        plugin = this;
        this.listeners = new Listeners(getConfig().getString("onChatPrefixAdmins"),getConfig().getString("onChatPrefix"));
        Bukkit.getPluginManager().registerEvents(this.listeners, this);
        super.onEnable();
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        super.onDisable();
    }
    public static JavaPlugin getPlugin() {return plugin;}
}
