package app;

public abstract class Facade {
    public void runProgram(){
        while (true) {
            showMenu();
            processOrders();
        }
    }
    abstract void processOrders();
    abstract void showMenu();
}
