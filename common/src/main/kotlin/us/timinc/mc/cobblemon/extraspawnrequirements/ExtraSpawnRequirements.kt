package us.timinc.mc.cobblemon.extraspawnrequirements

import com.cobblemon.mod.common.api.spawning.condition.AppendageCondition
import com.cobblemon.mod.common.api.spawning.condition.SpawningCondition
import com.cobblemon.mod.common.api.spawning.detail.SpawnDetail
import us.timinc.mc.cobblemon.extraspawnrequirements.spawning.condition.*
import us.timinc.mc.cobblemon.extraspawnrequirements.spawning.detail.LivingEntitySpawnDetail
import us.timinc.mc.cobblemon.timcore.AbstractConfig
import us.timinc.mc.cobblemon.timcore.AbstractMod

const val MOD_ID: String = "extra_spawn_requirements"

object ExtraSpawnRequirements :
    AbstractMod<ExtraSpawnRequirements.ExtraSpawnRequirementsConfig>(MOD_ID, ExtraSpawnRequirementsConfig::class.java) {

    class ExtraSpawnRequirementsConfig : AbstractConfig() {
    }

    init {
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerAdvancementCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerWonGameCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerExperienceLevelCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerIsFishingCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerPotionEffectCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerHealthCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerHungerCondition::class.java)
        AppendageCondition.registerAppendage(SpawningCondition::class.java, PlayerHeldItemCondition::class.java)
        SpawnDetail.registerSpawnType(LivingEntitySpawnDetail.TYPE, LivingEntitySpawnDetail::class.java)
    }
}