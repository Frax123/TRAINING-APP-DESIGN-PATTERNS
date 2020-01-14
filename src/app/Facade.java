package app;

abstract class Facade {
    private AppDataCenter appData;
    public void runProgram(){
        initializeApp();
        while (true) {
            showMenu();
            processOrders();
        }
    }
    abstract void initializeApp();
    abstract void processOrders();
    abstract void showMenu();
}
