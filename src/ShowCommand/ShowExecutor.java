package ShowCommand;

import HelpClasses.AppDataManager;
import HelpClasses.FileOperationsExecutorConcrete;
import HelpClasses.InformationDisplayer;
import TrainingCoordinatorPackage.ConcreteTrainingCoordinator;
import TrainingCoordinatorPackage.TrainingCoordinator;

public class ShowExecutor {
    ShowCommand show;
    Presenter presenter;
    TrainingCoordinator coordinator;
    AppDataManager manager;
    InformationDisplayer informator;

    public ShowExecutor(Presenter presenter, TrainingCoordinator coordinator){
        this.presenter = presenter;
        this.coordinator = coordinator;
    }

    public void execute(){
        presenter.doTheJob(informator, coordinator);
    }
}
