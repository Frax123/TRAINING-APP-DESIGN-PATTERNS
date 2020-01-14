package Strategies;
import app.AppDataCenter;

public interface Strategy {
    void printWelcomeInfo();
    void doEverythingConnectedToGivenOrder(AppDataCenter appData, String nameOfTraining);
    //void modifyTrainingsData(AppDataCenter data, String nameOfTraining);
    //void modifyTrainingsDetails(AppDataCenter data, String nameOfTraining);
    //void doOtherNeededThings(AppDataCenter data, String nameOfTraining);
    boolean checkIfOrderIsPossibleAndShowOptionalInformation(AppDataCenter data, String nameOfTraining);
}
