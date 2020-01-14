package ShowCommand;

import HelpClasses.InformationDisplayer;

public interface ShowCommand {
    void load(InformationDisplayer informationDisplayer);
    void execute(InformationDisplayer informationDisplayer);
}
