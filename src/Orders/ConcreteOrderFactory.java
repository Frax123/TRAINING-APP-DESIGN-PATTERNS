package Orders;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.*;

public class ConcreteOrderFactory implements OrderFactory {
    public Strategy createOrder(String name, AppDataManager manager, InformationDisplayer informationDisplayer){
        if (name.equals("ADD")){
            return new AddStrategy(manager, informationDisplayer);
        } else if (name.equals("DELETE")){
            return new DeleteStrategy(manager, informationDisplayer);
        } else if (name.equals("SHOW")){
            return new ShowStrategy(informationDisplayer);
        } else if (name.equals("UPDATE")){
            return new UpdateStrategy();
        }
        return null;
    }
}
