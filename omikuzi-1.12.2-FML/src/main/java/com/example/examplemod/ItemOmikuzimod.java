package com.example.examplemod;

import net.minecraft.item.Item;

public class itemomikuzimod extends Item {

    public itemomikuzimod() {
        super();
        // レジストリに保存する名称を登録する。大文字禁止。
        this.setRegistryName(OmikuziMod.MODID, "omikuzi");
        // 新しいクリエイティブタブを設定する。
        this.setCreativeTab(OmikuziMod.OMIKUZI_TAB);
        // 翻訳名を登録する。大文字非推奨。
        this.setUnlocalizedName("omikuzi");
    }
}
