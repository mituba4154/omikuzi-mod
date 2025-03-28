package com.example.examplemod;

import net.minecraft.item.Item;

public class ItemHundredYen extends Item {

    public ItemHundredYen() {
        super();
        this.setRegistryName(OmikuziMod.MODID, "100yen");
        this.setCreativeTab(OmikuziMod.OMIKUZI_TAB);
        this.setUnlocalizedName("100yen");
    }
}