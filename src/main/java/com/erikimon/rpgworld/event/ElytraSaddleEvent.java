package com.erikimon.rpgworld.event;

import com.erikimon.rpgworld.item.custom.ElytrianSaddleItem;
import net.minecraft.world.entity.animal.horse.AbstractHorse;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.event.IModBusEvent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.EquipmentSlot;

import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;

public class ElytraSaddleEvent implements IModBusEvent {

    @SubscribeEvent
    public static void onSaddleInteract(PlayerInteractEvent.EntityInteract event) {
        LivingEntity entity = event.getEntity();
        ItemStack stack = event.getItemStack();

        // Verifica se o item é a nova sela
        if (stack.getItem() instanceof ElytrianSaddleItem) {
            // Verifica se o alvo é um cavalo e o cavalo pode usar a sela
            if (entity instanceof AbstractHorse horse && horse.canUseSlot(EquipmentSlot.CHEST)) {
                // Equipar a sela diretamente no cavalo
                horse.setItemSlot(EquipmentSlot.CHEST, stack.copy());
                stack.shrink(1);  // Reduz a quantidade do item usado
                event.setCanceled(true);  // Cancela o evento para evitar que a sela seja destruída após o uso
            }
        }
    }
}
