package Core.injectors;

import Common.data.GameData;
import Common.data.World;
import Common.services.IEntityProcessingService;
import Common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("ProcessInjector")
public class ProcessInjector {
    public void runAllProcesses(GameData gameData, World world) {
        List<IEntityProcessingService> list = SPILocator.locateAll(IEntityProcessingService.class);
        for(IEntityProcessingService iGamePluginService : list){
            iGamePluginService.process(gameData,world);
        }
    }
}
