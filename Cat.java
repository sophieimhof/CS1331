/**
 *Represents a Cat.
 *
 *@author simhof3
 *@version 1331
 */
public class Cat extends Pet {
    private int miceCaught;
    /**
     *Creates a cat with default number of mice caught.
     *
     *@param name cat's name
     *@param health cat's health
     *@param painLevel cat's painLevel
     */
    public Cat(String name, double health, int painLevel) {
        this(name, health, painLevel, 0);
    }
    /**
     *Creates a cat.
     *
     *@param name cat's name
     *@param health cat's health
     *@param painLevel cat's painLevel
     *@param miceCaught number of mice caught
     */
    public Cat(String name, double health, int painLevel, int miceCaught) {
        super(name, health, painLevel);
        if (miceCaught < 0) {
            this.miceCaught = 0;
        } else {
            this.miceCaught = miceCaught;
        }
    }
    /**
    *Gets the number of mice a cat has caught.
    *
    *@return cat's mice caught number
    */
    public int getMiceCaught() {
        return this.miceCaught;
    }
    @Override
    public int treat() {
        int result;
        if (this.miceCaught <= 4) {
            result = (int) Math.ceil((this.getPainLevel() * 2 / this.getHealth()));
        } else if (this.miceCaught > 4 && this.miceCaught <= 7) {
            result = (int) Math.ceil((this.getPainLevel() / (this.getHealth())));
        } else {
            result = (int) Math.ceil((this.getPainLevel() / (this.getHealth() * 2)));
        }
        this.heal();
        return result;
    }
    @Override
    public String getPetInfo() {
        return String.format("Cat,%s,%.2f,%d,%d", this.getName(),
                this.getHealth(), this.getPainLevel(), this.miceCaught);
    }
    @Override
    public void speak() {
        super.speak();
        if (this.getPainLevel() <= 5) {
            for (int i = 1; i < this.getPainLevel(); i++) {
                System.out.print("meow ");
            }
            System.out.println("meow");
        } else {
            for (int i = 1; i < this.getPainLevel(); i++) {
                System.out.print("MEOW ");
            }
            System.out.println("MEOW");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof Cat) {
            Cat that = (Cat) o;
            return (this.miceCaught == that.miceCaught);
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return (super.toString() + "I'm a Cat, my mice caught is " + this.miceCaught);
    }
}
