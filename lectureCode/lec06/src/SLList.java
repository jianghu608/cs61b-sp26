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

    public static void main() {
        SLList L = new SLList(5);
        IO.println(L.getFirst());

        L.addFirst(10);
        IO.println(L.getFirst());
    }
}
