package com.example.omikuzi;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.CreativeModeTab;

public class ItemOmikuzi extends Item {
    public ItemOmikuzi() {
        super(new Item.Properties().tab(OmikuziMod.OMIKUZI_TAB));
        this.setRegistryName(OmikuziMod.MODID, "omikuzi");
    }
}