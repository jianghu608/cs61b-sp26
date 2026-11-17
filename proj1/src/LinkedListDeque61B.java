import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private class Node {
        T item;
        Node prev;
        Node next;

        public Node(T item, Node prev, Node next) {
            this.item = item;
            this.prev = prev;
            this.next = next;
        }
    }

    Node sentinel;
    int size;

    public LinkedListDeque61B() {
        sentinel = new Node(null, null, null);
        size = 0;
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    /**
     * Add {@code x} to the front of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        /*
        * A - New Node - B
        * Imagine prev, next as a pointer, rather than a node.
        * The pointers that the New Node points to A & B are created by constructor,
        * so we just need to update the pointers that A & B point to the New Node.
        * */
        // Node oldFirst = sentinel.next;
        // Node newFirst = new Node(x, sentinel, oldFirst);
        // sentinel.next = newFirst;
        // oldFirst.prev = newFirst;
        sentinel.next.prev = new Node(x, sentinel, sentinel.next);  // 先更新 B -> newFirst 的指针
        sentinel.next = sentinel.next.prev; // 再更新 A (sentinel) -> newFirst 的指针
        size++;
    }

    /**
     * Add {@code x} to the back of the deque. Assumes {@code x} is never null.
     *
     * @param x item to add
     */
    @Override
    public void addLast(T x) {
        // 同上
        // Node oldLast = sentinel.prev;
        // Node newLast = new Node(x,oldLast, sentinel) 新节点指向两边
        // oldLast.next = newLast;
        // sentinel.prev = newLast;
        sentinel.prev.next = new Node(x, sentinel.prev, sentinel);
        sentinel.prev = sentinel.prev.next;
        size++;
    }

    /**
     * Returns a List copy of the deque. Does not alter the deque.
     *
     * @return a new list copy of the deque.
     */
    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<>();

        Node currentNode = sentinel.next;
        while (currentNode != sentinel) {
            returnList.add(currentNode.item);
            currentNode = currentNode.next;
        }

        return returnList;
    }

    /**
     * Returns if the deque is empty. Does not alter the deque.
     *
     * @return {@code true} if the deque has no elements, {@code false} otherwise.
     */
    @Override
    public boolean isEmpty() {
        return sentinel.next == sentinel;
    }

    /**
     * Returns the size of the deque. Does not alter the deque.
     *
     * @return the number of items in the deque.
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Return the element at the front of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getFirst() {
        return sentinel.next.item;
    }

    /**
     * Return the element at the back of the deque, if it exists.
     *
     * @return element, otherwise {@code null}.
     */
    @Override
    public T getLast() {
        return sentinel.prev.item;
    }

    /**
     * Remove and return the element at the front of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeFirst() {
        T oldFirst = sentinel.next.item;
        sentinel.next = sentinel.next.next;
        sentinel.next.prev = sentinel;
        if (size > 0) {
            size--;
        }

        return oldFirst;
    }

    /**
     * Remove and return the element at the back of the deque, if it exists.
     *
     * @return removed element, otherwise {@code null}.
     */
    @Override
    public T removeLast() {
        T oldLast = sentinel.prev.item;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.next = sentinel;
        if (size > 0) {
            size--;
        }

        return oldLast;
    }

    /**
     * The Deque61B abstract data type does not typically have a get method,
     * but we've included this extra operation to provide you with some
     * extra programming practice. Gets the element, iteratively. Returns
     * null if index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    @Override
    public T get(int index) {
        if (index < 0) {
            return null;
        }

        Node currentNode = sentinel.next;   // default index is

        int i = 0;
        while (i < index && currentNode != sentinel) {
            i++;
            currentNode = currentNode.next;
        }

        return currentNode.item;
    }

    /**
     * This method technically shouldn't be in the interface, but it's here
     * to make testing nice. Gets an element, recursively. Returns null if
     * index is out of bounds. Does not alter the deque.
     *
     * @param index index to get
     * @return element at {@code index} in the deque
     */
    private T getRecursive(Node currentNode, int index) {
        if (currentNode == sentinel || index == 0) {
            return currentNode.item;
        }

        return getRecursive(currentNode.next, index - 1);
    }
    @Override
    public T getRecursive(int index) {
        if (index < 0) {
            return null;
        }
        return getRecursive(sentinel.next, index);
    }

    public static void main(String[] args) {
        Deque61B<Integer> lld = new LinkedListDeque61B<>(); // []
        lld.addLast(0); // [0]
        lld.addLast(1); // [0, 1]
        lld.addFirst(-1);   // [-1, 0, 1]
    }
}
