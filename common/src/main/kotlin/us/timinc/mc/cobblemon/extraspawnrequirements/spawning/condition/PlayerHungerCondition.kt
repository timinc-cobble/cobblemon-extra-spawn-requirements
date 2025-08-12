package us.timinc.mc.cobblemon.extraspawnrequirements.spawning.condition

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerHungerCondition : AbstractPlayerCondition() {
    val playerMinHunger = -1
    val playerMaxHunger = -1

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = playerMinHunger == -1 && playerMaxHunger == -1

    @Suppress("KotlinConstantConditions")
    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        (playerMinHunger == -1 || player.foodData.foodLevel >= playerMinHunger) && (playerMaxHunger == -1 || player.foodData.foodLevel <= playerMaxHunger)
}