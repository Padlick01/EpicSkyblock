package com.peaches.epicskyblock.gui;

import com.peaches.epicskyblock.EpicSkyblock;
import com.peaches.epicskyblock.Island;
import com.peaches.epicskyblock.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class BoosterGUI {

    public Inventory inventory;
    public int islandID;

    public ItemStack spawner;
    public ItemStack farming;
    public ItemStack exp;
    public ItemStack flight;

    public int scheduler;

    public BoosterGUI(Island island) {
        this.inventory = Bukkit.createInventory(null, 27, Utils.color(EpicSkyblock.getConfiguration().BoosterGUITitle));
        islandID = island.getId();
        scheduler = Bukkit.getScheduler().scheduleAsyncRepeatingTask(EpicSkyblock.getInstance(), this::addContent, 0, 10);
    }

    public void addContent() {
        Island island = EpicSkyblock.getIslandManager().islands.get(islandID);
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, Utils.makeItem(Material.STAINED_GLASS_PANE, 1, 7, " "));
        }
        this.spawner = Utils.makeItem(Material.MOB_SPAWNER, 1, 0, "&b&lErhöhte Mobs", Utils.color(new ArrayList<>(Arrays.asList("&7Sind Spawner zu langsam?? Kauf diesen", "&7Booster und erhöhe Spawnrate um x2.", "", "&b&lInformation:", "&b&l * &7Verbleibende Zeit: &b" + island.getSpawnerBooster() + "s", "&b&l * &7Booster Kosten: &b" + EpicSkyblock.getConfiguration().spawnerBoosterCost + " Inselkristalle", "", "&b&l[!] &bRechtsklick zum kaufen."))));
        this.farming = Utils.makeItem(Material.WHEAT, 1, 0, "&b&lErhöhte Ernten", Utils.color(new ArrayList<>(Arrays.asList("&7Wachsen deine Pflanzen zu langsam? Kaufe diesen", "&7Booster und erhöhe die Wachstumsrate um x2.", "", "&b&lInformation:", "&b&l * &7Verbleibende Zeit: &b" + island.getFarmingBooster() + "s", "&b&l * &7Booster Kosten: &b" + EpicSkyblock.getConfiguration().farmingBoosterCost + " Inselkristalle", "", "&b&l[!] &bRechtsklick zum kaufen."))));
        this.exp = Utils.makeItem(Material.EXP_BOTTLE, 1, 0, "&b&lErhöhte Erfahrungspunkte", Utils.color(new ArrayList<>(Arrays.asList("&7Dauert's zu lange, XP zu bekommen? Kaufe diesen", "&7Booster und erhöhe XP Rate um x2.", "", "&b&lInformation:", "&b&l * &7Verbleibende Zeit: &b" + island.getExpBooster() + "s", "&b&l * &7Booster Kosten: &b" + EpicSkyblock.getConfiguration().experienceBoosterCost + "Inselkristalle", "", "&b&l[!] &bRechtsklick zum kaufen."))));
        this.flight = Utils.makeItem(Material.FEATHER, 1, 0, "&b&lFlugmodus", Utils.color(new ArrayList<>(Arrays.asList("&7Du fällst zu oft von der Insel? Kaufe diesen", "&7Booster und erlaube allen Mitgliedern zu fliegen.", "", "&b&lInformation:", "&b&l * &7Verbleibende Zeit: &b" + island.getFlightBooster() + "s", "&b&l * &7Booster Kosten: &b" + EpicSkyblock.getConfiguration().flightBoosterCost + " Inselkristalle", "", "&b&l[!] &bRechtsklick zum kaufen."))));
        inventory.setItem(10, spawner);
        inventory.setItem(12, farming);
        inventory.setItem(14, exp);
        inventory.setItem(16, flight);
    }
}
