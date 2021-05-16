package com.m4kvn.spigot.homes

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
        val location = event.clickedBlock?.location ?: return
        val entity = CustomEntityArmorStand(location)
        val world = event.player.world as CraftWorld
        world.addEntity<ArmorStand>(entity, CreatureSpawnEvent.SpawnReason.CUSTOM)
    }

    override fun onEnable() {
        server.pluginManager.registerEvents(this, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}