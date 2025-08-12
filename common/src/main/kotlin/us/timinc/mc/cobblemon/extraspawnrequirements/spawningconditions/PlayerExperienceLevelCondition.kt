package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerExperienceLevelCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val minPlayerLevel: Int = -1

    @Suppress("MemberVisibilityCanBePrivate")
    val maxPlayerLevel: Int = -1

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = minPlayerLevel == -1 && maxPlayerLevel == -1

    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean {
        @Suppress("KotlinConstantConditions")
        return (minPlayerLevel == -1 || player.experienceLevel >= minPlayerLevel) && (maxPlayerLevel == -1 || player.experienceLevel <= maxPlayerLevel)
    }
}