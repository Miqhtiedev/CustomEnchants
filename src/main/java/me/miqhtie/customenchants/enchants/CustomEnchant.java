package me.miqhtie.customenchants.enchants;

import org.bukkit.enchantments.Enchantment;
import org.bukkit.enchantments.EnchantmentTarget;
import org.bukkit.inventory.ItemStack;

import java.lang.reflect.Field;

public class CustomEnchant extends Enchantment {
    public CustomEnchant() {
        super(101);
    }

    @Override
    public String getName() {
        return "Test";
    }

    @Override
    public int getMaxLevel() {
        return 1;
    }

    @Override
    public int getStartLevel() {
        return 1;
    }

    @Override
    public EnchantmentTarget getItemTarget() {
        return EnchantmentTarget.ARMOR;
    }

    @Override
    public boolean conflictsWith(Enchantment other) {
        return false;
    }

    @Override
    public boolean canEnchantItem(ItemStack item) {
        return true;
    }

    public static boolean register() {
        boolean registered = true;

        try {
            Field field = Enchantment.class.getDeclaredField("acceptingNew");
            field.setAccessible(true);
            field.set(null, true);

            Enchantment.registerEnchantment(new CustomEnchant());
        }
        catch (IllegalAccessException | NoSuchFieldException e) {
            registered = false;
            e.printStackTrace();
        }

        return registered;
    }
}
