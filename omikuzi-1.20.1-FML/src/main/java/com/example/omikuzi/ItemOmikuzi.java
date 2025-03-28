package com.example.omikuzi;

import net.minecraft.world.item.Item;
// import net.minecraft.world.item.CreativeModeTab; // 不要

public class ItemOmikuzi extends Item {
    public ItemOmikuzi() {
        // ★ .tab() と setRegistryName() を削除
        super(new Item.Properties());
        // this.setRegistryName(OmikuziMod.MODID, "omikuzi"); // ← 削除
    }
}