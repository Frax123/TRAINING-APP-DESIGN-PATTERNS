package app;

import HelpClasses.AppDataManager;
import HelpClasses.FileOperationsExecutorConcrete;
import HelpClasses.StringInformator;
import TrainingCoordinatorPackage.ConcreteTrainingCoordinator;
import TrainingCoordinatorPackage.TrainingCoordinator;

import java.io.ObjectStreamException;

public class AppDataCenter {
    public String language;
    public TrainingCoordinator AllTrainings;
    private static volatile AppDataCenter instance;

    private AppDataCenter(TrainingCoordinator _allTrainings){
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance of AppDataCenter, please use getInstance method instead.");
        }
        AllTrainings = _allTrainings;new ConcreteTrainingCoordinator(new FileOperationsExecutorConcrete(), new StringInformator());
    }


    public static AppDataCenter getInstance(TrainingCoordinator _allTrainings){
        if (instance == null){
            synchronized (AppDataCenter.class) {
                if (instance == null) {
                    instance = new AppDataCenter(_allTrainings);
                }
            }
        }
        return instance;
    }

    private Object readResolve(TrainingCoordinator _allTrainings) throws ObjectStreamException {
        return getInstance(_allTrainings);
    }
}
