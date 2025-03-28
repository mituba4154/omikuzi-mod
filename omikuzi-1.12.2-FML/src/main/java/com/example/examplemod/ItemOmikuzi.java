package com.example.examplemod;

import net.minecraft.item.Item;

public class ItemOmikuzi extends Item {

    public static ItemOmikuzi instance;

    public ItemOmikuzi() {
        super();
        // レジストリに保存する名称を登録する。大文字禁止。
        setRegistryName("omikuziMod", "omikuzi");
        // 新しいクリエイティブタブを設定する。
        setCreativeTab(OmikuziMod.OMIKUZI_TAB);
        // 翻訳名を登録する。大文字非推奨。
        setUnlocalizedName("omikuzi");
        instance = this;
    }
}
