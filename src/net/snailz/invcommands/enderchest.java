/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snailz.invcommands;

import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

/**
 *
 * @author SnailCreek
 */
public class enderchest implements CommandExecutor{
    
     Main plugin;

    public enderchest (Main passedPlugin){
        this.plugin = passedPlugin;
    }
    
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("endchest")){
            if (args.length == 0){
                if (sender instanceof Player){
                    Player player = (Player) sender;
                    player.openInventory(player.getEnderChest());
                    sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Enderchest Oppend!");
                    return true;
                }
                else {
                    sender.sendMessage(Main.pluginprefix + ChatColor.RED + "You Must Be A Player To Execute This Command");
                    return true;
                }
            }
            if (args.length == 1){
                if (sender instanceof Player){
                    Player commandsender = (Player) sender;
                    if (!commandsender.hasPermission("invcommands.enderchest.others")){
                        commandsender.sendMessage(ChatColor.RED + "Im sorry but you do not have permission for that command!");
                        return true;
                    }
                }
                if (plugin.getServer().getPlayer(args[0]) != null){
                    Player player = plugin.getServer().getPlayer(args[0]);
                    player.openInventory(player.getEnderChest());
                    sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Oppend enderchest for " + ChatColor.GOLD + args[0]);
                    return true;
                }
                else {
                    sender.sendMessage(Main.pluginprefix + ChatColor.GOLD + args[0] + " is not online!");
                    return true;
                }
            }
        }
        return false;
    }
}
