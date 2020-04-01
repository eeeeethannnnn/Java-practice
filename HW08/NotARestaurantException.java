// I worked on the homework assignment alone, using only course materials.
/**
 * a NotARestaurantException Exception class.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class NotARestaurantException extends RuntimeException  {
    /**
     * a constructor for NotARestaurantException.
     * call super constructor with a String parmeter
     *
     */
    public NotARestaurantException() {
        super("That is not a restaurant we know!");
    }
}
