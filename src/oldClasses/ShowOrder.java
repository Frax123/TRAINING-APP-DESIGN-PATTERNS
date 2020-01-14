package oldClasses;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Strategies.ShowStrategy;
import Strategies.Strategy;

public class ShowOrder implements Order {
    @Override
    public String getOrderId() {
        return "SHOW";
    }

    @Override
    public Strategy getProperStrategy(AppDataManager manager, InformationDisplayer informationDisplayer) {
       Strategy result = new ShowStrategy(informationDisplayer);
       return result;
    }
}
