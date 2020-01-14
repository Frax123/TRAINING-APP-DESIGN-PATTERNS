package TrainingCoordinatorPackage;

import HelpClasses.InformationDisplayer;
import Trainings.TrainingInstance;

public interface TrainingCoordinator {
    TrainingInstance getTraining(String name);
    void addTraining(String name, InformationDisplayer informationDisplayer);
    void deleteTraining(String name);
    boolean trainingExists(String name);
}
