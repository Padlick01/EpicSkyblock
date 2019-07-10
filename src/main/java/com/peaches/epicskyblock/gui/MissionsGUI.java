package com.peaches.epicskyblock.gui;

import com.peaches.epicskyblock.EpicSkyblock;
import com.peaches.epicskyblock.Island;
import com.peaches.epicskyblock.Utils;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
import java.util.Arrays;

public class MissionsGUI {

    public Inventory inventory;
    public int islandID;
    public int scheduler;

    public ItemStack treasureHunter;
    public ItemStack competitor;
    public ItemStack miner;
    public ItemStack farmer;
    public ItemStack hunter;
    public ItemStack fisherman;
    public ItemStack builder;

    public MissionsGUI(Island island) {
        this.inventory = Bukkit.createInventory(null, 27, Utils.color(EpicSkyblock.getConfiguration().MissionsGUITitle));
        islandID = island.getId();
        scheduler = Bukkit.getScheduler().scheduleAsyncRepeatingTask(EpicSkyblock.getInstance(), this::addContent, 0, 10);
    }

    public void addContent() {
        Island island = EpicSkyblock.getIslandManager().islands.get(islandID);
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, Utils.makeItem(Material.STAINED_GLASS_PANE, 1, 7, " "));
        }
        this.treasureHunter = Utils.makeItemHidden(Material.EXP_BOTTLE, 1, 0, "&b&lSchatzjäger", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bSammle " + EpicSkyblock.getMissions().treasureHunter.getAmount() + " Erfahrungspunkte", "&b&l * &7Status: &b" + (island.treasureHunter != -1 ? island.treasureHunter + "/" + EpicSkyblock.getMissions().treasureHunter.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().treasureHunter.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));
        this.competitor = Utils.makeItemHidden(Material.GOLD_INGOT, 1, 0, "&b&lWettbewerber", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bErlange " + EpicSkyblock.getMissions().competitor.getAmount() + " Insellevel", "&b&l * &7Status: &b" + (island.competitor != Integer.MIN_VALUE ? island.competitor + "/" + EpicSkyblock.getMissions().competitor.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().competitor.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));
        this.miner = Utils.makeItemHidden(Material.DIAMOND_ORE, 1, 0, "&b&lBergarbeiter", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bBaue " + EpicSkyblock.getMissions().miner.getAmount() + " Erze ab", "&b&l * &7Status: &b" + (island.miner != -1 ? island.miner + "/" + EpicSkyblock.getMissions().miner.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().miner.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));
        this.farmer = Utils.makeItemHidden(Material.SUGAR_CANE, 1, 0, "&b&lFarmer", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bErnte " + EpicSkyblock.getMissions().farmer.getAmount() + " Pflanzen", "&b&l * &7Status: &b" + (island.farmer != -1 ? island.farmer + "/" + EpicSkyblock.getMissions().farmer.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().farmer.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));
        this.hunter = Utils.makeItemHidden(Material.BLAZE_POWDER, 1, 0, "&b&lJäger", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bTöte " + EpicSkyblock.getMissions().hunter.getAmount() + " Monster", "&b&l * &7Status: &b" + (island.hunter != -1 ? island.hunter + "/" + EpicSkyblock.getMissions().hunter.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().hunter.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));
        this.fisherman = Utils.makeItemHidden(Material.FISHING_ROD, 1, 0, "&b&lFischer", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bFange " + EpicSkyblock.getMissions().fisherman.getAmount() + " Fische", "&b&l * &7Status: &b" + (island.fisherman != -1 ? island.fisherman + "/" + EpicSkyblock.getMissions().fisherman.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().fisherman.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));
        this.builder = Utils.makeItemHidden(Material.COBBLESTONE, 1, 0, "&b&lArchitekt", Utils.color(new ArrayList<>(Arrays.asList("&7Schließe Missionen für Inselkristalle ab", "&7die für Boosters und Upgrades benutzt werden können.", "", "&b&lInformation:", "&b&l * &7Mission: &bPlatziere " + EpicSkyblock.getMissions().builder.getAmount() + " Blöcke", "&b&l * &7Status: &b" + (island.builder != -1 ? island.builder + "/" + EpicSkyblock.getMissions().builder.getAmount() : "Abgeschlossen"), "&b&l * &7Belohnung: &b" + EpicSkyblock.getMissions().builder.getReward() + " Inselkristalle", "", "&b&l[!] &bMission beenden für Belohnung"))));

        inventory.setItem(10, this.treasureHunter);
        inventory.setItem(11, this.competitor);
        inventory.setItem(12, this.miner);
        inventory.setItem(13, this.farmer);
        inventory.setItem(14, this.hunter);
        inventory.setItem(15, this.fisherman);
        inventory.setItem(16, this.builder);
    }
}
