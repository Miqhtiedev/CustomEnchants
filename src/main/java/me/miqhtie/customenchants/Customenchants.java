package me.miqhtie.customenchants;

import me.miqhtie.customenchants.enchants.CustomEnchant;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public final class Customenchants extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        Bukkit.getPluginManager().registerEvents(this, this);

        if (CustomEnchant.register()) {
            System.out.println("Registering enchantment");
        } else {
            System.out.println("Error registering enchantment");
        }
    }

    @EventHandler
    public void onJoin(PlayerJoinEvent event) {
        ItemStack item = new ItemStack(Material.IRON_CHESTPLATE);
        item.addEnchantment(new CustomEnchant(), 1);
        event.getPlayer().getInventory().addItem(item);
    }
}
