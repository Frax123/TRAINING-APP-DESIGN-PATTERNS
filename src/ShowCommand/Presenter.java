package ShowCommand;

import HelpClasses.InformationDisplayer;
import ShowCommand.ShowCommand;

public class Presenter {
    private ShowCommand command;

    public Presenter(ShowCommand _command){
        this.command = _command;
    }

    public void doTheJob(InformationDisplayer informationDisplayer) {
        command.load(informationDisplayer);
        command.execute(informationDisplayer);
    }
}
