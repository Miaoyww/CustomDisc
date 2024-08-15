package org.miaoyww.customDisc.enums;

import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.SoundCategory;

public enum MusicDiscType {
    DISC_13(Material.MUSIC_DISC_13, Sound.MUSIC_DISC_13),
    CAT(Material.MUSIC_DISC_CAT, Sound.MUSIC_DISC_CAT),
    BLOCKS(Material.MUSIC_DISC_BLOCKS, Sound.MUSIC_DISC_BLOCKS),
    CHIRP(Material.MUSIC_DISC_CHIRP, Sound.MUSIC_DISC_CHIRP),
    FAR(Material.MUSIC_DISC_FAR, Sound.MUSIC_DISC_FAR),
    MALL(Material.MUSIC_DISC_MALL, Sound.MUSIC_DISC_MALL),
    MELLOHI(Material.MUSIC_DISC_MELLOHI, Sound.MUSIC_DISC_MELLOHI),
    STAL(Material.MUSIC_DISC_STAL, Sound.MUSIC_DISC_STAL),
    STRAD(Material.MUSIC_DISC_STRAD, Sound.MUSIC_DISC_STRAD),
    WARD(Material.MUSIC_DISC_WARD, Sound.MUSIC_DISC_WARD),
    DISC_11(Material.MUSIC_DISC_11, Sound.MUSIC_DISC_11),
    WAIT(Material.MUSIC_DISC_WAIT, Sound.MUSIC_DISC_WAIT),
    PIGSTEP(Material.MUSIC_DISC_PIGSTEP, Sound.MUSIC_DISC_PIGSTEP);


    private final Material material;
    private final Sound sound;

    private MusicDiscType(Material material, Sound sound) {
        this.material = material;
        this.sound = sound;
    }

    public Sound getSound() {
        return this.sound;
    }

    public Material getMaterial() {
        return this.material;
    }

    public static MusicDiscType getFromName(String name) {
        return valueOf(name.toUpperCase());
    }
    
    public static MusicDiscType getFromMaterial(Material material) {
        for (MusicDiscType type : values()) {
            if (type.getMaterial() == material) {
                return type;
            }
        }
        return null;
    }
    public static Material getMaterialFromDisc(MusicDiscType type) {
        return type != DISC_13 && type != DISC_11 ? Material.getMaterial("MUSIC_DISC_" + type.toString()) : Material.getMaterial("MUSIC_" + type.toString());
    }


}