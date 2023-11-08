import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SpellCard {
    private final String spellName;

    public SpellCard(String name) {
        this.spellName = name;
    }

    SpellCard(String spellName, String spellAbility) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    SpellCard() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getSpellName() {
        return spellName;
    }
}

class Store {
    private final int playerLevel;
    private int playerCoins;
    private final int storeFunds;
    private final List<SpellCard> availableSpells;
    private final Map<String, Integer> playerCards;

    public Store(int level, int coins, int storeFunds, List<SpellCard> availableSpells) {
        this.playerLevel = level;
        this.playerCoins = coins;
        this.storeFunds = storeFunds;
        this.availableSpells = new ArrayList<>(availableSpells);
        this.playerCards = new HashMap<>();
    }

    public void buyNormalCard() {
        int cost = 10;
        if (playerLevel >= 5 && playerCoins >= cost) {
            playerCoins -= cost;
            addCardToPlayer("Normal");
            System.out.println("Has comprado una carta Normal.");
        } else {
            System.out.println("Nivel insuficiente o no tienes suficientes monedas.");
        }
    }

    public void buyRareCard() {
        int cost = 30;
        if (playerLevel >= 10 && playerCoins >= cost) {
            playerCoins -= cost;
            addCardToPlayer("Rara");
            System.out.println("Has comprado una carta Rara.");
        } else {
            System.out.println("Nivel insuficiente o no tienes suficientes monedas.");
        }
    }

    public void buyEpicCard() {
        int cost = 50;
        if (playerLevel >= 15 && playerCoins >= cost) {
            playerCoins -= cost;
            addCardToPlayer("Épica");
            System.out.println("Has comprado una carta Épica.");
        } else {
            System.out.println("Nivel insuficiente o no tienes suficientes monedas.");
        }
    }

    public void buyLegendaryCard() {
        int cost = 80;
        if (playerLevel >= 20 && playerCoins >= cost) {
            playerCoins -= cost;
            addCardToPlayer("Legendaria");
            System.out.println("Has comprado una carta Legendaria.");
        } else {
            System.out.println("Nivel insuficiente o no tienes suficientes monedas.");
        }
    }

    public void buyMythicalCard() {
        int cost = 100;
        if (playerLevel >= 25 && playerCoins >= cost) {
            playerCoins -= cost;
            addCardToPlayer("Mítica");
            System.out.println("Has comprado una carta Mítica.");
        } else {
            System.out.println("Nivel insuficiente o no tienes suficientes monedas.");
        }
    }

    private void addCardToPlayer(String rarity) {
        playerCards.put(rarity, playerCards.getOrDefault(rarity, 0) + 1);
    }

    public void displayPlayerInfo() {
        System.out.println("Nivel del jugador: " + playerLevel);
        System.out.println("Monedas del jugador: " + playerCoins);
        System.out.println("Fondos de la tienda: " + storeFunds);
        System.out.println("Hechizos disponibles: " + availableSpells);
        System.out.println("Cartas del jugador: " + playerCards);
    }
}