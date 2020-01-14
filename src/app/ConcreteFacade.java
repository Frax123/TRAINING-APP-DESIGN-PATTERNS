package app;

import HelpClasses.AppDataManager;
import HelpClasses.FileOperationsExecutorConcrete;
import HelpClasses.InformationDisplayer;
import HelpClasses.StringInformator;
import Orders.*;
import oldClasses.Order;

import java.util.LinkedList;
import java.util.function.Consumer;

public class ConcreteFacade extends Facade {
    private AppDataCenter appData;
    private AppDataManager appManager;
    private LinkedList<Order> orders;
    private Consumer<Order> ordersPreparator;
    private Boolean wasOrderCorrect;
    private InformationDisplayer informator;
    private OrderFactory factory;


    @Override
    void showMenu(){
        informator.showMenu();
    }

    void uploadAppData(){
        this.appData = AppDataCenter.getInstance();
    }


    @Override
    void initializeApp() {
        uploadAppData();
        //orders = new LinkedList<>();
        //uploadOrdersIntoList();
        appManager = new FileOperationsExecutorConcrete();
        informator = new StringInformator();
        wasOrderCorrect = false;
        factory = new ConcreteOrderFactory();

    }

    /*private void uploadOrdersIntoList() {
        Order addOrder = new AddOrder();
        Order deleteOrder = new DeleteOrder();
        Order updateOrder = new UpdateOrder();
        Order showOrder = new ShowOrder();
        this.orders.add(addOrder);
        this.orders.add(deleteOrder);
        this.orders.add(showOrder);
        this.orders.add(deleteOrder);
    }*/

    @Override
    void processOrders() {
        String help;
        help = AppDataUploader.getNextLine();
        OrderExecutor.execute(factory.createOrder(help, appManager, informator), appData);

        /*this.ordersPreparator = new MyConsumer(help);
        orders.forEach(ordersPreparator);
        if (!wasOrderCorrect) {
            informator.printBadOrderInfo();
        } else {
            wasOrderCorrect = true;
        }*/

    }

  /*  private class MyConsumer implements Consumer<Order> {
        String orderName;

        MyConsumer(String _orderName){
            orderName = _orderName;
        }

        @Override
        public void accept(Order order) {
            if (this.orderName.equals(order.getOrderId())){
                OrderExecutor.execute(order.getProperStrategy(appManager, informator), appData);
                wasOrderCorrect = true;
            }
        }
    }*/
}
