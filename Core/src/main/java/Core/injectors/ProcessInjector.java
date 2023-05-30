package Core.injectors;

import Common.data.GameData;
import Common.data.World;
import Common.services.IEntityProcessingService;
import Common.util.SPILocator;
import org.springframework.stereotype.Service;
import java.util.List;

@Service("ProcessInjector")
public class ProcessInjector {

    private List<IEntityProcessingService> list;

    public ProcessInjector(){
        list = SPILocator.locateAll(IEntityProcessingService.class);
    }
    public void runAllProcesses(GameData gameData, World world) {
        for(IEntityProcessingService iGamePluginService : list){
            iGamePluginService.process(gameData,world);
        }
    }
}
