package Common.services;

import Common.data.GameData;
import Common.data.World;

public interface IGameBulletPluginService extends IGamePluginService {

    void shot(float radians, float posX, float posY, GameData gameData, World world);
}
