package us.timinc.mc.cobblemon.extraspawnrequirements.spawning.detail

import com.cobblemon.mod.common.api.spawning.context.SpawningContext
import com.cobblemon.mod.common.api.spawning.detail.SingleEntitySpawnAction
import com.cobblemon.mod.common.api.spawning.detail.SpawnDetail
import net.minecraft.world.entity.LivingEntity

class LivingEntitySpawnDetail : SpawnDetail() {
    companion object {
        val TYPE = "living_entity"
    }

    override val type: String = TYPE
    var entity: String = ""

    override fun doSpawn(ctx: SpawningContext): SingleEntitySpawnAction<LivingEntity> {
        return LivingEntitySpawnAction(ctx, this)
    }

    override fun isValid(): Boolean {
        return super.isValid()
    }

    override fun isSatisfiedBy(ctx: SpawningContext): Boolean {
        return super.isSatisfiedBy(ctx)
    }
}