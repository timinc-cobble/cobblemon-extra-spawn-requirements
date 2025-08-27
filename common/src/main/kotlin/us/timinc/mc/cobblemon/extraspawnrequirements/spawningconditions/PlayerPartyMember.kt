package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.pokemon.PokemonProperties
import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import com.cobblemon.mod.common.util.party
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerPartyMember : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val partyMember: String = ""

    @delegate:Transient
    val partyMemberProps by lazy {
        PokemonProperties.parse(partyMember)
    }

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = partyMember == ""

    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        player.party().any(partyMemberProps::matches)
}