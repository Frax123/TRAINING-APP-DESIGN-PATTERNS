package HelpClasses;

public interface AppDataManager {
    void addTrainingData(String nameOfTraining);
    void addTrainingDetails(String nameOfTraining, InformationDisplayer informator);
    void deleteTrainingData(String nameOfTraining);
    void deleteFileInTrainingDetails(String nameOfTraining);
}
