package hibi.blahaj.mixinreplacement;

import hibi.blahaj.CuddlyItem;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.animal.allay.Allay;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber(Dist.CLIENT)
public class AllayEventListener {

	@SubscribeEvent
	public static void onEntityInteract(PlayerInteractEvent.EntityInteractSpecific event) {
		if (event.getTarget() instanceof Allay && event.getItemStack().getItem() instanceof CuddlyItem) {
			event.setCancellationResult(InteractionResult.SUCCESS);
			if (event.getEntity() instanceof LocalPlayer player) {
				player.sendSystemMessage(Component.translatable("response.blahaj.give_away"));
			}
			event.setCanceled(true);
		}
	}
}
