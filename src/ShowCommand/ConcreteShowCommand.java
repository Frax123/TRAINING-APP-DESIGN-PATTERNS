package ShowCommand;

import HelpClasses.InformationDisplayer;
import TrainingCoordinatorPackage.TrainingCoordinator;
import Trainings.TrainingInstance;
import app.AppDataCenter;
import app.AppDataUploader;
import HelpClasses.StringInformator;

import java.util.LinkedList;

public class ConcreteShowCommand implements ShowCommand {
    String command;
    String trainingName;
    AppDataCenter appData;
    LinkedList<Integer> days;

    @Override
    public void load(InformationDisplayer informationDisplayer, TrainingCoordinator _allTrainings) {
        appData = AppDataCenter.getInstance(_allTrainings);
        //loadTrainingName();
        informationDisplayer.printInstructionToShowOrder();
        command = AppDataUploader.getNextLine();
        if (command.charAt(0) == '1'){
            loadDays(informationDisplayer);
        }
    }

    private void loadDays(InformationDisplayer informationDisplayer){
        informationDisplayer.printInfoAboutShowingDays();
        String helpToRememberInput = AppDataUploader.getNextLine();
        while (!helpToRememberInput.substring(0,2).equals("END")){
            try{
                days.add(Integer.parseInt(helpToRememberInput));
            } catch (NumberFormatException exc){
                informationDisplayer.printBadIntegerFormatInformation();
            }
        }
    }


    @Override
    public void execute(InformationDisplayer informationDisplayer) {
        TrainingInstance training = appData.AllTrainings.getTraining(trainingName);
        if (command.equals("ALL")){
            training.showTrainingInDetails();
        } else {
            if (command.charAt(0) == '1') {
                days.forEach(elem -> training.showTrainingDay(elem));
            } else if (command.charAt(1) == '1') {
                training.showTrainingLength();
            } else if (command.charAt(2) == '1') {
                training.showTrainingProgress();
            } else if (command.charAt(3) == '1') {
                training.showCreationDate();
            }
        }
    }
}
