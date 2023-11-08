public class Combat {
    private CombatCard player1Card;
    private CombatCard player2Card;

    public Combat(CombatCard player1Card, CombatCard player2Card) {
        this.player1Card = player1Card;
        this.player2Card = player2Card;
    }

    public void performAttack() {
        int player1Damage = player1Card.getDamage();
        int player2Damage = player2Card.getDamage();

        player2Card.reduceHealth(player1Damage);
        player1Card.reduceHealth(player2Damage);
    }

    public boolean isOver() {
        return player1Card.getHealth() <= 0 || player2Card.getHealth() <= 0;
    }

    public String getWinner() {
        if (player1Card.getHealth() <= 0) {
            return "Player 2";
        } else if (player2Card.getHealth() <= 0) {
            return "Player 1";
        } else {
            return "No winner yet";
        }
    }

    private static class CombatCard {
        private int damage;
        private int health;

        public CombatCard(int damage, int health) {
            this.damage = damage;
            this.health = health;
        }

        public int getDamage() {
            return damage;
        }

        public void reduceHealth(int damageTaken) {
            health -= damageTaken;
            if (health < 0) {
                health = 0;
            }
        }

        public int getHealth() {
            return health;
        }
    }

    public static void main(String[] args) {
        // Ejemplo de cómo usar la simulación de combate
        CombatCard player1Card = new CombatCard(10, 50);
        CombatCard player2Card = new CombatCard(8, 60);

        Combat battle = new Combat(player1Card, player2Card);

        while (!battle.isOver()) {
            battle.performAttack();
            System.out.println("Player 1 Health: " + player1Card.getHealth());
            System.out.println("Player 2 Health: " + player2Card.getHealth());
        }

        System.out.println("Winner: " + battle.getWinner());
    }
}