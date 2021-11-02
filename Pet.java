/**
 *Represents a pet that would seek clinic consultation.
 *
 *@author simhof3
 *@version 1331
 */
public abstract class Pet {
    protected String name;
    protected double health;
    protected int painLevel;
    /**
    *Creates a Pet.
    *
    *@param name the pet's name
    *@param health the pet's health
    *@param painLevel the pet's pain level
    */
    public Pet(String name, double health, int painLevel) {
        if (name == null) {
            this.name = "<noname";
        } else {
            this.name = name;
        }
        if (health > 1.0) {
            this.health = 1.0;
        } else if (health < 0.0) {
            this.health = 0.0;
        } else {
            this.health = health;
        }
        if (painLevel > 10) {
            this.painLevel = 10;
        } else if (painLevel < 1) {
            this.painLevel = 1;
        } else {
            this.painLevel = painLevel;
        }
    }
    /**
    *Gets the pet's name.
    *
    *@return pets name
    */
    public String getName() {
        return this.name;
    }
    /**
    *Gets the pet's health.
    *
    *@return pets health
    */
    public double getHealth() {
        return this.health;
    }
    /**
    *Gets the pet's pain level.
    *
    *@return pets pain level
    */
    public int getPainLevel() {
        return this.painLevel;
    }
    /**
    *Treats a pet.
    *
    *@return minutes of treatmentTime
    */
    public abstract int treat();
    /**
    *Gets a pet's information.
    *
    *@return string of pets information
    */
    public abstract String getPetInfo();
    /**
    *Prints statement with the name of pet.
    *
    */
    public void speak() {
        if (this.painLevel > 5) {
            System.out.println("HELLO! MY NAME IS " + this.name.toUpperCase());
        } else {
            System.out.println("Hello! My name is " + this.name);
        }
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (o instanceof Pet) {
            Pet that = (Pet) o;
            return (this.name.equals(that.name) && this.health == that.health
                    && this.painLevel == that.painLevel);
        } else {
            return false;
        }
    }
    @Override
    public String toString() {
        return ("My name is " + this.name + ", my health is " + this.health
                + " and my painLevel is " + this.painLevel);
    }
    /**
    *Improves pet's health.
    */
    protected void heal() {
        this.health = this.health + 0.25;
        if (this.health > 1.0) {
            this.health = 1.0;
        }
        this.painLevel = this.painLevel - 2;
        if (this.painLevel < 1) {
            this.painLevel = 1;
        }
    }
}
