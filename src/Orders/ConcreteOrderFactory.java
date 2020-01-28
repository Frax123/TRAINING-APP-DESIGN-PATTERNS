package Orders;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import ResponsibleChainForFactory.*;
import Strategies.*;

public class ConcreteOrderFactory implements OrderFactory {
    public Strategy createOrder(String name, AppDataManager manager, InformationDisplayer informationDisplayer, Config config){
        //Config config = new Config();
        AbstractHandlerOfOrders handler = config.getHandlerOfAddOrder();
        if (handler == null){
            return null;
        }
        return handler.handle(name, manager, informationDisplayer);
    }
}
