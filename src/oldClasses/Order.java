package oldClasses;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;

public interface Order {
    String getOrderId();
    Strategy getProperStrategy(AppDataManager manager, InformationDisplayer informationDisplayer);
}
