/**
 * @author Shen Yi Cheng
 * @version 1.0
 * @param <T> generic type
 */
public class LinkedList<T> implements List<T>, Queue<T> {
    private Node<T> head;
    private Node<T> tail;

    /**
     * a constructor for Linked list.
     */
    public LinkedList() {
        head = null;
        tail = null;
    }

    @Override
    public void add(int index, T data) {
        if (index < 0 || index > this.size() || data == null) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            addFirst(data);
        } else if (index == size()) {
            addLast(data);
        } else {
            Node toAdd = new Node(data, null);
            if (index == 0) {
                head = toAdd;
                tail = toAdd;
            } else {
                Node current = head;
                for (int i = 0; i < index - 1; ++i) {
                    current = current.getNext();
                }
                Node<T> temp = current.getNext();
                current.setNext(new Node<>(data));
                current.getNext().setNext(temp);
            }
        }
    }

    /**
     * a method for add First.
     * @param data as insert data
     */
    public void addFirst(T data) {
        Node<T> newNode = new Node(data);
        //newNode.next = head;
        newNode.setNext(head);
        head = newNode;
        if (tail == null) {
            tail = head;
        }
    }
    /**
     * a method for add last.
     * @param data as insert data
     */
    public void addLast(T data) {
        Node<T> newNode = new Node(data);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            //tail.next = newNode;
            tail.setNext(newNode);
            tail = newNode;
        }
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size()) {
            throw new IllegalArgumentException();
        } else if (index == 0) {
            if (size() == 0) {
                throw new IllegalArgumentException();
            } else {
                return (removeFirst());
            }
        } else if (index == size() - 1) {
            return (removeLast());
        } else {
            Node<T> previous = head;
            for (int i = 1; i < index; i++) {
                previous = previous.getNext();
            }
            Node<T> current = previous.getNext();
            previous.setNext(current.getNext());
            return current.getData();
        }
    }
    /**
     * a method for remove First.
     * @return data at remove index
     */
    public T removeFirst() {
        if (size() == 0) {
            return null;
        } else {
            T temp = head.getData();
            head = head.getNext();
            if (head == null) {
                tail = null;
            }
            return temp;
        }
    }
    /**
     * a method for remove last.
     * @return data at remove index
     */
    public T removeLast() {
        if (size() == 0 || size() == 1) {
            return removeFirst();
        } else {
            Node<T> current = head;
            for (int i = 0; i < size() - 2; i++) {
                current = current.getNext();
            }
            T temp = tail.getData();
            tail = current;
            tail.setNext(null);
            return temp;
        }
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        if (index < 0 || index > this.size()) {
            throw new IllegalArgumentException();
        } else {
            int count = 0;
            while (current != null) {
                if (count == index) {
                    return current.getData();
                }
                count++;
                current = current.getNext();
            }
        }
        throw new IllegalArgumentException();
    }

    @Override
    public List<T> subList(int n) {
        LinkedList newList = new LinkedList();
        int count = 0;
        if (n < 0) {
            throw new IllegalArgumentException();
        } else if (n == 0) {
            return newList;
        } else {
            while (count < n) {
                if (count == size()) {
                    return newList;
                }
                newList.add(count, this.get(count));
                count++;
            }
            return newList;
        }
    }

    @Override
    public int size() {
        if (head == null) {
            return 0;
        }
        Node tmp = head;
        int count = 0;
        while (tmp != null) {
            count++;
            tmp = tmp.getNext();
        }
        return count;
    }

    @Override
    public void enqueue(T data) {
        if (data == null) {
            throw new IllegalArgumentException();
        } else {
            addFirst(data);
        }
    }

    @Override
    public T dequeue() {
        if (this.size() == 0) {
            throw new IllegalArgumentException();
        } else {
            return (removeLast());
        }
    }
}
