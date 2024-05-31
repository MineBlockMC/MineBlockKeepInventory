package org.mineblock.keepinventory;

import org.bukkit.GameRule;
import org.bukkit.World;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.world.WorldLoadEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class Main extends JavaPlugin implements Listener {
    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    @EventHandler(priority = EventPriority.LOWEST)
    @SuppressWarnings("deprecation")
    public void onWorldLoad(WorldLoadEvent event) {
        World world = event.getWorld();
        try{
            world.setGameRule(GameRule.KEEP_INVENTORY, true);
        } catch (NoClassDefFoundError|NoSuchMethodError e){
            world.setGameRuleValue("keepInventory", "true");
        }
    }
}
