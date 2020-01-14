package oldClasses;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.AddStrategy;
import Strategies.Strategy;

public class AddOrder implements Order {

    @Override
    public String getOrderId() {
        return "ADD";
    }

    @Override
    public Strategy getProperStrategy(AppDataManager manager, InformationDisplayer informationDisplayer) {
        Strategy result = new AddStrategy(manager, informationDisplayer);
        return result;
    }
}
