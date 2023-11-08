import java.util.ArrayList;
import java.util.List;

public class Purse {
    private int coins; // Cantidad de monedas en el monedero
    private final List<GameLogic.Item> items; // Lista de artículos en el monedero

    public Purse(int initialCoins) {
        this.coins = initialCoins;
        this.items = new ArrayList<>();
    }

    // Método para agregar monedas al monedero
    public void addCoins(int numberOfCoins) {
        this.coins += numberOfCoins;
    }

    // Método para restar monedas del monedero
    public void spendCoins(int numberOfCoins) {
        if (this.coins >= numberOfCoins) {
            this.coins -= numberOfCoins;
        } else {
            System.out.println("No hay suficientes monedas para gastar.");
        }
    }

    // Método para obtener la cantidad actual de monedas en el monedero
    public int getCoins() {
        return this.coins;
    }

    // Método para establecer la cantidad de monedas en el monedero directamente
    public void setCoins(int coins) {
        this.coins = coins;
    }

    // Método para verificar si se pueden comprar artículos (usado en la tienda)
    public boolean canAfford(int price) {
        return this.coins >= price;
    }

    // Método para agregar artículos al monedero (usado en la tienda)
    public void addItems(GameLogic.Item itemToBuy) {
        this.items.add(itemToBuy);
    }

    // Método para obtener la lista de artículos en el monedero
    public List<GameLogic.Item> getItems() {
        return this.items;
    }
}