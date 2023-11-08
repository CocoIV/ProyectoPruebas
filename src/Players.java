import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Players {
    private final int healthPoints;
    private final Deck deck;
    private final List<Cards> hand;
    private final String playerName;

    public Players(String playerName, Deck deck) {
        this.playerName = playerName;
        this.deck = deck;
        this.hand = new ArrayList<>();
        this.healthPoints = 30;
    }

    public void playCard(int cardIndex) {
        if (cardIndex >= 0 && cardIndex < hand.size()) {
            Cards cardToPlay = hand.get(cardIndex);
            hand.remove(cardIndex);
            // Implementa la lógica para aplicar los efectos de la carta en el juego.
        } else {
            System.out.println("Índice de carta no válido.");
        }
    }


    public int getHealthPoints() {
        return healthPoints;
    }

    public List<Cards> getHand() {
        return hand;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void playAI() {
        if (hand.isEmpty()) {
            System.out.println(playerName + " no puede jugar más cartas, todas se han utilizado.");
            return;
        }

        Random random = new Random();
        int randomIndex = random.nextInt(hand.size());
        Cards cardToPlay = hand.get(randomIndex);
        hand.remove(randomIndex);
        // Implementa la lógica para aplicar los efectos de la carta en el juego (lógica de la IA).
        System.out.println(playerName + " juega una carta de la IA.");
    }

    public static void main(String[] args) {
        // Crea un mazo con algunas cartas
        List<Cards> cards = new ArrayList<>();
        cards.add(new Cards("Card1", 10, 5, "Ability1", 2));
        cards.add(new Cards("Card2", 8, 4, "Ability2", 3));
        cards.add(new Cards("Card1", 5, 9, "Ability1", 6));

        Deck playerDeck = new Deck(cards);

        // Crea un jugador
        Players player = new Players("Jugador1", playerDeck);

        System.out.println(player.getPlayerName() + "'s hand:");
        for (Cards card : player.getHand()) {
            System.out.println("Name: " + card.getName() + ", Health: " + card.getHealth() + ", Damage: " + card.getDamage());
        }

        player.playCard(0);

        System.out.println(player.getPlayerName() + "'s hand after playing a card:");
        for (Cards card : player.getHand()) {
            System.out.println("Name: " + card.getName() + ", Health: " + card.getHealth() + ", Damage: " + card.getDamage());
        }

        player.playAI(); // Simula el comportamiento de la IA

        // Print player's health points
        System.out.println("Health Points: " + player.getHealthPoints());
    }

    Cards seleccionarCartaParaJugar() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}