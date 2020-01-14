package HelpClasses;

import Trainings.TrainingInstance;

public class StringInformator implements InformationDisplayer {

    public void printTrainingAlreadyExistInfo(){
        System.out.println("There is a training with this name. Change the name and try again.");
    }

    public void printSuccessfullyAddedTrainingInfo(String nameOfTraining){
        System.out.println("Training "  + nameOfTraining + " was successfully added.");
    }

    public void printSuccessfullyDeletedTrainingInfo(String nameOfTraining){
        System.out.println("Training " + nameOfTraining + " was successfully deleted.");
    }

    public void printBadOrderInfo(){
        System.out.println("Requested order doesn't exist. Please try again.");
    }

    public void printTrainingDoesntExistInfo(){
        System.out.println("Requested training doesn't exist. Please try again");
    }

    public void printTrainingLength(String name, Integer len){
        System.out.println("Training " + name + " is " + len + " days long.");
    }

    public void printTrainingProgress(String name, String progress){
        System.out.println("Training " + name + " is at " + progress + " progression level");
    }

    public void printTrainingDay(int numberOfDay, String dailyGoal) {
        System.out.println("Day " + numberOfDay + ": " + dailyGoal);
    }

    public void printCreationDate(String dateOfCreation) {
        System.out.println("Training was created at " + dateOfCreation);
    }

    public void printTrainingInDetails(TrainingInstance training) {
        training.showTrainingLength();
        training.showTrainingProgress();
        for (int i = 0; i < training.getTrainingLength(); i++){
            training.showTrainingDay(i+1);
        }
        training.showCreationDate();
    }

    public void printBadIntegerFormatInformation() {
        System.out.println("Requested value should be Integer. Please try again.");
    }

    public void printRequiredLengthInfo() {
        System.out.println("Type length of the new training: ");
    }

    public void printRequiredProgressInfo() {
        System.out.println("Type progress of the new training: ");
    }

    public void printInfoAboutDailyGoalsInput() {
        System.out.println("Type every daily goal in proper order. Every goal should be in new line.");
    }

    public void showMenu() {
        System.out.println("Please choose your order from ADD, DELETE, SHOW or UPDATE");
    }

    public void printInstructionToShowOrder() {
        /*System.out.println("Please type one from following demands:");
        System.out.println("DAY X - if you would like to see daily goal for day with number X");
        System.out.println("LEN - if you would like to see length of the training");
        System.out.println("PRO - if you would like to see progress of the training");
        System.out.println("DAT - if you would like to see creation date of the training");
        System.out.println("ALL - if you would like to see every detail of the training");*/
        System.out.println("Please type four digit binary number which will be your command");
        System.out.println("One in the first digit of the number will mean that you would like to see one of days of the training. You will be able to choose concrete days in the next command");
        System.out.println("One in the second digit of the number will mean that you would like to see length of the training.");
        System.out.println("One in the third digit of the number will mean that you would like to see progress of the training.");
        System.out.println("One in the fourth digit of the number will mean that you would like to see creation date of the training.");
        System.out.println("You can also type ALL to show every information connected to the training");
    }

    public void printWelcomeToShowOrder(){
        System.out.println("Please type the name of training you would like to see");
    }

    public void printInfoAboutShowingDays() {
        System.out.println("Please type in number of days which you would like to see. Put every other day in the next line.");
        System.out.println("And the end please type END");
    }

    public void printInfoAboutNewTrainingName() {
        System.out.println("Please type name of your new training.");
    }

    public void printInfoAboutTrainingToDeleteName() {
        System.out.println("Please type name of the training you want to delete.");
    }
}
