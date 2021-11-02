/**
 *Represents an AirBender.
 *
 *@author simhof3
 *@version 1331
 */
public class AirBender extends Bender {
    private boolean avatar;
    /**
     *Creates an airbender with a name.
     *
     *@param name the airbender's name
     */
    public AirBender(String name) {
        this(name, 40, 35, false);
    }
    /**
     *Creates an airbender with a name, strength level, health, and
     *if it is an avatar.
     *
     *@param name the airbender's name
     *@param strengthLevel the airbender's strength
     *@param health the airbender's health
     *@param avatar if the airbender is an avatar
     */
    public AirBender(String name, int strengthLevel, int health, boolean avatar) {
        super(name, "Air", strengthLevel, health);
        this.avatar = avatar;
    }
    /**
    *If the attacking bender has a health greater than 0, the defending bender's health
    *decreases by the attacking bender's strength level divided by 2.
    *
    *@param b defending bender
    */
    public void attack(Bender b) {
        if (this.getHealth() > 0) {
            b.setHealth(b.getHealth() - (this.getStrengthLevel() / 2));
            if (b.getHealth() < 0) {
                b.setHealth(0);
            }
        }
    }
    /**
    *Determines if two benders have a strong connection by checking if they
    *have equal health values.
    *
    *@param b the bender to be checked
    *@return true or false representing if the two bender's have a strong connection
    */
    public boolean spiritualProjection(Bender b) {
        return (this.getHealth() == b.getHealth());
    }
    /**
    *If the airbender is an avatar, it changes the health or strength level of
    *the bender that is passed in, depending on what element they control.
    *
    *@param s the element of the affected bender
    *@param b the affected bender
    */
    public void avatarState(String s, Bender b) {
        if (this.avatar) {
            switch (s) {
            case "Earth" :
                b.setHealth(b.getHealth() / 2);
                break;
            case "Fire":
                b.setStrengthLevel(b.getStrengthLevel() - 10);
                if (b.getStrengthLevel() < 10) {
                    b.setStrengthLevel(0);
                }
                break;
            case "Air":
                if (b.getStrengthLevel() < 15) {
                    b.setStrengthLevel(0);
                }
                break;
            case "Water":
                if (b.getHealth() < 5 && b.getStrengthLevel() < 15) {
                    b.setHealth(0);
                }
                break;
            default:
            }
        }
    }
}
