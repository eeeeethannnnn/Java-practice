// I worked on the homework assignment alone, using only course materials.
/**
 * a ReviewNotFoundException Exception class.
 * @author Shen-Yi Cheng
 * @version 1.0
 */
public class ReviewNotFoundException extends Exception {
    /**
     * a ReviewNotFoundException constructor.
     * call super constructor with a String parmeter
     * @param input a input String to be thrown as an exception message
     */
    public ReviewNotFoundException(String input) {
        super(input);
    }
}
