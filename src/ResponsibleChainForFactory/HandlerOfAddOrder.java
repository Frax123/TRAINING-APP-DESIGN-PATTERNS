package ResponsibleChainForFactory;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;

public class HandlerOfAddOrder extends AbstractHandlerOfOrders{
    AbstractHandlerOfOrders next;

    public HandlerOfAddOrder(AbstractHandlerOfOrders _next){
        next = _next;
    }


    @Override
    public Strategy handle(String request, AppDataManager manager, InformationDisplayer informator) {
        if (request.equals("ADD")) {
            Config config = new Config();
            return config.getAddStrategy(manager, informator);
        } else {
            return next.handle(request, manager, informator);
        }
    }
}
