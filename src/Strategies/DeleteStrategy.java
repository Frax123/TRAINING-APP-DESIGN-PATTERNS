package Strategies;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import app.AppDataCenter;
import HelpClasses.StringInformator;

public class DeleteStrategy implements Strategy {
    AppDataManager manager;
    InformationDisplayer informator;

    public DeleteStrategy(AppDataManager _manager, InformationDisplayer _informator){
        manager = _manager;
        informator = _informator;
    }

    @Override
    public void printWelcomeInfo() {
        informator.printInfoAboutTrainingToDeleteName();
    }


    public void modifyTrainingsData(AppDataCenter data, String nameOfTraining) {
        manager.deleteTrainingData(nameOfTraining);
        data.AllTrainings.deleteTraining(nameOfTraining);
    }

    @Override
    public void doEverythingConnectedToGivenOrder(AppDataCenter appData, String nameOfTraining) {
        modifyTrainingsData(appData, nameOfTraining);
        modifyTrainingsDetails(appData, nameOfTraining);
        doOtherNeededThings(nameOfTraining);
    }



    public void modifyTrainingsDetails(AppDataCenter data, String nameOfTraining) {
        manager.deleteFileInTrainingDetails(nameOfTraining);
    }


    public void doOtherNeededThings(String nameOfTraining) {
        informator.printSuccessfullyDeletedTrainingInfo(nameOfTraining);
    }

    @Override
    public boolean checkIfOrderIsPossibleAndShowOptionalInformation(AppDataCenter data, String nameOfTraining) {
        if (!data.AllTrainings.trainingExists(nameOfTraining)){
            informator.printTrainingDoesntExistInfo();
            return false;
        }
        return true;
    }
}
