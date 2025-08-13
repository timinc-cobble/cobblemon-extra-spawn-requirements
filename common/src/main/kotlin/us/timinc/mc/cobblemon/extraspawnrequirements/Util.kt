package us.timinc.mc.cobblemon.extraspawnrequirements

import com.cobblemon.mod.common.util.server
import com.mojang.brigadier.StringReader
import net.minecraft.commands.arguments.item.ItemParser
import net.minecraft.world.item.ItemStack

object Util {
    private val parsedItemDescriptions: MutableMap<String, ItemParser.ItemResult> = mutableMapOf()

    private fun parseItemDescription(desc: String): ItemParser.ItemResult? {
        if (!parsedItemDescriptions.containsKey(desc)) {
            val server = server() ?: return null
            val parser = ItemParser(server.registryAccess())
            val result = parser.parse(StringReader(desc))

            parsedItemDescriptions[desc] = result
        }

        return parsedItemDescriptions[desc]
    }

    fun itemMatches(itemStack: ItemStack, matcher: String): Boolean {
        val result = parseItemDescription(matcher) ?: return false

        if (!itemStack.`is`(result.item)) return false

        for (entry in result.components.entrySet()) {
            val targetPropValue = itemStack.get(entry.key)
            if (targetPropValue != entry.value.get()) {
                return false
            }
        }

        return true
    }
}

fun ItemStack.matches(matcher: String): Boolean = Util.itemMatches(this, matcher)