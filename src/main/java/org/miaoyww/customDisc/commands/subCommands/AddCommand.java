package org.miaoyww.customDisc.commands.subCommands;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.miaoyww.customDisc.CustomDiscPlugin;
import org.miaoyww.customDisc.MusicDisc;
import org.miaoyww.customDisc.commands.CommandManager;
import org.miaoyww.customDisc.interfaces.ISubCommand;
import org.miaoyww.customDisc.utils.Files;
import org.miaoyww.customDisc.utils.Messages;

import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;

import static org.miaoyww.customDisc.utils.CheckUtils.getMaterial;

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
        if (args.length <= 3 || args.length > 5) {
            Messages.sendMessage(player, "参数错误, 正确用法 §e/disc add <name> <displayName> <lore> <record> [material]");
            return;
        }
        String name = args[0];
        if (CustomDiscPlugin.getInstance().hasDisc(name)) {
            Messages.sendMessage(player, "唱片名称已存在");
            return;
        }
        String disPlayName = args[1];
        List<String> lore = Arrays.asList(args[2].split(";"));
        String discPath = args[3];
        Material material;
        if (args.length == 5) {
            material = getMaterial(args[4]);
        } else {
            material = Material.MUSIC_DISC_CAT;
        }
        MusicDisc musicDisc = MusicDisc.getDiscItemStack(name, disPlayName, lore, discPath, material);
        CustomDiscPlugin.getInstance().discList.put(name, musicDisc);
        Messages.sendMessageToPlayer(player, "已添加唱片 " + name);
        Files.saveDiscConfig();
    }
}
