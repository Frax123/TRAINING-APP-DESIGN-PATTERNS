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

    private AppDataCenter(){
        if (instance != null) {
            throw new IllegalStateException("Cannot create new instance of AppDataCenter, please use getInstance method instead.");
        }
        AllTrainings = new ConcreteTrainingCoordinator(new FileOperationsExecutorConcrete(), new StringInformator());
    }


    public static AppDataCenter getInstance(){
        if (instance == null){
            synchronized (AppDataCenter.class) {
                if (instance == null) {
                    instance = new AppDataCenter();
                }
            }
        }
        return instance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }
}
