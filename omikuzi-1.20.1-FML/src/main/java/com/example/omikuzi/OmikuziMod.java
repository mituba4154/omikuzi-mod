package com.example.omikuzi;

import net.minecraft.core.registries.Registries; // 追加
import net.minecraft.network.chat.Component;    // 追加
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.common.MinecraftForge; // 追加 (必要に応じて)
import net.minecraftforge.event.BuildCreativeModeTabContentsEvent; // ★変更
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.eventbus.api.SubscribeEvent; // 追加
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

    // --- アイテム登録 ---
    public static final DeferredRegister<Item> ITEMS = DeferredRegister.create(ForgeRegistries.ITEMS, MODID);

    public static final RegistryObject<Item> OMIKUZI_ITEM = ITEMS.register("omikuzi", ItemOmikuzi::new);
    public static final RegistryObject<Item> HUNDRED_YEN_ITEM = ITEMS.register("100yen", ItemHundredYen::new);

    // --- クリエイティブタブ登録 ---
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MODID); // ★変更

    public static final RegistryObject<CreativeModeTab> OMIKUZI_TAB = CREATIVE_MODE_TABS.register("omikuzi_tab", // ★タブのID
            () -> CreativeModeTab.builder()
                    .icon(() -> new ItemStack(OMIKUZI_ITEM.get())) // アイコン
                    .title(Component.translatable("itemGroup.omikuzi")) // ★タイトル (言語ファイルで定義 itemGroup.omikuzi=おみくじ)
                    .displayItems((parameters, output) -> {
                        // ★このタブに表示するアイテムをここに追加
                        output.accept(OMIKUZI_ITEM.get());
                        output.accept(HUNDRED_YEN_ITEM.get());
                        // output.accept(Items.DIAMOND); // バニラアイテムも追加可能
                    })
                    .build());

    public OmikuziMod() {
        IEventBus modEventBus = FMLJavaModLoadingContext.get().getModEventBus();

        // DeferredRegister をバスに登録
        ITEMS.register(modEventBus);
        CREATIVE_MODE_TABS.register(modEventBus); // ★タブのDeferredRegisterも登録

        // イベントリスナーの登録 (古いタブ登録リスナーは削除)
        // modEventBus.addListener(this::registerCreativeTabs); // ← これは削除

        // BuildContentsイベントはForgeのメインバスに登録することも可能 (今回は不要)
        // MinecraftForge.EVENT_BUS.register(this);
    }

    // BuildContentsイベントリスナー (任意: DeferredRegister内で直接定義したので、このメソッド自体不要な場合も)
    // もしDeferredRegister内で displayItems を定義しない場合は、こちらのメソッドを使う
    /*
    @SubscribeEvent
    public void addCreative(BuildCreativeModeTabContentsEvent event) {
        if (event.getTabKey() == OMIKUZI_TAB.getKey()) { // ★自分のタブかどうかを確認
             event.accept(OMIKUZI_ITEM);
             event.accept(HUNDRED_YEN_ITEM);
        }
    }
    */

    // 古い registerCreativeTabs メソッドは完全に削除
    // private void registerCreativeTabs(final CreativeModeTabEvent.Register event) { ... }
}