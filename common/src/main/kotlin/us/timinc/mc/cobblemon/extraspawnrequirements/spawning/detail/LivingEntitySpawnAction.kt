package us.timinc.mc.cobblemon.extraspawnrequirements.spawning.detail

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import com.cobblemon.mod.common.api.spawning.detail.SingleEntitySpawnAction
import net.minecraft.world.entity.EntityType
import net.minecraft.world.entity.LivingEntity
import us.timinc.mc.cobblemon.extraspawnrequirements.ExtraSpawnRequirements.debugger

class LivingEntitySpawnAction(ctx: SpawningContext, override val detail: LivingEntitySpawnDetail) :
    SingleEntitySpawnAction<LivingEntity>(ctx, detail) {
    override fun createEntity(): LivingEntity? {
        val entityType = EntityType.byString(detail.entity).orElse(null)
        if (entityType == null) {
            debugger.debug("LivingEntitySpawnAction run with invalid type ${detail.entity}")
            return null
        }
        val entity = entityType.create(ctx.world) as? LivingEntity ?: return null
        entity.moveTo(ctx.position.center)
        return entity
    }
}