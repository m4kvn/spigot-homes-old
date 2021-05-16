package com.m4kvn.spigot.homes

import org.bukkit.Material
import org.bukkit.Sound
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld
import org.bukkit.entity.ArmorStand
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.Action
import org.bukkit.event.entity.CreatureSpawnEvent
import org.bukkit.event.player.PlayerInteractEvent
import org.bukkit.plugin.java.JavaPlugin

class Homes : JavaPlugin(), Listener {

    @EventHandler
    fun onPlayerInteract(event: PlayerInteractEvent) {
        if (event.action != Action.RIGHT_CLICK_BLOCK) return
        val itemStack = event.item ?: return
        if (itemStack.type != Material.WARPED_FUNGUS) return
        val itemMeta = itemStack.itemMeta ?: return
        if (itemMeta.hasDisplayName().not()) return
        val location = event.clickedBlock?.location ?: return

        if (event.player.inventory.itemInMainHand == itemStack) {
            val entity = CustomEntityArmorStand(location, event.player, itemMeta.displayName)
            val world = event.player.world as CraftWorld
            world.addEntity<ArmorStand>(entity, CreatureSpawnEvent.SpawnReason.CUSTOM)
            event.player.inventory.setItemInMainHand(null)
            world.playSound(location, Sound.BLOCK_STONE_BREAK, 1f, 1f)
            event.isCancelled = true
        }
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}