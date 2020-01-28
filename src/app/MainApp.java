package app;

import Configs.Config;

public class MainApp {

    public static void main(String[] args) {
        Config myConfig = new Config();
        Facade facade = myConfig.getFacade();
        facade.runProgram();
    }
}
