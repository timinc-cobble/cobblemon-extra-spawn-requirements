package us.timinc.mc.cobblemon.extraspawnrequirements.spawningconditions

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import net.minecraft.resources.ResourceLocation
import net.minecraft.server.level.ServerPlayer
import us.timinc.mc.cobblemon.extraspawnrequirements.api.spawningconditions.AbstractPlayerCondition

class PlayerAdvancementCondition : AbstractPlayerCondition() {
    @Suppress("MemberVisibilityCanBePrivate")
    val playerAdvancement: String = ""

    @delegate:Transient
    val requiredAdvancementResourceLocation: ResourceLocation by lazy {
        ResourceLocation.parse(playerAdvancement)
    }

    @Suppress("KotlinConstantConditions")
    override fun matchesAll(): Boolean = playerAdvancement == ""

    override fun matchesPlayer(player: ServerPlayer, ctx: SpawningContext): Boolean =
        player.advancements.progress.any { (k, v) -> k.id == requiredAdvancementResourceLocation && v.isDone }
}