/**
 *Represents a type of Bender.
 *
 *@author simhof3
 *@version 1331
 */
public abstract class PowerUp extends Bender {
    /**
    *Method to be defined later.
    */
    public abstract void fireArmy();
    /**
    *Doubles a firebender's strength level.
    *
    *@param f a firebender
    */
    public static void strengthDoubles(FireBender f) {
        f.setStrengthLevel(f.getStrengthLevel() * 2);
    }

    /**
     *Creates a PowerUp bender with a name, element, strength level, and health.
     *
     *@param name bender's name
     *@param element the bender's element
     *@param strengthLevel the bender's strength
     *@param health the bender's health
     */
    public PowerUp(String name, String element, int strengthLevel, int health) {
        super(name, element, strengthLevel, health);
    }
}
