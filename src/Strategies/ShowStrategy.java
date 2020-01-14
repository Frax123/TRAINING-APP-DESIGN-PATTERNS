package Strategies;

import HelpClasses.InformationDisplayer;
import HelpClasses.StringInformator;
import ShowCommand.*;
import ShowCommand.Presenter;
import ShowCommand.ShowCommand;
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
        ShowCommand show = new ConcreteShowCommand();
        Presenter presenter = new Presenter(show);
        presenter.doTheJob(informator);
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
