package io.github.techtastic.hexcasted.casting.spells

import at.petrak.hexcasting.api.casting.RenderedSpell
import at.petrak.hexcasting.api.casting.castables.SpellAction
import at.petrak.hexcasting.api.casting.eval.CastingEnvironment
import at.petrak.hexcasting.api.casting.iota.Iota

object OpShellCreate: SpellAction {
    override val argc: Int
        get() = 1

    override fun execute(args: List<Iota>, env: CastingEnvironment): SpellAction.Result {
        return SpellAction.Result(Spell(0), 0, listOf())
    }

    private class Spell(media: Long): RenderedSpell {
        override fun cast(env: CastingEnvironment) {
        }
    }
}