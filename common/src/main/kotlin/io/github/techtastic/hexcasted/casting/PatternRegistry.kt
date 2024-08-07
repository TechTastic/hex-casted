package io.github.techtastic.hexcasted.casting

import at.petrak.hexcasting.api.casting.ActionRegistryEntry
import at.petrak.hexcasting.api.casting.math.HexDir
import at.petrak.hexcasting.api.casting.math.HexPattern
import io.github.techtastic.hexcasted.Hexcasted.id
import io.github.techtastic.hexcasted.casting.patterns.OpShellGetHex
import io.github.techtastic.hexcasted.casting.patterns.OpShellSetHex
import io.github.techtastic.hexcasted.casting.spells.OpShellCreate
import io.github.techtastic.hexcasted.util.ShellHex
import net.minecraft.resources.ResourceLocation
import java.util.function.BiConsumer

object PatternRegistry {
    private val ACTIONS = mutableMapOf<ResourceLocation, ActionRegistryEntry>()

    fun register(func: BiConsumer<ResourceLocation, ActionRegistryEntry>) {
        ACTIONS.forEach(func::accept)
    }

    private fun make(name: String, entry: ActionRegistryEntry): ActionRegistryEntry {
        if (ACTIONS.put(id(name), entry) != null) throw IllegalArgumentException("Typo? Duplicate id $name")
        return entry
    }

    val SHELL_GET_ON_TICK = make("shell_get_on_tick", ActionRegistryEntry(
        HexPattern.fromAngles("edqdeaeweeewedwwwadeeed", HexDir.SOUTH_WEST),
        OpShellGetHex(ShellHex.ON_TICK)
    ))
    val SHELL_SET_ON_TICK = make("shell_set_on_tick", ActionRegistryEntry(
        HexPattern.fromAngles("qaeaqdqwqqqwqawwwdaqqqa", HexDir.SOUTH_EAST),
        OpShellSetHex(ShellHex.ON_TICK)
    ))

    val SHELL_GET_ON_DETONATE = make("shell_get_on_detonate", ActionRegistryEntry(
        HexPattern.fromAngles("edqdeaeweeewedqded", HexDir.SOUTH_WEST),
        OpShellGetHex(ShellHex.ON_DETONATE)
    ))
    val SHELL_SET_ON_DETONATE = make("shell_set_on_detonate", ActionRegistryEntry(
        HexPattern.fromAngles("qaeaqdqwqqqwqaeaqa", HexDir.SOUTH_EAST),
        OpShellSetHex(ShellHex.ON_DETONATE)
    ))

    val CREATE_SHELL = make("create_shell", ActionRegistryEntry(
        HexPattern.fromAngles("edqdeadwawdedwawddww", HexDir.SOUTH_WEST),
        OpShellCreate
    ))
}