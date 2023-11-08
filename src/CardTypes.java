import java.util.List;

public class CardTypes {
    private List<Cards> cardsOfType;
    
    public CardTypes(List<Cards> cardsOfType) {
        this.cardsOfType = cardsOfType;
    }

    CardTypes() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
    public List<Cards> getCardsOfType() {
        return cardsOfType;
    }

    public void addCardOfType(Cards card) {
        cardsOfType.add(card);
    }
}