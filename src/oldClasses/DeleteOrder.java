package oldClasses;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.DeleteStrategy;
import Strategies.Strategy;

public class DeleteOrder implements Order {
    @Override
    public String getOrderId() {
        return "DELETE";
    }

    @Override
    public Strategy getProperStrategy(AppDataManager manager, InformationDisplayer informationDisplayer) {
        Strategy result = new DeleteStrategy(manager, informationDisplayer);
        return result;
    }
}
