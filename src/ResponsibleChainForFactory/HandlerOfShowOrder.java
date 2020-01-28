package ResponsibleChainForFactory;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;

public class HandlerOfShowOrder extends AbstractHandlerOfOrders{
    AbstractHandlerOfOrders next;

    public HandlerOfShowOrder(AbstractHandlerOfOrders _next){
        next = _next;
    }

    @Override
    public Strategy handle(String request, AppDataManager manager, InformationDisplayer informator) {
        if (request.equals("SHOW")) {
            Config config = new Config();
            return config.getAddStrategy(manager, informator);
        } else {
            return next.handle(request, manager, informator);
        }
    }
}