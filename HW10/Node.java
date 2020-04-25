/**
 * @author Shen Yi Cheng
 * @version 1.0
 * @param <T> generic type
 */
public class Node<T> {
    /**
     * a class for Node.
     * @param <T> generic type
     */
    private T data;
    private Node<T> next;

    /**
     * a constructor for Node.
     * @param data input data
     * @param next next node
     */
    public Node(T data, Node<T> next) {
        this.data = data;
        this.next = next;
    }

    /**
     * a constructor for Node.
     * @param data input data
     */
    public Node(T data) {
        this.data = data;
        this.next = null;
    }

    /**
     * a method for get private data.
     * @return this data
     */
    public T getData() {
        return this.data;
    }

    /**
     * a method for get next node.
     * @return this next
     */
    public Node<T> getNext() {
        return this.next;
    }
    /**
     * a method for set next node.
     * @param newNode generic type
     */
    public void setNext(Node<T> newNode) {
        this.next = newNode;
    }
}
