/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snailz.invcommands;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author SnailCreek
 */
public class openinv implements CommandExecutor{
    
    Main plugin;

    public openinv (Main passedPlugin){
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("openinv")){
            if (sender instanceof Player){
                Player player = (Player) sender;
                if (args[0].equalsIgnoreCase("inventory")){
                    if (args.length == 3){
                        if (!player.hasPermission("invcommands.openinv.inventory.others")){
                            player.sendMessage(ChatColor.RED + "Im sorry but you do not have permission for that command!");
                            return true;
                        }
                        if (plugin.getServer().getPlayer(args[1]) != null && plugin.getServer().getPlayer(args[2]) != null){
                            Player player2 = plugin.getServer().getPlayer(args[1]);
                            Player player3 = plugin.getServer().getPlayer(args[2]);
                            player3.openInventory(player2.getInventory());
                            sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Oppend inventory of " + ChatColor.GOLD + args[1] + ChatColor.GREEN + " for " + ChatColor.GOLD + args[2]);
                            return true;
                        }
                        else {
                            
                            return true;
                        }
                    }
                    if (args.length == 2){
                        if (!player.hasPermission("invcommands.openinv.inventory")){
                            player.sendMessage(ChatColor.RED + "Im sorry but you do not have permission for that command!");
                        return true;
                        }
                        if (plugin.getServer().getPlayer(args[1]) != null){
                            Player player2 = plugin.getServer().getPlayer(args[1]);
                            player.openInventory(player2.getInventory());
                            sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Oppend inventory of " + ChatColor.GOLD + args[1]);
                            return true;
                        }
                        else {
                            sender.sendMessage(Main.pluginprefix + ChatColor.GOLD + args[1] + " is not online!");
                            return true;
                        }
                    }
                }
                    if (args[0].equalsIgnoreCase("enderchest")){
                        if (args.length == 3){
                            if (!player.hasPermission("invcommands.openinv.enderchest.others")){
                                player.sendMessage(ChatColor.RED + "Im sorry but you do not have permission for that command!");
                                return true;
                            }
                            if (plugin.getServer().getPlayer(args[1]) != null && plugin.getServer().getPlayer(args[2]) != null){
                                Player player2 = plugin.getServer().getPlayer(args[1]);
                                Player player3 = plugin.getServer().getPlayer(args[2]);
                                player3.openInventory(player2.getEnderChest());
                                sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Oppend enderchest of " + ChatColor.GOLD + args[1] + ChatColor.GREEN + " for " + ChatColor.GOLD + args[2]);
                                return true;
                            }
                            else {
                                sender.sendMessage(Main.pluginprefix + ChatColor.GOLD + args[1] + " or " + args[2] + ChatColor.GREEN + " is not online!");
                                return true;
                            }
                        }
                        if (args.length == 2){
                            if (!player.hasPermission("invcommands.openinv.enderchest")){
                                player.sendMessage(ChatColor.RED + "Im sorry but you do not have permission for that command!");
                            return true;
                            }
                            if (plugin.getServer().getPlayer(args[1]) != null){
                                Player player2 = plugin.getServer().getPlayer(args[1]);
                                player.openInventory(player2.getEnderChest());
                                sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Oppend enderchest of " + ChatColor.GOLD + args[1]);
                                return true;
                            }
                            else {
                                sender.sendMessage(Main.pluginprefix + ChatColor.GOLD + args[1] + " is not online!");
                                return true;
                            }
                        }
                    }
                return false;
    
    
            }
            else{
                sender.sendMessage(Main.pluginprefix + ChatColor.RED + "You Must Be A Player To Execute This Command!");
            }
        }
        return false;
    }
}
