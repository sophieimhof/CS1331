/**
 *Represents a Bender of the elements.
 *
 *@author simhof3
 *@version 1331
 */
public abstract class Bender {
    private String name;
    private String element;
    private int strengthLevel;
    private int health;
    /**
    *Creates a bender with a name, element, strength level, and health level.
    *
    *@param name the bender's name
    *@param element the bender's element
    *@param strengthLevel the bender's strength
    *@param health the bender's health
    */
    public Bender(String name, String element, int strengthLevel, int health) {
        this.name = name;
        this.element = element;
        this.strengthLevel = strengthLevel;
        if (health < 0) {
            this.health = 0;
        } else {
            this.health = health;
        }
    }
    /**
    *Increases the health of a bender by a certain amount unless health is equal to 0.
    *
    *@param level the amount increase
    */
    public void healthIncrease(int level) {
        if (this.health > 0) {
            this.health = this.health + level;
        }
    }
    /**
    *Attacks a bender depending on what type of bender is attacking.
    *
    *@param b the bender to be attacked
    */
    public abstract void attack(Bender b);
    /**
    *Tests if one bender is equal to another.
    *
    *@param o any object
    *
    *@return true or false if o equals the bender
    */
    public boolean equals(Object o) {
        if ((o != null) && (o instanceof Bender)) {
            Bender that = (Bender) o;
            return ((this.name.equals(that.name)) && (this.element.equals(that.element))
                    && (this.strengthLevel == that.strengthLevel) && (this.health == that.health));
        } else {
            return false;
        }
    }
    /**
    *Creates a string with all the bender's information.
    *
    *@return e
    */
    public String toString() {
        return ("My name is " + name + ". I have control over " + element
                + ". My strength level is " + strengthLevel + " and my current health is " + health + ".");
    }
    /**
    *Gets the strength level.
    *
    *@return strength level
    */
    public int getStrengthLevel() {
        return this.strengthLevel;
    }
    /**
    *Gets the health level.
    *
    *@return health level
    */
    public int getHealth() {
        return this.health;
    }
    /**
    *Sets the strength level.
    *
    *@param num new strength level
    */
    public void setStrengthLevel(int num) {
        this.strengthLevel = num;
    }
    /**
    *Sets the health level.
    *
    *@param num new health value
    */
    public void setHealth(int num) {
        this.health = num;
    }
}
