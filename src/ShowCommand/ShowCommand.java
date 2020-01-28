package ShowCommand;

import HelpClasses.InformationDisplayer;
import TrainingCoordinatorPackage.TrainingCoordinator;

public interface ShowCommand {
    void load(InformationDisplayer informationDisplayer, TrainingCoordinator _allTrainings);
    void execute(InformationDisplayer informationDisplayer);
}
