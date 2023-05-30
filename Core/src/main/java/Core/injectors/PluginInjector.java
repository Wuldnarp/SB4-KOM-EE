package Core.injectors;

import Common.data.GameData;
import Common.data.World;
import Common.services.IGamePluginService;
import Common.util.SPILocator;
import java.util.List;
import org.springframework.stereotype.Service;

@Service("PluginInjector")
public class PluginInjector {

    private List<IGamePluginService> list;

    public PluginInjector(){
        list = SPILocator.locateAll(IGamePluginService.class);
    }

    public void runPlugins(GameData gameData, World world){
        for(IGamePluginService iGamePluginService : list){
            iGamePluginService.start(gameData,world);
        }
    }
}
