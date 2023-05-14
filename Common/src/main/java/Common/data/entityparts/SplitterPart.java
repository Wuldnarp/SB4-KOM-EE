package Common.data.entityparts;

import Common.data.Entity;
import Common.data.GameData;

public class SplitterPart implements EntityPart{
    boolean shouldSplit = false;

    @Override
    public void process(GameData gameData, Entity entity) {

    }

    public boolean ShouldSplit() {
        return shouldSplit;
    }

    public void setShouldSplit(boolean shouldSplit) {
        this.shouldSplit = shouldSplit;
    }
}
