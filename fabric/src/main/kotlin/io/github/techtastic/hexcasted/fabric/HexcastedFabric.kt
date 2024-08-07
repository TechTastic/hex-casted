package io.github.techtastic.hexcasted.fabric

import at.petrak.hexcasting.common.lib.hex.HexActions
import io.github.techtastic.hexcasted.Hexcasted.init
import io.github.techtastic.hexcasted.casting.PatternRegistry
import net.fabricmc.api.ModInitializer
import net.minecraft.core.Registry
import java.util.function.BiConsumer

class HexcastedFabric : ModInitializer {
    override fun onInitialize() {
        init()

        PatternRegistry.register { id, entry -> Registry.register(HexActions.REGISTRY, id, entry) }
    }
}
