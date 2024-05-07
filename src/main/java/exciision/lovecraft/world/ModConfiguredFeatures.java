package exciision.lovecraft.world;

import exciision.lovecraft.Lovecraft;
import exciision.lovecraft.block.ModBlocks;
import net.minecraft.registry.Registerable;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.BlockTags;
import net.minecraft.structure.rule.RuleTest;
import net.minecraft.structure.rule.TagMatchRuleTest;
import net.minecraft.util.Identifier;
import net.minecraft.world.gen.feature.ConfiguredFeature;
import net.minecraft.world.gen.feature.Feature;
import net.minecraft.world.gen.feature.FeatureConfig;
import net.minecraft.world.gen.feature.OreFeatureConfig;

import java.util.List;

public class ModConfiguredFeatures {
    public static final RegistryKey<ConfiguredFeature<?, ?>> FTHARIN_ORE_KEY = registerKey("ftharin_ore");
    public static final RegistryKey<ConfiguredFeature<?, ?>> NETHER_FTHARIN_ORE_KEY = registerKey("nether_ftharin_ore");

    public static void boostrap(Registerable<ConfiguredFeature<?, ?>> context) {
        RuleTest stoneReplacables = new TagMatchRuleTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplacables = new TagMatchRuleTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherReplacables = new TagMatchRuleTest(BlockTags.BASE_STONE_NETHER);

        List<OreFeatureConfig.Target> overworldFtharinOres =
                List.of(OreFeatureConfig.createTarget(stoneReplacables, ModBlocks.FTHARIN_ORE.getDefaultState()),
                        OreFeatureConfig.createTarget(deepslateReplacables, ModBlocks.DEEPSLATE_FTHARIN_ORE.getDefaultState()));

        List<OreFeatureConfig.Target> netherFtharinOres =
                List.of(OreFeatureConfig.createTarget(netherReplacables, ModBlocks.NETHER_FTHARIN_ORE.getDefaultState()));


        register(context, FTHARIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(overworldFtharinOres, 12));
        register(context, NETHER_FTHARIN_ORE_KEY, Feature.ORE, new OreFeatureConfig(netherFtharinOres, 12));
    }


    public static RegistryKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return RegistryKey.of(RegistryKeys.CONFIGURED_FEATURE, new Identifier(Lovecraft.MOD_ID, name));
    }

    private static <FC extends FeatureConfig, F extends Feature<FC>>
        void register(Registerable<ConfiguredFeature<?, ?>> context,                                                                                   RegistryKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }
}
