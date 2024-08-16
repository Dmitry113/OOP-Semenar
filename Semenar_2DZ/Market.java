package Semenar_2DZ;

import java.util.ArrayList;
import java.util.List;

public class Market implements QueueBehaviour, MarketBehaviour {
    private final List<MainInterface> queue;

    public Market() {
        this.queue = new ArrayList<>();

    }

    @Override
    public void giveOrders() {
        for (MainInterface actor : queue) {
            if (actor.isMakeOrder()) {
                actor.setTakeOrder(true);
                System.out.println(actor.getName() + " получил свой заказ");
            }
        }
    }

    @Override
    public void releaseFromQueue() {
        List<MainInterface> releasedActors = new ArrayList<>();
        for (MainInterface actor : queue) {
            if (actor.isTakeOrder()) {
                releasedActors.add(actor);
                System.out.println(actor.getName() + " вышел из очереди и готов уходить");
            }
        }
        releaseFromMarket(releasedActors);
    }

    @Override
    public void takeInQueue(MainInterface actor) {
        System.out.println(actor.getName() + " встал в очередь");
        this.queue.add(actor);
    }

    @Override
    public void takeOrders() {
        for (MainInterface actor : queue) {
            if (!actor.isMakeOrder()) {
                actor.setMakeOrder(true);
                System.out.println(actor.getName() + " сделал свой заказ");
            }
        }
    }

    @Override
    public void acceptToMarket(MainInterface actor) {
        System.out.println(actor.getName() + " пришёл в магазин");
        takeInQueue(actor);
    }

    @Override
    public void releaseFromMarket(List<MainInterface> actors) {
        for (MainInterface actor : actors) {
            System.out.println(actor.getName() + " вышел из магазина");
            queue.remove(actor);
        }
    }

    @Override
    public void update() {
        takeOrders();
        giveOrders();
        releaseFromQueue();
    }
}
