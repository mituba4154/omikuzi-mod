package com.example.examplemod;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class itemomikuzimod extends Item {

    public itemomikuzimod() {
        super();
        // レジストリに保存する名称を登録する。大文字禁止。
        this.setRegistryName("omikuzimod", "omikuzi"); // "aluminium" を "omikuzi" に変更
        // クリエイティブタブを設定する。
        this.setCreativeTab(CreativeTabs.MATERIALS);
        // 翻訳名を登録する。大文字非推奨。
        this.setUnlocalizedName("omikuzi"); // "aluminium" を "omikuzi" に変更
    }
}
