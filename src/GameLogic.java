import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class GameLogic {
    private final Store store;
    private final Purse purse;

    public GameLogic() {
        this.store = new Store();
        this.purse = new Purse(500); // Iniciar con 500 monedas
    }

    public void startGame() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bienvenido al juego.");

            // Mostrar el saldo de la billetera del jugador
            System.out.println("Tienes " + purse.getCoins() + " monedas en tu billetera.");

            // Ofrecer opciones al jugador
            System.out.println("Opciones:");
            System.out.println("1. Visitar la tienda");
            System.out.println("2. Terminar el juego");
            System.out.print("Elige una opción: ");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    visitStore();
                    break;
                case 2:
                    endGame();
                    return;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción válida.");
            }
        }
    }

    private void visitStore() {
        System.out.println("¡Bienvenido a la tienda!");
        store.displayItems();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Elige un artículo para comprar (1, 2, 3, ...): ");
        int selectedItem = scanner.nextInt();

        if (store.isValidItem(selectedItem)) {
            Store.Item itemToBuy = store.getItem(selectedItem);
            if (purse.canAfford(itemToBuy.getPrice())) {
                purse.spendCoins(itemToBuy.getPrice());
                purse.addItems(itemToBuy);
                System.out.println("Has comprado " + itemToBuy.getName() + " por " + itemToBuy.getPrice() + " monedas.");
            } else {
                System.out.println("No tienes suficientes monedas para comprar este artículo.");
            }
        } else {
            System.out.println("Opción no válida. Por favor, elige un artículo válido.");
        }
    }

    private void endGame() {
        System.out.println("Juego terminado. ¡Gracias por jugar!");
    }

    public static void main(String[] args) {
        GameLogic game = new GameLogic();
        game.startGame();
    }
}

class Purse {
    private int coins;
    private final List<Store.Item> items;

    public Purse(int initialCoins) {
        this.coins = initialCoins;
        this.items = new ArrayList<>();
    }

    public void addCoins(int numberOfCoins) {
        this.coins += numberOfCoins;
    }

    public void spendCoins(int numberOfCoins) {
        if (this.coins >= numberOfCoins) {
            this.coins -= numberOfCoins;
        } else {
            System.out.println("No hay suficientes monedas para gastar.");
        }
    }

    public int getCoins() {
        return this.coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public boolean canAfford(int price) {
        return this.coins >= price;
    }

    public void addItems(Store.Item itemToBuy) {
        this.items.add(itemToBuy);
    }

    public List<Store.Item> getItems() {
        return this.items;
    }
}

class Store {
    private List<Item> items;

    public Store() {
        this.items = new ArrayList<>();
        // Agregar artículos a la tienda
        items.add(new Item("Espada afilada", 100));
        items.add(new Item("Poción de salud", 50));
        items.add(new Item("Armadura de hierro", 150));
    }

    public void displayItems() {
        System.out.println("Artículos disponibles en la tienda:");
        for (int i = 0; i < items.size(); i++) {
            System.out.println((i + 1) + ". " + items.get(i).getName() + " - Precio: " + items.get(i).getPrice());
        }
    }

    public boolean isValidItem(int selectedItem) {
        return selectedItem >= 1 && selectedItem <= items.size();
    }

    public Item getItem(int selectedItem) {
        if (isValidItem(selectedItem)) {
            return items.get(selectedItem - 1);
        } else {
            return null;
        }
    }

    class Item {
        private String name;
        private int price;

        public Item(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        }
    }
}