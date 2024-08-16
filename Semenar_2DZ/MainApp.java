package Semenar_2DZ;

public class MainApp {
    public static void main(String[] args) {
        Market market = new Market();
        Human human1 = new Human("Ivan");
        Human human2 = new Human("Vladimir");

        market.acceptToMarket(human1);
        market.update();

        market.acceptToMarket(human2);
        market.update();
    }
}
