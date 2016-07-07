/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snailz.invcommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.block.Chest;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

/**
 *
 * @author SnailCreek
 */
public class chest implements CommandExecutor{
    Main plugin;

    public chest (Main passedPlugin){
        this.plugin = passedPlugin;
    }
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
        if (command.getName().equalsIgnoreCase("chest")){
            double x = (double) Integer.parseInt(args[0]);
            double y = (double) Integer.parseInt(args[1]);
            double z = (double) Integer.parseInt(args[2]);
            if (args.length == 3){
                if (sender instanceof Player){
                    Player player = (Player) sender;
                    Location location = new Location(player.getWorld(),x,y,z);
                    Chest chest = (Chest) location.getBlock().getState();
                    Inventory chestinv = chest.getBlockInventory();
                    player.openInventory(chestinv);
                    sender.sendMessage(Main.pluginprefix + org.bukkit.ChatColor.GREEN + "Chest Oppend");
                    return true;
                }
                else {
                    sender.sendMessage(Main.pluginprefix + org.bukkit.ChatColor.RED + "You Must Be A Player To Execute This Command");
                    return true;
                }
            }
            if (args.length == 1){
                if (sender instanceof Player){
                    Player commandsender = (Player) sender;
                    if (!commandsender.hasPermission("invcommands.chest.others")){
                        commandsender.sendMessage(org.bukkit.ChatColor.RED + "Im sorry but you do not have permission for that command!");
                        return true;
                    }
                }
                if (plugin.getServer().getPlayer(args[0]) != null){
                    Player player = plugin.getServer().getPlayer(args[0]);
                    Location location = new Location(player.getWorld(),x,y,z);
                    Chest chest = (Chest) location.getBlock().getState();
                    Inventory chestinv = chest.getBlockInventory();
                    player.openInventory(chestinv);
                    sender.sendMessage(Main.pluginprefix + org.bukkit.ChatColor.GREEN + "Oppend Chest For" + ChatColor.GOLD + args[0]);
                    return true;
                }
                else {
                    sender.sendMessage(Main.pluginprefix + org.bukkit.ChatColor.GOLD + args[0] + " is not online!");
                    return true;
                }
            }
        }
        return false;
    }

}

