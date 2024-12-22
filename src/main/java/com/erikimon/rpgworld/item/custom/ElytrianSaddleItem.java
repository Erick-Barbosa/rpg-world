package com.erikimon.rpgworld.item.custom;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SaddleItem;

import org.jetbrains.annotations.Nullable;

public class ElytrianSaddleItem extends SaddleItem {

    public ElytrianSaddleItem(Properties properties) { super(properties); }

    @Override
    public boolean canElytraFly(ItemStack stack, LivingEntity entity) {
        return super.canElytraFly(stack, entity);
    }

    @Override
    public boolean canEquip(ItemStack stack, EquipmentSlot armorType, LivingEntity entity) {
        if (entity instanceof AbstractHorse) {
            AbstractHorse horse = (AbstractHorse) entity;
            boolean canEquip = horse.canUseSlot(EquipmentSlot.CHEST) && armorType == EquipmentSlot.CHEST;
            System.out.println("[DEBUG-RPGWORLD] Checking canEquip: stack={" + stack + "}, armorType={" + armorType + "}, entity={" + entity + "}, result={" + canEquip + "}");
            return canEquip;
        }
        return false;
    }

    @Override
    public @Nullable EquipmentSlot getEquipmentSlot(ItemStack stack) {
        return EquipmentSlot.CHEST;
    }
}
