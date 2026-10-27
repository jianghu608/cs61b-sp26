public class IntList {

    int first;
    IntList rest;

    public IntList(int first, IntList rest) {
        this.first = first;
        this.rest = rest;
    }

    // 获取长度
    public int size() {
    /*
        int result = 0;
        IntList list = this;

        while (list != null) {
            result++;
            list = list.rest;
        }
        return result;
     */
        if (rest == null) { return 1; }
        return rest.size() + 1;
    }

    public int get(int index) {
        /*
        IntList list = this;
        for (int i = 0; i < index; i++) { list = list.rest; }
        return list.first;
        */
        if (index == 0) { return this.first; }
        return this.rest.get(index - 1);
    }

    public IntList incrementRecursiveNonDestructive() {
        if (this.rest == null) { return new IntList(this.first + 1, null); }
        return new IntList(this.first + 1, this.rest.incrementRecursiveNonDestructive());
    }

    public static void main() {

        IntList l1 = new IntList(5, null);
        l1.rest = new IntList(10, null);
        l1.rest.rest = new IntList(15, null);

        IntList l2 = new IntList(5, new IntList(10, new IntList (15, null)));

        IntList l3 = new IntList(15, null);
        l3 = new IntList(10, l3); // l3 = (10, 15, )
        l3 = new IntList(5, l3);

        IO.println("The size of l1 is " + l1.size());
        IO.println("The size of l2 is " + l2.size());
        IO.println("The size of l3 is " + l3.size());
    }

}
