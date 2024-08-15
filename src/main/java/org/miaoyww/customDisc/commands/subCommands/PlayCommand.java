package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;
import org.miaoyww.customDisc.interfaces.ICommandManager;
import org.miaoyww.customDisc.interfaces.ISubCommand;
import org.miaoyww.customDisc.utils.PlaySound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.logging.Level;

public class PlayCommand extends ICommandManager {
    public PlayCommand() {
        this.Suggestions.add("stop");
        for (Iterator<String> it = CustomDiscPlugin.getInstance().discList.keys().asIterator(); it.hasNext(); ) {
            this.Suggestions.add(it.next());
        }
        Bukkit.getLogger().log(Level.INFO, "PlayCommand: " + Suggestions.size());
    }

    @Override
    public String getName() {
        return "play";
    }

    @Override
    public String getDescription() {
        return "播放唱片";
    }

    @Override
    public String getSyntax() {
        return "<唱片名称>";
    }

    @Override
    public void perform(Player player, String args[]) {
    }


    @Override
    public boolean onCommand(@NotNull CommandSender commandSender,
                             @NotNull Command command, 
                             @NotNull String s, 
                             @NotNull String[] strings) {
        Player player = (Player) commandSender;
        if(strings.length == 0) {
            player.sendMessage("参数错误");
            return false;
        }
        if(strings[0].equals("stop")) {
            player.stopAllSounds();
            return true;
        }
        String name = strings[0];
        if(!CustomDiscPlugin.getInstance().hasDisc(strings[0])) {
            player.sendMessage("找不到唱片");
            return false;
        }
        MusicDisc disc = CustomDiscPlugin.getInstance().getDisc(name);
        String path = disc.getSound();
        player.sendMessage("正在播放唱片: " + disc);
        PlaySound.playSound(player, path);
        return true;
    }
}
