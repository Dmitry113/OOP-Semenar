import java.util.ArrayList;
import java.util.List;

public class HotDrinkVendingMachine implements VendingMachine {
    private List<HotDrink> hotDrinkList = new ArrayList<>();

    // Инициализация списка напитков
    public void initProduct(List<HotDrink> hotDrinks) {
        this.hotDrinkList = hotDrinks;
    }

    @Override
    public HotDrink getProduct(String name, int volume) {
        for (HotDrink drink : hotDrinkList) {
            if (drink.getName().equals(name) && drink.getVolume() == volume) {
                return drink;
            }
        }
        return null;
    }

    // Перегруженный метод для учета температуры
    public HotDrink getProduct(String name, int volume, int temperature) {
        for (HotDrink drink : hotDrinkList) {
            if (drink.getName().equals(name) && drink.getVolume() == volume && drink.getTemperature() == temperature) {
                return drink;
            }
        }
        return null;
    }
}
