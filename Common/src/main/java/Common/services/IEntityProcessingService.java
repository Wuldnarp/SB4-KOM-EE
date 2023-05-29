package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IEntityProcessingService {

    /**
     * Actions for every game tick that is required to run in the game loop.
     * @param gameData Logic for the game, ex: delta time and events.
     * @param world A map for entities in the game.
     * @Pre-condition: A cycle has happened.
     * @Post-condition: Actions described in this cycle, have taken effect before the next.
     */
    void process(GameData gameData, World world);
}
