import java.util.Random;

public class FlyingSuperhero extends Superhero {
    private Random rand = new Random();
    private boolean flying;

    public FlyingSuperhero() {
        this("Anonymous FlyingSuperhero", 40, 7, false);
    }

    public FlyingSuperhero(String name, int health, int damage, boolean flying) {
        super(name, health, damage);
        this.flying = flying;
    }

    public String toString() {
        return (super.toString() + "\nFlying: " + flying);
    }

    @Override
    public boolean equals(Object obj) {
        if (obj != null && obj instanceof FlyingSuperhero) {
            FlyingSuperhero that = (FlyingSuperhero) obj;
            return (super.equals(obj)) && (this.flying == that.flying);
        } else {
            return false;
        }
    }

    @Override
    public void attack(Superhero other) {
        boolean chance = rand.nextBoolean();
        if (chance && this.flying && this.health > 0) {
            other.health = other.health - (this.damage * 3);
            if (other.health < 0) {
                other.health = 0;
            }
        } else {
            super.attack(other);
        }
    }
}
