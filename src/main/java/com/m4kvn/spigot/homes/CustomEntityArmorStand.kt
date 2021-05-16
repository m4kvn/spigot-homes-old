package com.m4kvn.spigot.homes

import net.minecraft.server.v1_16_R3.*
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_16_R3.CraftWorld
import org.bukkit.entity.Player

class CustomEntityArmorStand(location: Location, player: Player, name: String) :
    EntityArmorStand(EntityTypes.ARMOR_STAND, (location.world as CraftWorld).handle) {

    init {
        setPosition(location.x + 0.5, location.y + 2, location.z + 0.5)
        setArms(false)
        setBasePlate(true)
        isNoGravity = true
        isInvisible = true
        isInvulnerable = true
        isMarker = true
        isSmall = true
        collides = false

        super.setCustomName(ChatComponentText("${player.name}'s $name"))
        super.setCustomNameVisible(true)
    }

    override fun die() {}
    override fun inactiveTick() {}
    override fun setCustomName(ichatbasecomponent: IChatBaseComponent?) {}
    override fun setCustomNameVisible(flag: Boolean) {}
    override fun isCollidable(): Boolean = false
    override fun isInvulnerable(): Boolean = true
    override fun loadData(nbttagcompound: NBTTagCompound?) {}
    override fun saveData(nbttagcompound: NBTTagCompound?) {}
    override fun setSlot(enumitemslot: EnumItemSlot?, itemstack: ItemStack?) {}
    override fun setSlot(enumitemslot: EnumItemSlot?, itemstack: ItemStack?, silent: Boolean) {}
    override fun a_(nbttagcompound: NBTTagCompound?): Boolean = false
    override fun d(nbttagcompound: NBTTagCompound?): Boolean = false
    override fun a(axisalignedbb: AxisAlignedBB?) {}
    override fun a_(i: Int, itemstack: ItemStack?): Boolean = false
    override fun a(entityhuman: EntityHuman?, vec3d: Vec3D?, enumhand: EnumHand?): EnumInteractionResult =
        EnumInteractionResult.PASS
}