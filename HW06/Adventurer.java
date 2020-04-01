//I worked on the homework assignment alone, using only course materials.
/**
 * Class representing a SmallBusiness.
 * @author Shen Yi Cheng GTID: 903514405
 * @version 1
 **/
abstract class Adventurer {
    private String name;
    private double attackValue;
    private double health;

    Adventurer(String name, double health, double attackValue) {
        this.name = name;
        this.health = health;
        this.attackValue = attackValue;
    }

    public abstract void attack(Adventurer beAttacked);

    public void drink() {
        this.health += 15;
    }

    public boolean equals(Adventurer other) {
        return (this.name == other.name && this.health == other.health && this.attackValue == other.attackValue);
    }

    public String toString() {
        return "Name=" + this.name + ", Health=" + this.health + ", Attack=" + this.attackValue;

    }

    public void setAttackValue(double newAttackValue) {
        this.attackValue = newAttackValue;
    }

    public double getAttackValue() {
        return this.attackValue;
    }


    public void setHealth(double newHealth) {
        this.health = newHealth;
    }

    public double getHealth() {
        return this.health;
    }
}
