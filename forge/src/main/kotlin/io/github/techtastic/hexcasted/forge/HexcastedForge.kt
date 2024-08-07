package io.github.techtastic.hexcasted.forge

import at.petrak.hexcasting.common.lib.HexRegistries
import dev.architectury.platform.forge.EventBuses
import io.github.techtastic.hexcasted.Hexcasted.MOD_ID
import io.github.techtastic.hexcasted.Hexcasted.init
import io.github.techtastic.hexcasted.casting.PatternRegistry
import net.minecraftforge.fml.common.Mod
import net.minecraftforge.registries.RegisterEvent
import thedarkcolour.kotlinforforge.KotlinModLoadingContext

@Mod(MOD_ID)
class HexcastedForge {
    init {
        val bus = KotlinModLoadingContext.get().getKEventBus()
        EventBuses.registerModEventBus(MOD_ID, bus)
        init()

        bus.addListener { event: RegisterEvent ->
            if (event.registryKey == HexRegistries.ACTION)
                PatternRegistry.register { id, entry ->
                    event.register(HexRegistries.ACTION, id) { entry } }
        }
    }
}
