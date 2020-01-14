package HelpClasses;

import Trainings.TrainingInstance;

public interface InformationDisplayer {
    void printTrainingAlreadyExistInfo();
    void printSuccessfullyAddedTrainingInfo(String nameOfTraining);
    void printSuccessfullyDeletedTrainingInfo(String nameOfTraining);
    void printBadOrderInfo();
    void printTrainingDoesntExistInfo();
    void printTrainingLength(String name, Integer len);
    void printTrainingProgress(String name, String progress);
    void printTrainingDay(int numberOfDay, String dailyGoal);
    void printCreationDate(String dateOfCreation);
    void printTrainingInDetails(TrainingInstance training);
    void printBadIntegerFormatInformation();
    void printRequiredLengthInfo();
    void printRequiredProgressInfo();
    void printInfoAboutDailyGoalsInput();
    void showMenu();
    void printInstructionToShowOrder();
    void printWelcomeToShowOrder();
    void printInfoAboutShowingDays();
    void printInfoAboutNewTrainingName();
    void printInfoAboutTrainingToDeleteName();
}
