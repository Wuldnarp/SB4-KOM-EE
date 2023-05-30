package Core.injectors;

import Common.data.GameData;
import Common.data.World;
import Common.services.IEntityProcessingService;
import Common.util.SPILocator;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service("ProcessInjector")
public class ProcessInjector {
    public void runAllProcesses(GameData gameData, World world) {
        boolean firstTime = true;
        List<IEntityProcessingService> list = new LinkedList<>();
        if (firstTime){
             list = SPILocator.locateAll(IEntityProcessingService.class);
             firstTime = false;
        }
        for(IEntityProcessingService iGamePluginService : list){
            iGamePluginService.process(gameData,world);
        }
    }
}
