package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IGameBulletPluginService extends IGamePluginService {

    /**
     * Replaces the create method for a bullet, as they need more information for spawning.
     * @param radians The angle the bullet has to travel at.
     * @param posX It's starting x position.
     * @param posY It's starting y position.
     * @param gameData Logic for the game, ex: delta time and events.
     * @param world A map for entities in the game.
     * @Pre-condition: A game entity wants to shoot.
     * @Post-condition: The bullet has spawned in the right place with the right angle.
     */
    void shoot(float radians, float posX, float posY, GameData gameData, World world);
}
