package Orders;

import Strategies.Strategy;
import app.AppDataCenter;
import app.AppDataUploader;


public class OrderExecutor {
    public static void execute(Strategy strategy, AppDataCenter appData){
        if (strategy!= null) {
            strategy.printWelcomeInfo();
            String nameOfTraining = AppDataUploader.getNextLine();
            if (strategy.checkIfOrderIsPossibleAndShowOptionalInformation(appData, nameOfTraining)) {
                strategy.doEverythingConnectedToGivenOrder(appData, nameOfTraining);
                //strategy.modifyTrainingsData(appData, nameOfTraining);
                //strategy.modifyTrainingsDetails(appData, nameOfTraining);
                //strategy.doOtherNeededThings(appData, nameOfTraining);
            }
        }
    }
}
