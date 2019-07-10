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
import java.util.List;

public class UpgradeGUI {

    public Inventory inventory;
    public ItemStack size;
    public ItemStack member;
    public ItemStack warp;
    public int islandID;
    public int scheduler;

    public UpgradeGUI(Island island) {
        this.inventory = Bukkit.createInventory(null, 27, Utils.color(EpicSkyblock.getConfiguration().UpgradeGUITitle));
        islandID = island.getId();
        scheduler = Bukkit.getScheduler().scheduleAsyncRepeatingTask(EpicSkyblock.getInstance(), this::addContent, 0, 10);
    }

    public void addContent() {
        Island island = EpicSkyblock.getIslandManager().islands.get(islandID);
        for (int i = 0; i < 27; i++) {
            inventory.setItem(i, Utils.makeItem(Material.STAINED_GLASS_PANE, 1, 7, " "));
        }

        int currentsize = island.getSizeLevel();
        String sizecost = EpicSkyblock.getConfiguration().size.containsKey(currentsize + 1) ? EpicSkyblock.getConfiguration().size.get(currentsize + 1).getCost() + " Inselkristalle" : "Maximales Level erreicht";
        List<String> sizeLore = new ArrayList<>(Arrays.asList("&7Du benötigst mehr Platz zum expandieren? Kaufe dieses", "&7Upgrade um die Inselgröße zu erhöhen.", "", "&b&lInformation:", "&b&l * &7Aktuelles Level: &b" + currentsize, "&b&l * &7Aktuelle Größe: &b" + EpicSkyblock.getConfiguration().size.get(currentsize).getSize() + "x" + EpicSkyblock.getConfiguration().size.get(currentsize).getSize() + " Blöcke", "&b&l * &7Upgrade-Kosten: &b" + sizecost, "", "&b&lLevel:"));
        for (int level : EpicSkyblock.getConfiguration().size.keySet()) {
            sizeLore.add("&b&l * &7Level " + level + ": &b" + EpicSkyblock.getConfiguration().size.get(level).getSize() + "x" + EpicSkyblock.getConfiguration().size.get(level).getSize() + " Blöcke");
        }
        sizeLore.add("");
        sizeLore.add("&b&l[!] &bRechtsklick um das Upgrade zu kaufen");
        this.size = Utils.makeItem(Material.GRASS, 1, 0, "&b&lInselgröße", Utils.color(sizeLore));


        int currentmember = island.getMemberLevel();
        String membercost = EpicSkyblock.getConfiguration().member.containsKey(currentmember + 1) ? EpicSkyblock.getConfiguration().member.get(currentmember + 1).getCost() + " Inselkristalle" : "Maximales Level erreicht";
        List<String> memberLore = new ArrayList<>(Arrays.asList("&7? Kaufe dieses", "&7Upgrade um die maximale Mitgliederanzahl zu erhöhen", "", "&b&lInformation:", "&b&l * &7Aktuelles Level: &b" + currentmember, "&b&l * &7Aktuelle Mitglieder: &b" + EpicSkyblock.getConfiguration().member.get(currentmember).getSize() + " Mitglieder", "&b&l * &7Upgrade-Kosten: &b" + membercost, "", "&b&lLevel:"));
        for (int level : EpicSkyblock.getConfiguration().member.keySet()) {
            memberLore.add("&b&l * &7Level " + level + ": &b" + EpicSkyblock.getConfiguration().member.get(level).getSize() + " Mitglieder");
        }
        memberLore.add("");
        memberLore.add("&b&l[!] &bRechtsklick um das Upgrade zu kaufen");
        this.member = Utils.makeItem(Material.ARMOR_STAND, 1, 0, "&b&lInselmitglieder", Utils.color(memberLore));


        int currentwarp = island.getWarpLevel();
        String warpcost = EpicSkyblock.getConfiguration().warp.containsKey(currentwarp + 1) ? EpicSkyblock.getConfiguration().warp.get(currentwarp + 1).getCost() + " Kristalle" : "Maximales Level erreicht";
        List<String> warpLore = new ArrayList<>(Arrays.asList("&7Du benötigst mehr Warps? Kaufe dieses", "&7Upgrade um die maximale Anzahl an Warps zu erhöhen", "", "&b&lInformation:", "&b&l * &7Aktuelles Level: &b" + currentwarp, "&b&l * &7Aktuelle Warps: &b" + EpicSkyblock.getConfiguration().warp.get(currentwarp).getSize() + " Warps", "&b&l * &7Upgrade-Kosten: &b" + warpcost, "", "&b&lLevel:"));
        for (int level : EpicSkyblock.getConfiguration().warp.keySet()) {
            warpLore.add("&b&l * &7Level " + level + ": &b" + EpicSkyblock.getConfiguration().warp.get(level).getSize() + " Warps");
        }
        warpLore.add("");
        warpLore.add("&b&l[!] &bRechtsklick um das Upgrade zu kaufen");
        this.warp = Utils.makeItem(Material.ENDER_PORTAL_FRAME, 1, 0, "&b&lInselwarp", Utils.color(warpLore));
        inventory.setItem(10, size);
        inventory.setItem(13, member);
        inventory.setItem(16, warp);
    }
}
