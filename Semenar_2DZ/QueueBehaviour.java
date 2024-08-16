package Semenar_2DZ;

public interface QueueBehaviour {
    void takeInQueue(MainInterface actor);

    void releaseFromQueue();

    void takeOrders();

    void giveOrders();
}
