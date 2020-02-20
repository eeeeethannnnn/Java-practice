//I worked on the homework assignment alone, using only course materials.
/** * Program for Cheese class.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class Cheese {
    /**
     * private attribute of this Cheese.
     * @param type store the name of cheese
     * @param price store the price of Cheese
     * @param sentient store the status of Cheese
     * @param trade store the trade times for cheese
     * */
    private String type;
    private double price;
    private boolean sentient;
    private int trade;
    private static int totalTrade = 0;
    /**
     * a default Constructor.
     */
    public Cheese() {
        this.price = 0;
        this.type = "null";
        this.trade = 0;
    }
    /**
     * a Constructor takes three parameter.
     * @param price for input price.
     * @param type for input type.
     * @param trade for input trade time.
     */
    public Cheese(double price, String type, int trade) {
        this.price = price;
        this.type = type;
        this.trade = trade;
        setsentient();
    }
    /**
     * a Constructor takes two parameter.
     * @param price for input price.
     * @param type for input type.
     */
    public Cheese(double price, String type) {
        this.price = price;
        this.type = type;
        this.trade = 0;
    }
    /**
     * a Constructors take one parameter.
     * @param type for input type.
     */
    public Cheese(String type) {
        this.type = type;
    }
    /**
     * a method for set price.
     * @param price double
     */
    public void setPrice(double price) {
        this.price = price;
    }
    /**
     * a method for set type.
     * @param type String
     */
    public void setType(String type) {
        this.type = type;
    }
    /**
     * a method for set trade.
     * @param trade int
     */
    public void setTrade(int trade) {
        this.trade = trade;
    }
    /**
     * a method for check sentient.
     */
    public void setsentient() {
        if (this.trade >= 3) {
            this.sentient = true;
        } else {
            this.sentient = false;
        }
    }
    /**
     * a method for get price.
     * @return price double
     */
    public double getPrice() {
        return this.price;
    }
    /**
     * a method for get type.
     * @return type String
     */
    public String getType() {
        return this.type;
    }
    /**
     * a method for get trade.
     * @return trade int
     */
    public int getTrade() {
        return this.trade;
    }
    /**
     * a method for get sentient status.
     * @return sentient boolean
     */
    public boolean getsentient() {
        return this.sentient;
    }
    /**
     * a method for announce the sentient status for cheese.
     * @return status String
     */
    public String toString() {
        String s;
        if (this.sentient) {
            s = "This is a slice of " + this.type + " cheese that has been traded " + this.trade + " times.";
        } else {
            s = "I am a slice of " + this.type + " cheese that has been traded " + this.trade + " times.";
        }
        return s;
    }
    /**
     * a method for check two cheese are identical.
     * @param c object of Cheese class
     * @return true or false
     */
    public boolean equals(Cheese c) {
        return (this.type == c.type && this.price == c.price && this.sentient == c.sentient);
    }
    /**
     * a method for count each and total trade times.
     * @return String if the cheese is sentient
     */
    public String beTraded() {
        totalTrade++;
        this.trade++;
        if (this.trade >= 3 && this.sentient) {
            this.price *= 2;
            this.sentient = true;
            System.out.println("I’m ALIIIIIVE!");
        }
        return null;
    }
}
