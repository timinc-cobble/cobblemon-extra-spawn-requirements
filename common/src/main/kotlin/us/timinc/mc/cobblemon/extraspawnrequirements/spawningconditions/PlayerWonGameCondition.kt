package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerWonGameCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val playerWonGame: Boolean? = null

    override fun matchesAll(): Boolean = playerWonGame == null

    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean = player.wonGame == playerWonGame
}