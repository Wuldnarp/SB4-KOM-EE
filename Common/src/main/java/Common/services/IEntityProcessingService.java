package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IEntityProcessingService {

    /**
     * Actions for every game tick that is required to run in the game loop.
     * @param gameData logic for the game, ex: delta time and events.
     * @param world map for entities in the game.
     * @Pre-condition: a cycle has happened.
     * @Post-condition: actions described in this cycle, has taken effect before the next.
     */
    void process(GameData gameData, World world);
}
