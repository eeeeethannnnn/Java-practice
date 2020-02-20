//I worked on the homework assignment alone, using only course materials.
/** * Program for CheeseConnoisseur.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class CheeseConnoisseur {
    /**
     * private attribute of this CheeseConnoisseur.
     * @param name store the name of CheeseConnoisseur
     * @param hold store the object of Cheese
     * @param money store the balance of CheeseConnoisseur
     **/
    private String name;
    private Cheese hold;
    private double money;
    /**
     * a Constructor takes three parameter.
     * @param name store the name of CheeseConnoisseur
     * @param money store the balance of CheeseConnoisseur
     * @param hold store the object of Cheese
     **/
    public CheeseConnoisseur(String name, double money, Cheese hold) {
        this.name = name;
        this.money = money;
        this.hold = hold;
    }
    /**
     * a Constructor takes two parameter.
     * @param name store the name of CheeseConnoisseur
     * @param money store the balance of CheeseConnoisseur
     * set hold as null
     **/
    public CheeseConnoisseur(String name, double money) {
        this(name, money, null);
    }
    /**
     * a Constructor takes three parameter.
     * @param name store the name of CheeseConnoisseur
     * set balance as 0
     * set hold as null
     **/
    public CheeseConnoisseur(String name) {
        this(name, 0);
    }
    /**
     * a default Constructor takes no parameter.
     **/
    public CheeseConnoisseur() {
        this.name = "Louis Pastuer";
        this.hold = null;
        this.money = 20;
    }
    /**
     * a method for CheeseConnoisseur trade Cheese.
     * @param c as object Cheese
     */
    public void trade(Cheese c) {
        if (this.hold == null) {
            this.hold = c;
        } else {
            Cheese tmp = this.hold;
            this.hold = c;
            c = tmp;
            this.hold.beTraded();
            c.beTraded();
        }
    }
    /**
     * a method for CheeseConnoisseur trade Cheese with another CheeseConnoisseur.
     * this is a overloading method from above
     * @param c as object CheeseConnoisseur
     */
    public void trade(CheeseConnoisseur c) {
        try {
            if (this.hold.getType() == null || c.hold.getType() == null) {
                CheeseConnoisseur n = this;
            } else if (this.hold.equals(c.hold)) {
                CheeseConnoisseur n = this;
            } else {
                CheeseConnoisseur higher = this.hold.getPrice() > c.hold.getPrice() ? this : c;
                CheeseConnoisseur lower = this.hold.getPrice() < c.hold.getPrice() ? this : c;
                double diff = higher.hold.getPrice() - lower.hold.getPrice();
                System.out.println(diff);
                if (this.hold.getPrice() > c.hold.getPrice() && c.money >= diff) {
                    c.money -= diff;
                    this.money += diff;
                    this.hold.beTraded();
                    c.hold.beTraded();
                    Cheese tmp = this.hold;
                    this.hold = c.hold;
                    c.hold = tmp;
                } else if (this.hold.getPrice() < c.hold.getPrice() && this.money >= diff) {
                    c.money += diff;
                    this.money -= diff;
                    this.hold.beTraded();
                    c.hold.beTraded();
                    Cheese tmp = this.hold;
                    this.hold = c.hold;
                    c.hold = tmp;
                } else {
                    CheeseConnoisseur n = this;
                }
            }
        } catch (Exception e) {
            System.out.println("Fail to trade");
        }

    }
    /**
     * a method for get name from CheeseConnoisseur .
     * @return  CheeseConnoisseur name
     */
    public String getName() {
        return this.name;
    }
    /**
     * a method for get Cheese type from CheeseConnoisseur .
     * @return  CheeseConnoisseur's Cheese type
     */
    public String getCheese() {
        return this.hold.getType();
    }
    /**
     * a method for get balance from CheeseConnoisseur .
     * @return  CheeseConnoisseur balance
     */
    public double getMoney() {
        return this.money;
    }
    /**
     * a method for set name for CheeseConnoisseur .
     * @param name CheeseConnoisseur name
     */
    public void setName(String name) {
        this.name = name;
    }
    /**
     * a method for set the Cheese object for CheeseConnoisseur .
     * @param newHold Cheese name of CheeseConnoisseur
     */
    public void setCheese(Cheese newHold) {
        this.hold = newHold;
    }
    /**
     * a method for set balance from CheeseConnoisseur .
     * @param money CheeseConnoisseur balance
     */
    public void setMoney(double money) {
        this.money = money;
    }
}
