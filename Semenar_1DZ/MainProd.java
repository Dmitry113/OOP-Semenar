import java.util.ArrayList;
import java.util.List;

public class MainProd {
    public static void main(String[] args) {
        // Создание списка горячих напитков
        List<HotDrink> hotDrinkList = new ArrayList<>();
        hotDrinkList.add(new HotDrink("Tea", 200, 80));
        hotDrinkList.add(new HotDrink("Coffee", 250, 90));
        hotDrinkList.add(new HotDrink("Coffee", 200, 90));
        hotDrinkList.add(new HotDrink("Hot Chocolate", 300, 85));
        hotDrinkList.add(new HotDrink("Latte", 250, 75));

        // Инициализация автомата
        HotDrinkVendingMachine vendingMachine = new HotDrinkVendingMachine();
        vendingMachine.initProduct(hotDrinkList);

        // Получение продукта по имени и объему
        HotDrink drink = vendingMachine.getProduct("Tea", 200);
        System.out.println(drink);

        // Получение продукта по имени, объему и температуре
        HotDrink specificDrink = vendingMachine.getProduct("Coffee", 250, 90);
        System.out.println(specificDrink);

        // Попытка получить несуществующий продукт
        HotDrink notFoundDrink = vendingMachine.getProduct("Tea", 200, 90);
        System.out.println(notFoundDrink); // Ожидается null
    }
}
