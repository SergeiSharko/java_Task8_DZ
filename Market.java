package Task2;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


public class Market implements QueueBehaviour, MarketBehaviour { 
    
    private List<Actor> marketActors;
    private Queue<Actor> actorsQueue;

    public Market() {
        this.marketActors = new LinkedList<Actor>();
        this.actorsQueue = new LinkedList<Actor>();        
    }

    @Override
    public void acceptToMarket(Actor actor) {
        System.out.println(actor.getName() + " пришел в магазин");
        marketActors.add(actor);          
    }

    @Override
    public void releaseFromMarket(List<Actor> actors) { 
       for (Actor actor : actors) {
            if (actor.isTakeOrder) {
                System.out.println(actor.getName() + " вышел с магазина с полученным заказом");
                actors.remove(actor);
            }

            if (actors.isEmpty()) {
             System.out.println("В магазине нет покупателей");
            }      
       }
    }

    @Override
    public void takeInQueue(Actor actor) {
        if (actor.isMakeOrder) {
            actorsQueue.add(actor);
            System.out.println(actor.getName() + " определился с заказом и стал в очередь");
        }
    }

    @Override
    public void takeOrders() {
        for (Actor actor : marketActors) {
            if (!actor.isMakeOrder) {
                actor.setMakeOrder();
                System.out.println("Посетитель " + actor.getName() + " определился с заказом");
            }            
        }       
    }

    @Override
    public void giveOrders() {
        for (Actor actor : actorsQueue) {            
            actor.setTakeOrder();
            actor.isMakeOrder = false;
            System.out.println(actor.getName() + " получил заказ и вышел из очереди");
            releaseFromQueue();            
        }
    }

    @Override
    public void releaseFromQueue() {
        actorsQueue.poll();
        releaseFromMarket(marketActors);                
    }

}
