public class Superhero {
    protected String name;
    protected int health;
    protected int damage;

    public Superhero() {
        this("Anonymous Superhero", 100, 8);
    }

    public Superhero(String name, int health, int damage) {
        this.name = name;
        this.health = health;
        this.damage = damage;
    }

    public String toString() {
        return ("SUPERHERO\nName: " + name + "\nHealth: " + health + "\nStrength: " + damage);
    }

    public boolean equals(Object obj) {
        if (obj != null && obj instanceof Superhero && (obj.getClass().equals(this.getClass()))) {
            Superhero that = (Superhero) obj;
            return ((this.name.equals(that.name)) && (this.health == that.health)  && (this.damage == that.damage));
        } else {
            return false;
        }
    }

    public void attack(Superhero other) {
        if (this.health > 0) {
            other.health = other.health - this.damage;
            if (other.health < 0) {
                other.health = 0;
            }
        }
    }
}
