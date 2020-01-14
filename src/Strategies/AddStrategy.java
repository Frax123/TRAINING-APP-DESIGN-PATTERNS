package Strategies;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import app.AppDataCenter;
import HelpClasses.StringInformator;

public class AddStrategy implements Strategy {
    AppDataManager manager;
    InformationDisplayer informator;

    public AddStrategy(AppDataManager _manager, InformationDisplayer _informator){
        manager = _manager;
        informator = _informator;
    }

    @Override
    public void printWelcomeInfo() {
        informator.printInfoAboutNewTrainingName();
    }

    @Override
    public void doEverythingConnectedToGivenOrder(AppDataCenter appData, String nameOfTraining) {
        modifyTrainingsData(appData, nameOfTraining);
        modifyTrainingsDetails(appData, nameOfTraining);
        doOtherNeededThings(nameOfTraining);
    }


    public void modifyTrainingsData(AppDataCenter data, String nameOfTraining) {
        manager.addTrainingData(nameOfTraining);
        data.AllTrainings.addTraining(nameOfTraining, informator);
    }


    public void modifyTrainingsDetails(AppDataCenter data, String nameOfTraining) {
        manager.addTrainingDetails(nameOfTraining, informator);
    }


    public void doOtherNeededThings(String nameOfTraining) {
        informator.printSuccessfullyAddedTrainingInfo(nameOfTraining);
    }

    @Override
    public boolean checkIfOrderIsPossibleAndShowOptionalInformation(AppDataCenter data, String nameOfTraining) {
        if (data.AllTrainings.trainingExists(nameOfTraining)){
            informator.printTrainingAlreadyExistInfo();
            return false;
        }
        return true;
    }

}
