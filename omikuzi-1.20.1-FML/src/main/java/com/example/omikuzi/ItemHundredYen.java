package com.example.omikuzi;

import net.minecraft.world.item.Item;
// import net.minecraft.world.item.CreativeModeTab; // 不要

public class ItemHundredYen extends Item {
    public ItemHundredYen() {
        // ★ .tab() と setRegistryName() を削除
        super(new Item.Properties());
        // this.setRegistryName(OmikuziMod.MODID, "100yen"); // ← 削除
    }
}