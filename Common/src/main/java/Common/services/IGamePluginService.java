package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IGamePluginService {

    /**
     * The entry point for an entity.
     * @param gameData Logic for the game, ex: delta time and events.
     * @param world A map for entities in the game.
     * @Pre-condition: Called at the beginning of the entity's lifecycle.
     * @Post-condition: Entities added to the world map, will be considered valid entities.
     */
    void start(GameData gameData, World world);

    /**
     * deletion of the entity
     * @param gameData Logic for the game, ex: delta time and events.
     * @param world A map for entities in the game.
     * @Pre-condition: Called at the end of the entity's lifecycle.
     * @Post-condition: Entities removed from the world map, will no longer be shown and acted upon.
     */
    void stop(GameData gameData, World world);
}
