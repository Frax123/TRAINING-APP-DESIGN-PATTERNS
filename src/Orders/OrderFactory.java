package Orders;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;

public interface OrderFactory {
    Strategy createOrder(String name, AppDataManager manager, InformationDisplayer informationDisplayer, Config config);
}
