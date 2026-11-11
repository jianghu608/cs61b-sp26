public class SLList {
    private IntNode first;

    public SLList(int x) {
        first = new IntNode(x, null);
    }

    public void addFirst(int x) {
        first = new IntNode(x, first);
    }

    public int getFirst() {
        return first.item;
    }

    private static int size(IntNode p) {
        if (p.next == null) {
            return 1;
        }
        return size(p.next) + 1;
    }

    public int size() {
        return size(first);
    }

    public void addLast(int x) {
        IntNode p = first;
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
