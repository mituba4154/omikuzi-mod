package com.example.omikuzi;

import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.event.CreativeModeTabEvent;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(OmikuziMod.MODID)
public class OmikuziMod {
    public static final String MODID = "omikuzi";
    public static final String NAME = "Omikuzi";
    public static final String VERSION = "1.0";
    public static final Logger LOGGER = LogManager.getLogger();

    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> OMIKUZI_ITEM = ITEMS.register("omikuzi", ItemOmikuzi::new);
    public static final RegistryObject<Item> HUNDRED_YEN_ITEM = ITEMS.register("100yen", ItemHundredYen::new);

    public static CreativeModeTab OMIKUZI_TAB;

    public OmikuziMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        ITEMS.register(modEventBus);
        modEventBus.addListener(this::registerCreativeTabs);
    }

    private void registerCreativeTabs(final CreativeModeTabEvent.Register event) {
        OMIKUZI_TAB = CreativeModeTab.builder()
                .title(MODID)
                .icon(() -> new ItemStack(OMIKUZI_ITEM.get()))
                .build();

        event.registerCreativeModeTab(OMIKUZI_TAB);
    }
}