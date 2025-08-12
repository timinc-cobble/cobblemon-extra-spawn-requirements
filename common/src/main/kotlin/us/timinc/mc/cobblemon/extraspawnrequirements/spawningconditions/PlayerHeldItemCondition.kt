package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerHeldItemCondition : AbstractPlayerCondition() {
    val playerHeldItemMainHand: String = ""
    val playerHeldItemOffHand: String = ""

    @delegate:Transient
    val playerHeldItemMainHandResourceLocation: ResourceLocation by lazy { ResourceLocation.parse(playerHeldItemMainHand) }

    @delegate:Transient
    val playerHeldItemOffHandResourceLocation: ResourceLocation by lazy { ResourceLocation.parse(playerHeldItemOffHand) }

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = playerHeldItemMainHand == "" && playerHeldItemOffHand == ""

    @Suppress("KotlinConstantConditions")
    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        (playerHeldItemMainHand == "" || player.mainHandItem.itemHolder.`is`(playerHeldItemMainHandResourceLocation)) && (playerHeldItemOffHand == "" || player.offhandItem.itemHolder.`is`(
            playerHeldItemOffHandResourceLocation
        ))
}