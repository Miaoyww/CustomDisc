package org.miaoyww.customDisc.utils;

import org.miaoyww.customDisc.enums.MusicDiscType;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerData {
    private UUID uuid;
    private Map<MusicDiscType, Boolean> unlockedDiscs = new HashMap();

    public PlayerData(UUID uuid, MusicDiscType... discs) {
        MusicDiscType[] var6 = discs;
        int var5 = discs.length;

        for(int var4 = 0; var4 < var5; ++var4) {
            MusicDiscType d = var6[var4];
            this.addUnlockedDisc(d);
        }

        this.setUUID(uuid);
    }

    public PlayerData(UUID uuid) {
        this.setUUID(uuid);
    }

    public Map<MusicDiscType, Boolean> getUnlockedDiscs() {
        return this.unlockedDiscs;
    }

    public UUID getUUID() {
        return this.uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public void addUnlockedDisc(MusicDiscType disc) {
        this.unlockedDiscs.put(disc, true);
    }

    public void removeUnlockedDisc(MusicDiscType disc) {
        this.unlockedDiscs.put(disc, false);
    }

    public void clearUnlockedDiscs() {
        this.unlockedDiscs.clear();
    }

    public boolean hasDiscUnlocked(MusicDiscType disc) {
        return this.unlockedDiscs.get(disc) == null ? false : (Boolean)this.unlockedDiscs.get(disc);
    }
}
