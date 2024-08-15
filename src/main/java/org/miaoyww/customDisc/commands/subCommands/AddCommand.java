package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.commands.CommandManager;
import org.miaoyww.customDisc.interfaces.ISubCommand;

import java.util.Arrays;
import java.util.logging.Level;

public class AddCommand extends ISubCommand {
    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "添加新唱片";
    }

    @Override
    public String getSyntax() {
        return "";
    }

    @Override
    public void perform(Player player, String[] args) {
        if (args.length != 2 && args.length != 3) {
            player.sendMessage("参数错误");
            return;
        }
        String discName = args[0];
        String discPath = args[1];


        switch (args.length) {
            case 2:
                if (!CustomDiscPlugin.getInstance().registerDisc(discName, discPath)) {
                    player.sendMessage("唱片名称已存在");
                    return;
                }
                break;
            case 3:
                if (!CustomDiscPlugin.getInstance().registerDisc(discName, discPath, getMaterial(args[2]))) {
                    player.sendMessage("唱片名称已存在");
                    return;
                }
        }
        player.sendMessage("已添加唱片 " + discName);

    }

    private Material getMaterial(String material) {
        switch (material) {
            case "cat":
                return Material.MUSIC_DISC_CAT;
            case "blocks":
                return Material.MUSIC_DISC_BLOCKS;
            case "chirp":
                return Material.MUSIC_DISC_CHIRP;
            case "far":
                return Material.MUSIC_DISC_FAR;
            case "mall":
                return Material.MUSIC_DISC_MALL;
            case "mellohi":
                return Material.MUSIC_DISC_MELLOHI;
            case "stal":
                return Material.MUSIC_DISC_STAL;
            case "strad":
                return Material.MUSIC_DISC_STRAD;
            case "ward":
                return Material.MUSIC_DISC_WARD;
            case "11":
                return Material.MUSIC_DISC_11;
            case "wait":
                return Material.MUSIC_DISC_WAIT;
            case "otherside":
                return Material.MUSIC_DISC_OTHERSIDE;
            case "relic":
                return Material.MUSIC_DISC_RELIC;
            case "5":
                return Material.MUSIC_DISC_5;
            case "pigstep":
                return Material.MUSIC_DISC_PIGSTEP;
            default:
                return Material.MUSIC_DISC_13;
        }
    }
}
