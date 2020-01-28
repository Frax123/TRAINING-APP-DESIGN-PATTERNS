package Configs;

import HelpClasses.AppDataManager;
import HelpClasses.FileOperationsExecutorConcrete;
import HelpClasses.InformationDisplayer;
import HelpClasses.StringInformator;
import Orders.ConcreteOrderFactory;
import ResponsibleChainForFactory.HandlerOfAddOrder;
import ResponsibleChainForFactory.HandlerOfDeleteOrder;
import ResponsibleChainForFactory.HandlerOfShowOrder;
import ResponsibleChainForFactory.HandlerOfUpdateOrder;
import ShowCommand.ConcreteShowCommand;
import ShowCommand.Presenter;
import ShowCommand.ShowExecutor;
import Strategies.AddStrategy;
import Strategies.Strategy;
import TrainingCoordinatorPackage.ConcreteTrainingCoordinator;
import app.AppDataCenter;
import app.ConcreteFacade;
import app.Facade;

public class Config {
    public Facade getFacade(){
        return new ConcreteFacade(AppDataCenter.getInstance(new ConcreteTrainingCoordinator(new FileOperationsExecutorConcrete(), new StringInformator())),
                new FileOperationsExecutorConcrete(),
                new StringInformator(), new ConcreteOrderFactory(), this);
    }

    public ShowExecutor getShowExecutor(){
        return new ShowExecutor(new Presenter(new ConcreteShowCommand()),
                new ConcreteTrainingCoordinator(new FileOperationsExecutorConcrete(), new StringInformator()));
    }

    public Strategy getAddStrategy(AppDataManager manager, InformationDisplayer informator){
        return new AddStrategy(manager, informator);
    }

    public HandlerOfAddOrder getHandlerOfAddOrder(){
        return new HandlerOfAddOrder(new HandlerOfDeleteOrder(new HandlerOfShowOrder(new HandlerOfUpdateOrder(null))));
    }

}
