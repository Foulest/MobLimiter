package net.foulest.moblimiter.util;

import net.foulest.moblimiter.MobLimiter;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;

public class Settings {

    public static File file;
    public static FileConfiguration config;

    public static void setupSettings() {
        file = new File(MobLimiter.instance.getDataFolder(), "settings.yml");

        if (!file.exists()) {
            try {
                file.getParentFile().mkdirs();
                file.createNewFile();
            } catch (IOException ex) {
                MessageUtil.log(Level.WARNING, "Couldn't create the config file.");
                ex.printStackTrace();
                return;
            }
        }

        config = YamlConfiguration.loadConfiguration(file);
        config.addDefault("enabled", true);
        config.addDefault("freeze-entities-at-half", true);
        config.addDefault("limits.tile-entities.total", 512);
        config.addDefault("limits.tile-entities.air", 256);
        config.addDefault("limits.tile-entities.banner", 256);
        config.addDefault("limits.tile-entities.beacon", 256);
        config.addDefault("limits.tile-entities.bell", 256);
        config.addDefault("limits.tile-entities.brewing_stand", 256);
        config.addDefault("limits.tile-entities.chest", 256);
        config.addDefault("limits.tile-entities.command_block", 256);
        config.addDefault("limits.tile-entities.conduit", 256);
        config.addDefault("limits.tile-entities.daylight_detector", 256);
        config.addDefault("limits.tile-entities.dispenser", 256);
        config.addDefault("limits.tile-entities.dropper", 256);
        config.addDefault("limits.tile-entities.enchantment_table", 256);
        config.addDefault("limits.tile-entities.ender_chest", 256);
        config.addDefault("limits.tile-entities.furnace", 256);
        config.addDefault("limits.tile-entities.hopper", 256);
        config.addDefault("limits.tile-entities.jukebox", 256);
        config.addDefault("limits.tile-entities.mob_spawner", 256);
        config.addDefault("limits.tile-entities.piston_moving_piece", 256);
        config.addDefault("limits.tile-entities.redstone_comparator_off", 256);
        config.addDefault("limits.tile-entities.redstone_comparator_on", 256);
        config.addDefault("limits.tile-entities.shulker_box", 256);
        config.addDefault("limits.tile-entities.sign", 256);

        config.addDefault("limits.entities.total", 256);
        config.addDefault("limits.entities.armor_stand", 64);
        config.addDefault("limits.entities.arrow", 64);
        config.addDefault("limits.entities.axolotl", 128);
        config.addDefault("limits.entities.bat", 128);
        config.addDefault("limits.entities.bee", 128);
        config.addDefault("limits.entities.blaze", 64);
        config.addDefault("limits.entities.boat", 64);
        config.addDefault("limits.entities.cat", 128);
        config.addDefault("limits.entities.cave_spider", 128);
        config.addDefault("limits.entities.chest_minecart", 64);
        config.addDefault("limits.entities.chicken", 128);
        config.addDefault("limits.entities.cod", 128);
        config.addDefault("limits.entities.command_block_minecart", 64);
        config.addDefault("limits.entities.cow", 128);
        config.addDefault("limits.entities.creeper", 128);
        config.addDefault("limits.entities.dolphin", 128);
        config.addDefault("limits.entities.donkey", 128);
        config.addDefault("limits.entities.dragon_fireball", 64);
        config.addDefault("limits.entities.drowned", 128);
        config.addDefault("limits.entities.egg", 64);
        config.addDefault("limits.entities.elder_guardian", 128);
        config.addDefault("limits.entities.enderman", 64);
        config.addDefault("limits.entities.endermite", 128);
        config.addDefault("limits.entities.ender_crystal", 64);
        config.addDefault("limits.entities.ender_dragon", 128);
        config.addDefault("limits.entities.ender_pearl", 64);
        config.addDefault("limits.entities.evoker", 128);
        config.addDefault("limits.entities.evoker_fangs", 64);
        config.addDefault("limits.entities.experience_bottle", 64);
        config.addDefault("limits.entities.experience_orb", 64);
        config.addDefault("limits.entities.eye_of_ender", 64);
        config.addDefault("limits.entities.falling_block", 128);
        config.addDefault("limits.entities.fireball", 64);
        config.addDefault("limits.entities.firework_rocket", 64);
        config.addDefault("limits.entities.fox", 128);
        config.addDefault("limits.entities.furnace_minecart", 64);
        config.addDefault("limits.entities.ghast", 64);
        config.addDefault("limits.entities.giant", 64);
        config.addDefault("limits.entities.glow_item_frame", 64);
        config.addDefault("limits.entities.glow_squid", 128);
        config.addDefault("limits.entities.goat", 128);
        config.addDefault("limits.entities.guardian", 128);
        config.addDefault("limits.entities.hoglin", 128);
        config.addDefault("limits.entities.hopper_minecart", 64);
        config.addDefault("limits.entities.horse", 128);
        config.addDefault("limits.entities.husk", 128);
        config.addDefault("limits.entities.illusioner", 128);
        config.addDefault("limits.entities.iron_golem", 64);
        config.addDefault("limits.entities.dropped_item", 128);
        config.addDefault("limits.entities.item_frame", 64);
        config.addDefault("limits.entities.leash_knot", 64);
        config.addDefault("limits.entities.lightning_bolt", 64);
        config.addDefault("limits.entities.llama", 128);
        config.addDefault("limits.entities.llama_spit", 64);
        config.addDefault("limits.entities.magma_cube", 128);
        config.addDefault("limits.entities.marker", 64);
        config.addDefault("limits.entities.minecart", 64);
        config.addDefault("limits.entities.mooshroom", 128);
        config.addDefault("limits.entities.mule", 128);
        config.addDefault("limits.entities.ocelot", 128);
        config.addDefault("limits.entities.painting", 64);
        config.addDefault("limits.entities.panda", 64);
        config.addDefault("limits.entities.parrot", 128);
        config.addDefault("limits.entities.phantom", 128);
        config.addDefault("limits.entities.pig", 128);
        config.addDefault("limits.entities.piglin", 128);
        config.addDefault("limits.entities.piglin_brute", 64);
        config.addDefault("limits.entities.pillager", 128);
        config.addDefault("limits.entities.polar_bear", 128);
        config.addDefault("limits.entities.potion", 64);
        config.addDefault("limits.entities.pufferfish", 128);
        config.addDefault("limits.entities.rabbit", 128);
        config.addDefault("limits.entities.ravager", 128);
        config.addDefault("limits.entities.salmon", 128);
        config.addDefault("limits.entities.sheep", 128);
        config.addDefault("limits.entities.shulker", 128);
        config.addDefault("limits.entities.shulker_bullet", 64);
        config.addDefault("limits.entities.silverfish", 128);
        config.addDefault("limits.entities.skeleton", 128);
        config.addDefault("limits.entities.skeleton_horse", 128);
        config.addDefault("limits.entities.slime", 128);
        config.addDefault("limits.entities.small_fireball", 64);
        config.addDefault("limits.entities.snowball", 64);
        config.addDefault("limits.entities.snowman", 64);
        config.addDefault("limits.entities.spawner_minecart", 32);
        config.addDefault("limits.entities.spectral_arrow", 64);
        config.addDefault("limits.entities.spider", 128);
        config.addDefault("limits.entities.squid", 128);
        config.addDefault("limits.entities.stray", 128);
        config.addDefault("limits.entities.strider", 128);
        config.addDefault("limits.entities.tnt", 64);
        config.addDefault("limits.entities.tnt_minecart", 32);
        config.addDefault("limits.entities.total", 256);
        config.addDefault("limits.entities.trader_llama", 128);
        config.addDefault("limits.entities.trident", 64);
        config.addDefault("limits.entities.tropical_fish", 128);
        config.addDefault("limits.entities.turtle", 128);
        config.addDefault("limits.entities.vex", 128);
        config.addDefault("limits.entities.villager", 128);
        config.addDefault("limits.entities.vindicator", 128);
        config.addDefault("limits.entities.wandering_trader", 128);
        config.addDefault("limits.entities.witch", 128);
        config.addDefault("limits.entities.wither", 128);
        config.addDefault("limits.entities.wither_skeleton", 128);
        config.addDefault("limits.entities.wither_skull", 64);
        config.addDefault("limits.entities.wolf", 128);
        config.addDefault("limits.entities.zoglin", 128);
        config.addDefault("limits.entities.zombie", 128);
        config.addDefault("limits.entities.zombie_horse", 128);
        config.addDefault("limits.entities.zombie_villager", 128);
        config.addDefault("limits.entities.zombified_piglin", 128);

        config.options().copyDefaults(true);

        try {
            config.save(file);
        } catch (IOException ex) {
            MessageUtil.log(Level.WARNING, "Couldn't save the config file.");
        }
    }

    public static void loadSettings() {
        config = YamlConfiguration.loadConfiguration(file);
    }

//    public static void saveSettings() {
//        config.set("maxPerChunk", maxPerChunk);
//
//        try {
//            config.save(file);
//        } catch (IOException ex) {
//            MessageUtil.log(Level.WARNING, "Couldn't save the config file.");
//        }
//    }
}
