package rune.night.prefix;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class Listeners implements Listener {
    static String PrefixAdmins;
    static String Prefix;
    public Listeners(String onChatPrefixAdmins, String args) {
        PrefixAdmins = onChatPrefixAdmins;
        Prefix= args;
    }

    @EventHandler
    public void onChatPrefixAdmins(AsyncPlayerChatEvent e){
        e.setCancelled(true);
        if(e.getPlayer().isOp()){
            String PrefixAdminsReplaced = PrefixAdmins.replace("%PlayerName%", e.getPlayer().getName());
            Bukkit.broadcastMessage(PrefixAdminsReplaced+ChatColor.WHITE+e.getMessage());
        } else {
            String PrefixReplaced = Prefix.replace("%PlayerName%", e.getPlayer().getName());
            Bukkit.broadcastMessage(PrefixReplaced+ChatColor.WHITE+e.getMessage());
        }
    }

}
