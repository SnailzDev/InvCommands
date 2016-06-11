/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package net.snailz.invcommands;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author SnailCreek
 */

public class Main extends JavaPlugin{
    public static String pluginprefix = ChatColor.YELLOW + "[" + ChatColor.GREEN + "InvCommands" + ChatColor.YELLOW + "] " + ChatColor.RESET;
    @Override
    public void onEnable(){
        this.getCommand("workbench").setExecutor(new workbench(this));
        this.getCommand("enchantmenttable").setExecutor(new enchantmenttable (this));
        this.getCommand("endchest").setExecutor(new enderchest (this));
        this.getCommand("openinv").setExecutor(new openinv (this));
    }
    
}
