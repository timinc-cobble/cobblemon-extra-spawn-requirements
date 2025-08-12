package us.timinc.mc.cobblemon.extraspawnrequirements.spawning.condition

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerIsFishingCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val playerIsFishing: Boolean? = null

    override fun matchesAll(): Boolean = playerIsFishing == null

    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        (player.fishing == null) == playerIsFishing
}