package com.example.examplemod;

import net.minecraft.init.Blocks;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import org.apache.logging.log4j.Logger;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.RegistryEvent.Register;
import net.minecraftforge.fml.common.event.FMLConstructionEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

@Mod(modid = OmikuziMod.MODID, name = OmikuziMod.NAME, version = OmikuziMod.VERSION, acceptedMinecraftVersions = "[1.12.2]")
public class OmikuziMod {
    public static final String MODID = "omikuziMod";
    public static final String NAME = "Omikuzi-FML";
    public static final String VERSION = "Alpha-0.2";

    private static Logger logger;

    // 新しいクリエイティブタブを作成
    public static final CreativeTabs OMIKUZI_TAB = new CreativeTabs("omikuzi_tab") {
        @Override
        @SideOnly(Side.CLIENT)
        public ItemStack getTabIconItem() {
            return new ItemStack(ItemOmikuzi.instance);
        }
    };

    // アイテムのインスタンスを静的フィールドとして定義
    public static ItemOmikuzi OMIKUZI_MOD_ITEM;
    public static ItemHundredYen HUNDRED_YEN_ITEM;

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        logger = event.getModLog();
        logger.info("Pre-initializing " + NAME);
    }

    @EventHandler
    public void init(FMLInitializationEvent event) {
        logger.info("DIRT BLOCK >> {}", Blocks.DIRT.getRegistryName());
        logger.info(NAME + " initialized successfully!");
    }

    @Mod.EventHandler
    public void construct(FMLConstructionEvent event) {
        MinecraftForge.EVENT_BUS.register(this);
    }

    @SubscribeEvent
    public void registerItems(Register<Item> event) {
        event.getRegistry().registerAll(
                ItemOmikuzi.instance,
                ItemHundredYen.instance
        );
    }

    @SubscribeEvent
    @SideOnly(Side.CLIENT)
    public void registerModels(ModelRegistryEvent event) {
        ModelLoader.setCustomModelResourceLocation(ItemOmikuzi.instance, 0,
                new ModelResourceLocation(MODID + ":omikuzi", "inventory"));
        ModelLoader.setCustomModelResourceLocation(ItemHundredYen.instance, 0,
                new ModelResourceLocation(MODID + ":100yen", "inventory"));
    }
}