//I worked on the homework assignment alone, using only course materials.
/**
 * Class representing a SmallBusiness.
 * @author Shen Yi Cheng GTID: 903514405
 * @version 1
 **/
public class Knight extends Adventurer {
    /**
     * A main for DungeonDriver.
     * @param hasSquire as if a knight has a Squire
     *
     **/
    private boolean hasSquire;
    /**
     * a constructor for Knight.
     * @param health for input health
     * @param name for input name
     * @param attackValue for input attackValue
     * @param hasSquire for input has squire or not
     */
    public Knight(String name, double health, double attackValue, boolean hasSquire) {
        super(name, health, attackValue);
        this.hasSquire = hasSquire;
    }
    /**
     * a constructor for Knight.
     * @param name for input name
     * rest as default
     */
    public Knight(String name) {
        super(name, 100, 15);
        this.hasSquire = true;
    }
    /**
     * an attack method for knight and override from Adventurer.
     * @param other as be attacked Adventurer
     */
    public void attack(Adventurer other) {
        if (other != null) {
            if (super.getHealth() > 0 && other.getHealth() > 0) {
                if (hasSquire) {
                    other.setHealth(other.getHealth() - (super.getAttackValue() * 2));
                } else {
                    other.setHealth(other.getHealth() - super.getAttackValue());
                }
                if (other.getHealth() < 0) {
                    other.setHealth(0);
                }
            }
        }
    }
    /**
     * a challenge method for knight challenge another Knight.
     * @param other another knight be challenged
     */
    public void challenge(Knight other) {
        if (other != null) {
            if (super.getHealth() > 0 && !this.hasSquire && other.hasSquire) {
                if (other.getHealth() <= super.getAttackValue()) {
                    other.setHealth(0);
                    other.hasSquire = false;
                    this.hasSquire = true;
                } else {
                    super.setHealth(super.getHealth() - super.getAttackValue());
                    other.setHealth(other.getHealth() - super.getAttackValue());
                }
            }
        }
    }
    /**
     * a equals method for if a knight equals to another knight.
     * @param other another knight be compared
     * @return return the result
     */
    public boolean equals(Knight other) {
        return (super.getHealth() == other.getHealth()
            && super.getAttackValue() == other.getAttackValue()
            && this.hasSquire == other.hasSquire);
    }
    /**
     * a method for output the Attribute of knights.
     * @return the result
     */
    public String toString() {
        return super.toString() + ", Squire=" + getSquire();
    }
    /**
     * @return if has squire
    */
    public boolean getSquire() {
        return hasSquire;
    }
    /**
     * a method for set squire value for knight.
     * @param squire as a new squire status
     */
    public void setSquire(boolean squire) {
        this.hasSquire = squire;
    }
    /**
     * a get health value method for knight.
     * @return return the health value
     */
    public double getHealth() {
        return super.getHealth();
    }
    /**
     * a get attack value method for knight.
     * @return return the attack value
     */
    public double getAttackValue() {
        return super.getAttackValue();
    }
    /**
     * a method for set health value for knight.
     * @param health as a new health status
     */
    public void setHealth(double health) {
        super.setHealth(health);
    }
    /**
     * a method for set attack value for knight.
     * @param attack as a new attack status
     */
    public void setAttackValue(double attack) {
        super.setAttackValue(attack);
    }
}
