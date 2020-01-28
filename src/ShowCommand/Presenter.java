package ShowCommand;

import HelpClasses.InformationDisplayer;
import ShowCommand.ShowCommand;
import TrainingCoordinatorPackage.TrainingCoordinator;

public class Presenter {
    private ShowCommand command;

    public Presenter(ShowCommand _command){
        this.command = _command;
    }

    public void doTheJob(InformationDisplayer informationDisplayer, TrainingCoordinator _allTrainings) {
        command.load(informationDisplayer, _allTrainings);
        command.execute(informationDisplayer);
    }
}
