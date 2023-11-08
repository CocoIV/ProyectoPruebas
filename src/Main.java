import java.util.ArrayList;
import java.util.List;
import javax.smartcardio.Card;


class PokemonCards {
    private List<Card> receivedCards;

    public PokemonCards() {
        receivedCards = new ArrayList<>();
    }

    // Método para recibir una carta y guardarla en la lista
    public void receiveCard(Card card) {
        receivedCards.add(card);
    }

    void receiveCard(CardTypes card) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    void receiveCard(SpellCard spell) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}

public class Main {
    public static void main(String[] args) {
        PokemonCards pokemonCards = new PokemonCards();
        CardTypes card = new CardTypes();
        SpellCard spell = new SpellCard();

        // PikachuCard recibe y almacena cartas
        pokemonCards.receiveCard(card);
        pokemonCards.receiveCard(spell);
    }
}
