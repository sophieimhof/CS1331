public class ChargedSuperhero extends Superhero {
    private boolean charged;

    public ChargedSuperhero() {
        this("Anonymous ChargedSuperhero", 30, 10, false);
    }

    public ChargedSuperhero(String name, int health, int damage, boolean charged) {
        super(name, health, damage);
        this.charged = charged;
    }

    public String toString() {
        return (super.toString() + "\nSuit Charged: " + charged);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof ChargedSuperhero) {
            ChargedSuperhero that = (ChargedSuperhero) obj;
            return (super.equals(obj)) && (this.charged == that.charged);
        } else {
            return false;
        }
    }

    @Override
    public void attack(Superhero other) {
        if (this.charged && this.health > 0) {
            other.health = other.health - (this.damage * 2);
            if (other.health < 0) {
                other.health = 0;
            }
        } else {
            super.attack(other);
        }
    }
}
