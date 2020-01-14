package TrainingCoordinatorPackage;

import HelpClasses.AppDataManager;
import HelpClasses.InformationDisplayer;
import Trainings.ProxyTrainingInstance;
import Trainings.TrainingInstance;
import app.AppDataUploader;
import HelpClasses.FileOperationsExecutorConcrete;

import java.util.HashMap;

public class ConcreteTrainingCoordinator implements TrainingCoordinator {
    HashMap<String, TrainingInstance> trainings;
    AppDataManager manager;
    InformationDisplayer informationDisplayer;

    public void prepareTrainings(){
        trainings = new HashMap<>();
        new AppDataUploader().readAppSavedData(trainings, informationDisplayer);
    }

    public ConcreteTrainingCoordinator(AppDataManager _manager, InformationDisplayer _informationDisplayer){
        prepareTrainings();
        manager = _manager;
        informationDisplayer = _informationDisplayer;
    }


    @Override
    public TrainingInstance getTraining(String name) {
        return trainings.get(name);
    }

    @Override
    public void addTraining(String name, InformationDisplayer informationDisplayer) {
        trainings.put(name, new ProxyTrainingInstance(name, informationDisplayer));
    }

    @Override
    public void deleteTraining(String name) {
        if (trainings.containsKey(name)) {
            manager.deleteTrainingData(name);
            trainings.remove(name);
        }
    }

    @Override
    public boolean trainingExists(String name) {
        return trainings.containsKey(name);
    }
}
