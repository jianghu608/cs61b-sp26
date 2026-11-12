public class SLList {
    private IntNode sentinel;

    // EMPTY
    // Set sentinel IntNode. Always modify sentinel.next
    public SLList() {
        sentinel = new IntNode(6, null);
    }

    public SLList(int x) {
        sentinel = new IntNode(6, null);
        sentinel.next = new IntNode(x, null);
    }

    public void addFirst(int x) {
        sentinel.next = new IntNode(x, sentinel.next);
    }

    public int getFirst() {
        return sentinel.next.item;
    }

    private static int size(IntNode p) {
        if (p.next == null) {
            return 0;
        }
        return size(p.next) + 1;
    }

    public int size() {
        return size(sentinel.next);
    }

    public void addLast(int x) {
        IntNode p = sentinel;
        while (p.next != null) {
            p = p.next;
        }
        p.next = new IntNode(x, null);
    }

    public static void main() {
        SLList L = new SLList(5);
        IO.println(L.getFirst());

        L.addFirst(10);
        IO.println(L.getFirst());
    }
}
