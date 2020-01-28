package Strategies;

import Configs.Config;
import HelpClasses.AppDataManager;
import HelpClasses.FileOperationsExecutorConcrete;
import HelpClasses.InformationDisplayer;
import HelpClasses.StringInformator;
import ShowCommand.*;
import ShowCommand.Presenter;
import ShowCommand.ShowCommand;
import TrainingCoordinatorPackage.ConcreteTrainingCoordinator;
import app.AppDataCenter;

public class ShowStrategy implements Strategy {
    InformationDisplayer informator;

    public ShowStrategy(InformationDisplayer _informator){
        this.informator = _informator;
    }

    @Override
    public void printWelcomeInfo() {
        informator.printWelcomeToShowOrder();
    }

    @Override
    public void doEverythingConnectedToGivenOrder(AppDataCenter appData, String nameOfTraining) {
        Config myConfig = new Config();
        myConfig.getShowExecutor().execute();
    }

    @Override
    public boolean checkIfOrderIsPossibleAndShowOptionalInformation(AppDataCenter appData, String trainingName) {
        while (!appData.AllTrainings.trainingExists(trainingName)){
            informator.printTrainingDoesntExistInfo();
            return false;
        }
        return true;
    }
}
