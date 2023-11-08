import java.util.ArrayList;
import java.util.List;

public class Store {
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

    public class Item {
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

    