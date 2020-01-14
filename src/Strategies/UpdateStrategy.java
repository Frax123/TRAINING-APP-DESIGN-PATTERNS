package Strategies;

import Strategies.Strategy;
import app.AppDataCenter;

public class UpdateStrategy implements Strategy {


    @Override
    public void printWelcomeInfo() {

    }

    public void modifyTrainingsData(AppDataCenter data, String nameOfTraining) {

    }

    public void modifyTrainingsDetails(AppDataCenter data, String nameOfTraining) {

    }

    public void doOtherNeededThings(String nameOfTraining) {

    }

    @Override
    public void doEverythingConnectedToGivenOrder(AppDataCenter appData, String nameOfTraining) {
        modifyTrainingsData(appData, nameOfTraining);
        modifyTrainingsDetails(appData, nameOfTraining);
        doOtherNeededThings(nameOfTraining);
    }

    @Override
    public boolean checkIfOrderIsPossibleAndShowOptionalInformation(AppDataCenter data, String nameOfTraining) {
        return false;
    }
}
