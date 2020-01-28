package ResponsibleChainForFactory;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;

public class HandlerOfUpdateOrder extends AbstractHandlerOfOrders{
    AbstractHandlerOfOrders next;

    public HandlerOfUpdateOrder(AbstractHandlerOfOrders _next){
        next = _next;
    }

    @Override
    public Strategy handle(String request, AppDataManager manager, InformationDisplayer informator) {
        if (request.equals("UPDATE")) {
            Config config = new Config();
            return config.getAddStrategy(manager, informator);
        } else {
            return null;
        }
    }
}