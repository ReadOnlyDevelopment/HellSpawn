package net.romvoid95.hellspawn.events;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.stats.Stats;
import net.minecraft.util.math.BlockPos;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.romvoid95.hellspawn.SpawnHelper;

@Mod.EventBusSubscriber(modid = "hellspawn", bus = Mod.EventBusSubscriber.Bus.FORGE)
public class PlayerEvents {

	@SubscribeEvent
	public static void playerLoggedInEvent(PlayerEvent.PlayerLoggedInEvent event) {
		PlayerEntity		player			= event.getPlayer();
		ServerPlayerEntity	serverPlayer	= (ServerPlayerEntity) player;

		int timePlayed = serverPlayer.getStats().getValue(Stats.CUSTOM.get(Stats.PLAY_ONE_MINUTE));

		if (timePlayed == 0) {
			SpawnHelper.respawnInNether(player);
		}
	}

	@SubscribeEvent
	public static void playerRespawnEvent(PlayerEvent.PlayerRespawnEvent event) {
		PlayerEntity		player			= event.getPlayer();
		ServerPlayerEntity	serverPlayer	= (ServerPlayerEntity) player;

		BlockPos respawnPos = serverPlayer.getRespawnPosition();

		if (respawnPos == null) {
			SpawnHelper.respawnInNether(player);
		}
	}
}
