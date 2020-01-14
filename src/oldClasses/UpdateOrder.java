package oldClasses;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;
import Strategies.UpdateStrategy;

public class UpdateOrder implements Order {
    @Override
    public String getOrderId() {
        return "UPDATE";
    }

    @Override
    public Strategy getProperStrategy(AppDataManager manager, InformationDisplayer informationDisplayer) {
        Strategy result = new UpdateStrategy();
        return result;
    }
}
