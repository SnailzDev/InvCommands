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
public class enchantmenttable implements CommandExecutor{
    
    Main plugin;

    public enchantmenttable (Main passedPlugin){
        this.plugin = passedPlugin;
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (command.getName().equalsIgnoreCase("enchantmenttable")){
            if (args.length == 0){
                if (sender instanceof Player){
                    Player player = (Player) sender;
                    player.openEnchanting(new Location(player.getWorld(), 0,0,0), true);
                    sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Enchantment Table Oppend");
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
                    if (!commandsender.hasPermission("invcommands.enchantmenttable.others")){
                        commandsender.sendMessage(ChatColor.RED + "Im sorry but you do not have permission for that command!");
                        return true;
                    }
                }
                if (plugin.getServer().getPlayer(args[0]) != null){
                    Player player = plugin.getServer().getPlayer(args[0]);
                    player.openEnchanting(new Location(player.getWorld(), 0,0,0), true);
                    sender.sendMessage(Main.pluginprefix + ChatColor.GREEN + "Oppend Enchantment Table For " + ChatColor.GOLD + args[0]);
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
