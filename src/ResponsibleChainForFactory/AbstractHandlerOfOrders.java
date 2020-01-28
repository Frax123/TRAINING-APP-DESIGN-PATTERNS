package ResponsibleChainForFactory;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.Strategy;

abstract public class AbstractHandlerOfOrders {
    AbstractHandlerOfOrders next;
    abstract public Strategy handle(String request, AppDataManager manager, InformationDisplayer informator);
    void setNext(AbstractHandlerOfOrders _next){
        this.next = _next;
    }
}