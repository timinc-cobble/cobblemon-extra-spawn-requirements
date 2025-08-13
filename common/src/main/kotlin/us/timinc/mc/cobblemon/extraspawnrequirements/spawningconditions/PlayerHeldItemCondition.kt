package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition
import us.timinc.mc.cobblemon.extraspawnrequirements.matches

class PlayerHeldItemCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val playerHeldItemMainHand: String = ""

    @Suppress("MemberVisibilityCanBePrivate")
    val playerHeldItemOffHand: String = ""

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = playerHeldItemMainHand == "" && playerHeldItemOffHand == ""

    @Suppress("KotlinConstantConditions")
    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        (playerHeldItemMainHand == "" || player.mainHandItem.matches(playerHeldItemMainHand)) && (playerHeldItemOffHand == "" || player.offhandItem.matches(
            playerHeldItemOffHand
        ))
}