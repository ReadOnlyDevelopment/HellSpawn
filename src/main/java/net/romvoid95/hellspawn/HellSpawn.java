package net.romvoid95.hellspawn;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;

@Mod("hellspawn")
public class HellSpawn {
	public static final Logger LOGGER = LogManager.getLogger();

	public HellSpawn() {
		MinecraftForge.EVENT_BUS.register(this);
	}
}
