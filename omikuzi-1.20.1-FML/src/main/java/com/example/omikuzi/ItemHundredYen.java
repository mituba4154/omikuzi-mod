package com.example.omikuzi;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class ItemHundredYen extends Item {
    public ItemHundredYen() {
        super(new Item.Properties().tab(OmikuziMod.OMIKUZI_TAB));
        this.setRegistryName(OmikuziMod.MODID, "100yen");
    }
}