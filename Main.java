// Реализовать класс Market и все методы, которые он обязан реализовывать.
// Методы из интерфейса QueueBehaviour, имитируют работу очереди, 
// MarketBehaviour – помещает и удаляет человека из очереди.

package Task2;

public class Main {
    public static void main(String[] args) {

        Actor hum1 = new Human("Петр");
        Actor hum2 = new Human("Виктор");

        Market market = new Market();

        market.acceptToMarket(hum1);
        market.acceptToMarket(hum2);
        market.takeOrders();
        market.takeInQueue(hum1);
        market.takeInQueue(hum2);
        market.giveOrders();
        market.giveOrders();
        market.releaseFromQueue();

    }    
}
