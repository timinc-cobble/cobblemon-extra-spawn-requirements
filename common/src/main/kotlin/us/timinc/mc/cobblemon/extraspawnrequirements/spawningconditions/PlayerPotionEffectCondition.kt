package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerPotionEffectCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val playerPotionEffect: String = ""
    @Suppress("MemberVisibilityCanBePrivate")
    val playerPotionEffectMinLevel: Int = -1
    @Suppress("MemberVisibilityCanBePrivate")
    val playerPotionEffectMaxLevel: Int = -1

    @delegate:Transient
    val playerPotionEffectResourceLocation: ResourceLocation by lazy {
        ResourceLocation.parse(playerPotionEffect)
    }

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean =
        playerPotionEffect == "" && playerPotionEffectMaxLevel == -1 && playerPotionEffectMinLevel == -1

    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        player.activeEffects.any {
            @Suppress("KotlinConstantConditions")
            it.effect.`is`(playerPotionEffectResourceLocation) && ((playerPotionEffectMinLevel == -1 || it.amplifier >= playerPotionEffectMinLevel) && (playerPotionEffectMaxLevel == -1 || it.amplifier <= playerPotionEffectMaxLevel))
        }
}