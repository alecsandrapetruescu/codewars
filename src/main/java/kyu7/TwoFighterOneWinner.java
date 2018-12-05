package kyu7;

public class TwoFighterOneWinner {
    public static String declareWinner(Fighter fighter1, Fighter fighter2, String firstAttacker) {
        double fight1 =  Math.ceil((double) fighter2.health / fighter1.damagePerAttack);
        double fight2 =  Math.ceil((double) fighter1.health / fighter2.damagePerAttack);
        return (fight1 > fight2) ? fighter2.name : (fight1 < fight2) ? fighter1.name : firstAttacker;
    }
}

class Fighter {
    public String name;
    public int health, damagePerAttack;
    public Fighter(String name, int health, int damagePerAttack) {
        this.name = name;
        this.health = health;
        this.damagePerAttack = damagePerAttack;
    }
}
