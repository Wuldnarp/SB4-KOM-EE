package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IEntityProcessingService {

    /**
     * @
     * @param gameData
     * @param world
     */
    void process(GameData gameData, World world);
}
