import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Deck {
    private List<Cards> cardsInDeck;

    public Deck(List<Cards> cardsInDeck) {
        this.cardsInDeck = cardsInDeck;
    }

    public List<Cards> getCardsInDeck() {
        return cardsInDeck;
    }

    public void shuffle() {
        Collections.shuffle(cardsInDeck);
    }


    public static void main(String[] args) {
        // Agrega aquí el código de prueba para la clase Deck
        List<Cards> cards = new ArrayList<>();
        // Agrega cartas al mazo
        cards.add(new Cards("Card1", 10, 5, "Ability1", 2));
        cards.add(new Cards("Card2", 8, 4, "Ability2", 3));
        cards.add(new Cards("Card3", 12, 6, "Ability3", 4));
        
        Deck deck = new Deck(cards);

        // Prueba el barajado del mazo
        System.out.println("Mazo antes de barajar:");
        for (Cards card : deck.getCardsInDeck()) {
            System.out.println("Name: " + card.getName());
        }

        deck.shuffle();

        System.out.println("\nMazo después de barajar:");
        for (Cards card : deck.getCardsInDeck()) {
            System.out.println("Name: " + card.getName());
        }
    }
}