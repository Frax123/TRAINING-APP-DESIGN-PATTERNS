package app;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Orders.*;

public class ConcreteFacade extends Facade {
    private AppDataCenter appData;
    private AppDataManager appManager;
    private InformationDisplayer informator;
    private OrderFactory factory;
    private Config config;


    @Override
    void showMenu(){
        informator.showMenu();
    }


    public ConcreteFacade(AppDataCenter appData, AppDataManager appManager,
                          InformationDisplayer informator, OrderFactory factory, Config config){
        this.appData = appData;
        this.appManager = appManager;
        this.informator = informator;
        this.factory = factory;
        this.config = config;
    }

    @Override
    void processOrders() {
        String help;
        help = AppDataUploader.getNextLine();
        OrderExecutor.execute(factory.createOrder(help, appManager, informator, config), appData);
    }
}
