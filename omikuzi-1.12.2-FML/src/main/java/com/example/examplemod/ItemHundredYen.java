package com.example.examplemod;

import net.minecraft.item.Item;

public class ItemHundredYen extends Item {

    public static ItemHundredYen instance;

    public ItemHundredYen() {
        super();
        setRegistryName("omikuziMod", "100yen");
        setCreativeTab(OmikuziMod.OMIKUZI_TAB);
        setUnlocalizedName("100yen");
        instance = this;
    }
}