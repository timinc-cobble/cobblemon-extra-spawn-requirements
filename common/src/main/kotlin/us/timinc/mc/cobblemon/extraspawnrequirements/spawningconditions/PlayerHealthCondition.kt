package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerHealthCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val playerMinHealth: Float = -1F

    @Suppress("MemberVisibilityCanBePrivate")
    val playerMaxHealth: Float = -1F

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = playerMinHealth == -1F && playerMaxHealth == -1F

    @Suppress("KotlinConstantConditions")
    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        (playerMinHealth == -1F || player.health >= playerMinHealth) && (playerMaxHealth == -1F || player.health <= playerMaxHealth)
}