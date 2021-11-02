/**
 *Represents a Dog.
 *
 *@author simhof3
 *@version 1331
 */
public class Dog extends Pet {
    private double droolRate;
    /**
     *Creates a dog with default droolRate.
     *
     *@param name dog's name
     *@param health dog's health
     *@param painLevel dog's painLevel
     */
    public Dog(String name, double health, int painLevel) {
        this(name, health, painLevel, 5.0);
    }
    /**
     *Creates a dog.
     *
     *@param name dog's name
     *@param health dog's health
     *@param painLevel dog's pain level
     *@param droolRate dog's drool rate
     */
    public Dog(String name, double health, int painLevel, double droolRate) {
        super(name, health, painLevel);
        this.droolRate = droolRate;
    }
    /**
    *Gets the dog's drool rate.
    *
    *@return dog's drool rate
    */
    public double getDroolRate() {
        return this.droolRate;
    }
    @Override
    public int treat() {
        int result;
        if (this.droolRate <= 3.5) {
            result = (int) Math.ceil((this.getPainLevel() * 2) / this.getHealth());
        } else if (this.droolRate > 3.5 && this.droolRate <= 7.5) {
            result = (int) Math.ceil(this.getPainLevel() / this.getHealth());
        } else {
            result = (int) Math.ceil(this.getPainLevel() / (this.getHealth() * 2));
        }
        this.heal();
        return result;
    }
    @Override
    public String getPetInfo() {
        return String.format("Dog,%s,%.2f,%d,%.2f", this.getName(),
                this.getHealth(), this.getPainLevel(), this.droolRate);
    }
    @Override
    public void speak() {
        super.speak();
        if (this.getPainLevel() <= 5) {
            for (int i = 1; i < this.getPainLevel(); i++) {
                System.out.print("bark ");
            }
            System.out.println("bark");
        } else {
            for (int i = 1; i < this.getPainLevel(); i++) {
                System.out.print("BARK ");
            }
            System.out.println("BARK");
        }
    }
    @Override
    public boolean equals(Object o) {
        if (super.equals(o) && o instanceof Dog) {
            Dog that = (Dog) o;
            return (this.droolRate == that.droolRate);
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return (super.toString() + String.format("I'm a Dog, my drool rate is %.2f", this.droolRate));
    }
}
