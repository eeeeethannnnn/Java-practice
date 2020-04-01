// I worked on the homework assignment alone, using only course materials.


/**
 * a Restaurant class.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class Restaurant {
    private String name;
    private int numReviews;
    /**
     * a constructor for Restaurant with two parameters.
     * @param name restaurant name
     * @param numReviews count of reviews
     *
     */
    public Restaurant(String name, int numReviews) {
        this.name = name;
        this.numReviews = numReviews;
    }
    /**
     * a getter for Restaurant .
     * @return restaurant name
     *
     */
    public String getName() {
        return this.name;
    }
    /**
     * a getter for count of reviews .
     * @return count of reviews
     *
     */
    public int getNumReviews() {
        return this.numReviews;
    }

}
