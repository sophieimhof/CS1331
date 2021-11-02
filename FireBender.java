/**
 *Represents a FireBender.
 *
 *@author simhof3
 *@version 1331
 */
public class FireBender extends PowerUp {
    private int fireStrength;
    private boolean hasArmy;
    /**
     *Creates a FireBender with a name.
     *
     *@param name firebender's name
     */
    public FireBender(String name) {
        this(name, 30, 15, 15, true);
    }
    /**
    *Creates a firebender with a name, strength level, and health level,
    *fire strength level, and if it has an army.
    *
    *@param name the firebender's name
    *@param strengthLevel the firebender's strength
    *@param health the firebender's health
    *@param fireStrength the firebender's fire strength
    *@param hasArmy if the firebender has an army
    */
    public FireBender(String name, int strengthLevel, int health, int fireStrength, boolean hasArmy) {
        super(name, "Fire", strengthLevel, health);
        this.fireStrength = fireStrength;
        this.hasArmy = hasArmy;
    }
    /**
    *Doubles the health and triples the firestrength if the firebender has an army.
    *
    */
    public void fireArmy() {
        if (hasArmy) {
            this.setHealth(this.getHealth() * 2);
            this.fireStrength = this.fireStrength * 3;
        }
    }
    /**
    *If the attacking bender has a health greater than 5, the defending bender's health
    *decrease by the attacking bender's strength level times its fire strength.
    *
    *@param b defending bender
    */
    public void attack(Bender b) {
        if (this.getHealth() >= 5) {
            b.setHealth(b.getHealth() - (this.getStrengthLevel() * this.fireStrength));
            if (b.getHealth() < 0) {
                b.setHealth(0);
            }
        }
    }

    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && (o instanceof FireBender)) {
            FireBender that = (FireBender) o;
            return (this.fireStrength == that.fireStrength);
        } else {
            return false;
        }
    }

    @Override
    public String toString() {
        return (super.toString() + " My fire strength level is " + fireStrength + ".");
    }
}
