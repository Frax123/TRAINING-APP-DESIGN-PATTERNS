package Trainings;

import HelpClasses.InformationDisplayer;
import app.AppDataUploader;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ProxyTrainingInstance implements TrainingInstance {
    ConcreteTrainingInstance instance;
    String trainingName;
    InformationDisplayer informationDisplayer;
    private static final String PATH_TO_TRAININGS_DETAILS =
            "C:\\\\Users\\\\Krzysiek\\\\Desktop\\\\TRAINING_APP_DESIGN_PATTERNS\\\\src\\\\TrainingsDetails\\\\";
    boolean isConcreteInstanceCreated = false;

    public ProxyTrainingInstance(String _trainingName, InformationDisplayer _informationDisplayer){
        this.trainingName = _trainingName;
        this.informationDisplayer = _informationDisplayer;
        isConcreteInstanceCreated = false;
    }

    private void createInstanceIfNeeded(){
        if (!isConcreteInstanceCreated){
            this.instance = createNewConreteTrainingInstance(trainingName, informationDisplayer);
        }
    }

    @Override
    public void showTrainingProgress() {
        createInstanceIfNeeded();
        instance.showTrainingProgress();
    }

    @Override
    public void showTrainingLength() {
        createInstanceIfNeeded();
        instance.showTrainingLength();
    }

    @Override
    public void showTrainingDay(int numberOfDay) {
        createInstanceIfNeeded();
        instance.showTrainingDay(numberOfDay);
    }

    @Override
    public void showCreationDate() {
        createInstanceIfNeeded();
        instance.showCreationDate();
    }

    private ConcreteTrainingInstance createNewConreteTrainingInstance(String trainingName, InformationDisplayer informationDisplayer) {
        try (BufferedReader br = new BufferedReader(new FileReader(PATH_TO_TRAININGS_DETAILS + trainingName + ".txt"))) {
            return ConcreteTrainingInstance.builder().name(trainingName).length(Integer.parseInt(br.readLine())).
                    progress(br.readLine()).dailyGoals(AppDataUploader.uploadDailyGoals(br)).dateOfCreation((br.readLine())).
                    informationDisplayer(informationDisplayer).build();
        } catch (IOException exc){
            exc.printStackTrace();
        }
        return null;
    }

    @Override
    public void showTrainingInDetails() {
        createInstanceIfNeeded();
        instance.showTrainingInDetails();
    }

    @Override
    public Integer getTrainingLength() {
        return instance.getTrainingLength();
    }

}
