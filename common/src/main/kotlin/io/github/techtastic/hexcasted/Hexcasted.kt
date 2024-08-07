package io.github.techtastic.hexcasted

import net.minecraft.resources.ResourceLocation
import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger

object Hexcasted {
    const val MOD_ID = "hexcasted"
    val LOGGER: Logger = LogManager.getLogger(MOD_ID)

    @JvmStatic
    fun init() {
    }

    @JvmStatic
    fun id(string: String): ResourceLocation {
        return ResourceLocation(MOD_ID, string)
    }
}
