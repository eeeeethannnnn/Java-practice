//I worked on the homework assignment alone, using only course materials.
/**
 * Class representing a SmallBusiness.
 * @author Shen Yi Cheng GTID: 903514405
 * @version 1
 **/

public class Archer extends Adventurer {

    private int arrow;
    /**
     * a constructor for Archer.
     * @param health for input health
     * @param name for input name
     * @param attackValue for input attackValue
     * arrow is setted as default 10
     *
     **/
    public Archer(String name, double health, double attackValue) {
        super(name, health, attackValue);
        this.arrow = 10;
    }
    /**
     * a constructor for Archer.
     * @param name for input name
     * rest as default
     */
    public Archer(String name) {
        super(name, 75, 40);
        this.arrow = 10;
    }
    /**
     * an attack method for knight and override from Adventurer.
     * @param other as be attacked Adventurer
     */
    public void attack(Adventurer other) {
        if (other != null) {
            if (this.arrow >= 1 && super.getHealth() > 0) {
                other.setHealth(other.getHealth() - super.getAttackValue());
                this.arrow -= 1;
            }
            if (other.getHealth() < 0) {
                other.setHealth(0);
            }
        }
    }
    /**
     * a equals method for if a knight equals to another knights.
     * @param other another knight be compared
     * @return return the result
     */
    public boolean equals(Archer other) {
        return (super.getHealth() == other.getHealth() && super.getAttackValue() == other.getAttackValue());
    }
    /**
     * a equals method for if an archer equals to another archer.
     * @return return the result
     */
    public String toString() {
        return super.toString() + ", Arrow=" + getArrow();
    }
    /**
     * a getHealth method for archer.
     * @return return the health value
     */
    public double getHealth() {
        return super.getHealth();
    }
    /**
     * a get attack value method for archer.
     * @return return the attack value
     */
    public double getAttackValue() {
        return super.getAttackValue();
    }
    /**
     * a method for set new health value for archer.
     * @param health as a new health value
     */
    public void setHealth(double health) {
        super.setHealth(health);
    }
    /**
     * a method for set new attack value for archer.
     * @param attack as a new attack value
     */
    public void setAttackValue(double attack) {
        super.setAttackValue(attack);
    }
    /**
     * a get arrow value method for archer.
     * @return return the arrow value
     */
    public int getArrow() {
        return this.arrow;
    }
    /**
     * a method for set new arrow value for archer.
     * @param arrow as a new arrow value
     */
    public void setArrow(int arrow) {
        this.arrow = arrow;
    }
}
