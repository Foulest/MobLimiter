package net.foulest.moblimiter.listeners;

import com.destroystokyo.paper.event.block.TNTPrimeEvent;
import com.destroystokyo.paper.event.entity.*;
import io.papermc.paper.event.entity.*;
import io.papermc.paper.event.player.*;
import net.foulest.moblimiter.util.EvictingList;
import net.foulest.moblimiter.util.MessageUtil;
import net.foulest.moblimiter.util.Settings;
import org.bukkit.Chunk;
import org.bukkit.Material;
import org.bukkit.block.BlockState;
import org.bukkit.entity.*;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.*;
import org.bukkit.event.entity.*;
import org.bukkit.event.player.*;
import org.bukkit.event.raid.RaidTriggerEvent;
import org.bukkit.event.vehicle.VehicleCreateEvent;
import org.bukkit.event.vehicle.VehicleEnterEvent;
import org.bukkit.event.vehicle.VehicleEntityCollisionEvent;
import org.bukkit.event.world.ChunkLoadEvent;
import org.bukkit.event.world.StructureGrowEvent;
import org.spigotmc.event.entity.EntityMountEvent;

import java.util.*;
import java.util.logging.Level;

public class EventListener implements Listener {

    public static boolean cleaning = false;
    public static List<Chunk> frozenChunksEntity = new ArrayList<>();
    public static List<Chunk> frozenChunksTileEntity = new ArrayList<>();
    public static Map<Player, Chunk> lastCheckedPlayerChunks = new HashMap<>();
    public static EvictingList<Chunk> lastCheckedMobChunks = new EvictingList<>(10);

    @EventHandler
    public static void onEvent(ChunkLoadEvent event) {
        Chunk chunk = event.getChunk();

        // Check chunk on chunk load.
        checkChunk(chunk, event.getEventName(), true, true);
    }

    @EventHandler
    public static void onEvent(WitchThrowPotionEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(WitchReadyPotionEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(WitchConsumePotionEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(VillagerReplenishTradeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(VillagerCareerChangeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(VillagerAcquireTradeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(VehicleEntityCollisionEvent event) {
        Chunk chunk = event.getVehicle().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(VehicleEnterEvent event) {
        Chunk chunk = event.getVehicle().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(ProjectileLaunchEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        checkChunk(chunk, event.getEventName(), true, false);

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(VehicleCreateEvent event) {
        Chunk chunk = event.getVehicle().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        checkChunk(chunk, event.getEventName(), true, false);

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(TurtleStartDiggingEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(TurtleLayEggEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(TurtleGoHomeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(ThrownEggHatchEvent event) {
        Chunk chunk = event.getEgg().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setHatching(false);
        }
    }

    @EventHandler
    public static void onEvent(TNTPrimeEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(StructureGrowEvent event) {
        Chunk chunk = event.getLocation().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(SlimeSplitEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(SlimePathfindEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(SignChangeEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's tile entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(RaidTriggerEvent event) {
        Chunk chunk = event.getRaid().getLocation().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(PlayerShearEntityEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerPurchaseEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerNameEntityEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerLecternPageChangeEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerLeashEntityEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerItemFrameChangeEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerChangeBeaconEffectEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's tile entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerSignCommandPreprocessEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's tile entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PlayerTakeLecternBookEvent event) {
        Chunk chunk = event.getPlayer().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's tile entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PufferFishStateChangeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(PlayerBedEnterEvent event) {
        Chunk chunk = event.getBed().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
            MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's tile entity limit.");
        }
    }

    @EventHandler
    public static void onEvent(PigZombieAngerEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(PiglinBarterEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(NotePlayEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(FireworkExplodeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EnderDragonShootFireballEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EnderDragonFireballHitEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EnderDragonChangePhaseEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EnderDragonFlameEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EndermanAttackPlayerEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(ElderGuardianAppearanceEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(ExplosionPrimeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(ExpBottleEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(CreeperPowerEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(CreeperIgniteEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(BlockBreakEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, true);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }
    }

    @EventHandler
    public static void onEvent(BlockPlaceEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, true);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            String material = event.getBlock().getType().name().toLowerCase();

            if (material.contains("banner") || material.contains("beacon") || material.contains("bell")
                    || material.contains("brewing_stand") || material.contains("chest")
                    || material.contains("command_block") || material.contains("conduit")
                    || material.contains("daylight_detector") || material.contains("dispenser")
                    || material.contains("dropper") || material.contains("enchantment_table")
                    || material.contains("ender_chest") || material.contains("furnace")
                    || material.contains("hopper") || material.contains("jukebox")
                    || material.contains("mob_spawner") || material.contains("redstone_comparator")
                    || material.contains("shulker_box") || material.contains("sign") || material.contains("beehive")
                    || material.contains("bee_nest") || material.contains("barrel") || material.contains("smoker")
                    || material.contains("campfire") || material.contains("lectern") || material.contains("bed")) {
                event.setCancelled(true);
                MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's tile entity limit.");
            }
        }
    }

    @EventHandler
    public static void onEvent(BlockPistonExtendEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(BlockPhysicsEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(BlockIgniteEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(BlockExplodeEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(BlockDispenseEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(BlockRedstoneEvent event) {
        Chunk chunk = event.getBlock().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setNewCurrent(0);
        }
    }

    @EventHandler
    public static void onEvent(BatToggleSleepEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityTransformEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityTameEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntitySpellCastEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityShootBowEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!(event.getEntity() instanceof Player)) {
            if (!lastCheckedMobChunks.contains(chunk)) {
                checkChunk(chunk, event.getEventName(), true, false);
                lastCheckedMobChunks.add(chunk);
            }

            // Cancel event if chunk is frozen.
            if (frozenChunksEntity.contains(chunk)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public static void onEvent(EntityPickupItemEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!(event.getEntity() instanceof Player)) {
            if (!lastCheckedMobChunks.contains(chunk)) {
                checkChunk(chunk, event.getEventName(), true, false);
                lastCheckedMobChunks.add(chunk);
            }

            // Cancel event if chunk is frozen.
            if (frozenChunksEntity.contains(chunk)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public static void onEvent(EntityPlaceEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);

            if (event.getPlayer() != null) {
                MessageUtil.messagePlayer(event.getPlayer(), "&cThis chunk has reached it's entity limit.");
            }
        }
    }

    @EventHandler
    public static void onEvent(EntityMountEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityLoadCrossbowEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!(event.getEntity() instanceof Player)) {
            if (!lastCheckedMobChunks.contains(chunk)) {
                checkChunk(chunk, event.getEventName(), true, false);
                lastCheckedMobChunks.add(chunk);
            }

            // Cancel event if chunk is frozen.
            if (frozenChunksEntity.contains(chunk)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public static void onEvent(EntityInsideBlockEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk) || frozenChunksTileEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityExplodeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityEnterBlockEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityChangeBlockEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityDyeEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunk) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityBreedEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }

        // Cancel event if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(EntityTeleportEvent event) {
        Chunk chunkTo = Objects.requireNonNull(event.getTo()).getChunk();
        Chunk chunkFrom = event.getFrom().getChunk();

        // Returns if chunk not loaded.
        if (!chunkTo.isLoaded() || !chunkFrom.isLoaded()) {
            return;
        }

        // Cancel if entity is moving to a frozen chunk.
        // Check chunk if entity is moving from a frozen chunk.
        if (!(event.getEntity() instanceof Player)) {
            if (frozenChunksEntity.contains(chunkTo)) {
                event.setCancelled(true);

            } else if (frozenChunksEntity.contains(chunkFrom)) {
                if (!lastCheckedMobChunks.contains(chunkTo)) {
                    checkChunk(chunkTo, event.getEventName(), true, false);
                    lastCheckedMobChunks.add(chunkTo);
                }

                if (!lastCheckedMobChunks.contains(chunkFrom)) {
                    checkChunk(chunkFrom, event.getEventName(), true, false);
                    lastCheckedMobChunks.add(chunkFrom);
                }
            }
        }
    }

    @EventHandler
    public static void onEvent(EntitySpawnEvent event) {
        Chunk chunk = event.getLocation().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!(event.getEntity() instanceof Player) && !(event.getEntity() instanceof Item)) {
            if (!lastCheckedMobChunks.contains(chunk)) {
                checkChunk(chunk, event.getEventName(), true, false);
                lastCheckedMobChunks.add(chunk);
            }

            // Cancel event if chunk is frozen.
            if (frozenChunksEntity.contains(chunk)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public static void onEvent(EntityPathfindEvent event) {
        Chunk chunk = event.getLoc().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Cancel if chunk is frozen.
        if (frozenChunksEntity.contains(chunk)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public static void onEvent(PlayerMoveEvent event) {
        Chunk chunkTo = event.getTo().getChunk();
        Chunk chunkFrom = event.getFrom().getChunk();

        // Returns if chunk is not loaded, both the same, or a duplicate.
        if (!chunkTo.isLoaded() || !chunkFrom.isLoaded() || chunkTo == chunkFrom) {
            return;
        }

        // Check chunks on event.
        if (lastCheckedPlayerChunks.get(event.getPlayer()) != chunkTo) {
            checkChunk(chunkTo, event.getEventName(), true, true);
            lastCheckedPlayerChunks.put(event.getPlayer(), chunkTo);
        }
    }

    @EventHandler
    public static void onEvent(EntityMoveEvent event) {
        Chunk chunkTo = event.getTo().getChunk();
        Chunk chunkFrom = event.getFrom().getChunk();

        // Returns if chunk not loaded.
        if (!chunkTo.isLoaded() || !chunkFrom.isLoaded()) {
            return;
        }

        // Check chunks on event.
        if (chunkTo != chunkFrom) {
            if (!lastCheckedMobChunks.contains(chunkTo)) {
                checkChunk(chunkTo, event.getEventName(), true, false);
                lastCheckedMobChunks.add(chunkTo);
            }

            if (!lastCheckedMobChunks.contains(chunkFrom)) {
                checkChunk(chunkFrom, event.getEventName(), true, false);
                lastCheckedMobChunks.add(chunkFrom);
            }
        }

        // Cancel if chunk is frozen.
        if (!event.getEntity().fromMobSpawner()) {
            if (frozenChunksEntity.contains(chunkTo)) {
                event.setCancelled(true);
            }
        }
    }

    @EventHandler
    public static void onEvent(EntityDeathEvent event) {
        Chunk chunk = event.getEntity().getChunk();

        // Returns if chunk not loaded.
        if (!chunk.isLoaded()) {
            return;
        }

        // Check chunk on event.
        if (!lastCheckedMobChunks.contains(chunk)) {
            checkChunk(chunk, event.getEventName(), true, false);
            lastCheckedMobChunks.add(chunk);
        }
    }

    public static void checkChunk(Chunk chunk, String eventName, boolean entity, boolean tileEntity) {
        if (entity) {
            checkEntities(chunk, eventName);
        }

        if (tileEntity) {
            checkTileEntities(chunk, eventName);
        }
    }

    public static void checkEntities(Chunk chunk, String eventName) {
        // Returns if chunk has too few entities.
        if (chunk.getEntities().length <= 20) {
            return;
        }

        long now = System.currentTimeMillis();
        int totalEntityCount = chunk.getEntities().length;
        int totalEntityLimit = Settings.config.getInt("limits.entities.total");

        // Cleans up entities if the limit is reached.
        if (totalEntityCount >= totalEntityLimit && !cleaning) {
            cleaning = true;

            for (Entity entity : chunk.getEntities()) {
                if (entity instanceof Player || entity.customName() != null) {
                    continue;
                }

                entity.remove();
            }

            frozenChunksEntity.remove(chunk);
            cleaning = false;
            return;
        }

        List<Entity> entities = Arrays.stream(chunk.getEntities()).distinct().toList();
        List<EntityType> entityTypes = Arrays.stream(chunk.getEntities()).map(Entity::getType).toList();

        // Checks if entities are overloaded.
        for (Entity entity : entities) {
            if (entity instanceof Player) {
                continue;
            }

            String entityName = entity.getType().name().toLowerCase();
            int entityCount = Collections.frequency(entityTypes, entity.getType());
            int entityLimit = Settings.config.getInt("limits.entities." + entityName);

            // Freeze chunk if the limit is 50% met.
            if (entityCount * 2 >= entityLimit) {
                if (Settings.config.getBoolean("freeze-entities-at-half")) {
                    frozenChunksEntity.add(chunk);
                }

                // Purge entities in chunk if the limit is 100% met.
                if (entityCount >= entityLimit && !cleaning) {
                    cleaning = true;

                    for (Entity badEntity : chunk.getEntities()) {
                        if (badEntity.getType() == entity.getType()) {
                            if (badEntity.customName() == null) {
                                badEntity.remove();
                            }
                        }
                    }

                    frozenChunksEntity.remove(chunk);
                    cleaning = false;
                    break;
                }

            } else {
                frozenChunksEntity.remove(chunk);
            }
        }

        MessageUtil.log(Level.INFO, eventName + " - E: " + chunk.getEntities().length + " - MS: " + (System.currentTimeMillis() - now));
    }

    public static void checkTileEntities(Chunk chunk, String eventName) {
        // Returns if chunk has too few tile entities.
        if (chunk.getTileEntities().length <= 20) {
            return;
        }

        long now = System.currentTimeMillis();
        int totalTileEntityCount = chunk.getTileEntities().length;
        int totalTileEntityLimit = Settings.config.getInt("limits.tile-entities.total");
        List<BlockState> tileEntities = Arrays.stream(chunk.getTileEntities()).distinct().toList();
        List<Material> tileEntityTypes = Arrays.stream(chunk.getTileEntities()).map(BlockState::getType).toList();

        // Checks if tile entities are overloaded.
        for (BlockState tileEntity : tileEntities) {
            if (tileEntity instanceof Player) {
                continue;
            }

            String tileEntityName = tileEntity.getType().name().toLowerCase();
            int tileEntityCount = Collections.frequency(tileEntityTypes, tileEntity.getType());
            int tileEntityLimit = Settings.config.getInt("limits.tile-entities." + tileEntityName);

            // Freeze chunk if the limit is met.
            if ((tileEntityCount >= tileEntityLimit || totalTileEntityCount >= totalTileEntityLimit)
                    && Settings.config.getBoolean("freeze-entities-at-half")) {
                frozenChunksTileEntity.add(chunk);
            } else {
                frozenChunksTileEntity.remove(chunk);
            }
        }

        MessageUtil.log(Level.WARNING, eventName + " - E: " + chunk.getEntities().length + " - MS: " + (System.currentTimeMillis() - now));
    }
}
