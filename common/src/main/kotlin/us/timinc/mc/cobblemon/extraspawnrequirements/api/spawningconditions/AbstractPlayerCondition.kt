package us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions

import com.cobblemon.mod.common.api.spawning.condition.AppendageCondition
import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.server.level.ServerPlayer

abstract class AbstractPlayerCondition : AppendageCondition {
    abstract fun matchesAll(): Boolean
    abstract fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean

    override fun fits(ctx: SpawningContext): Boolean {
        if (matchesAll()) return true
        val player = ctx.cause.entity as? ServerPlayer ?: return false
        return matchesPlayer(player, ctx)
    }
}