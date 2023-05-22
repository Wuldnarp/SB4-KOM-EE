package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IGamePluginService {

    /**
     * entry point for an entity
     * @param gameData logic for the game, ex: delta time and events.
     * @param world map for entities in the game.
     * @Pre-condition: Called in the beginning of the game.
     * @Post-condition: Entities added to the world map, wil be considered valid entities.
     */
    void start(GameData gameData, World world);

    /**
     * deletion of the entity
     * @param gameData logic for the game, ex: delta time and events.
     * @param world map for entities in the game.
     * @Pre-condition: Called when the entity has to be removed from the game.
     * @Post-condition: Entities removed for the world, will no longer be shown and acted upon.
     */
    void stop(GameData gameData, World world);
}
