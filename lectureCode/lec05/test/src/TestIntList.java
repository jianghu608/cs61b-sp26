import org.junit.jupiter.api.Test;

import static com.google.common.truth.Truth.assertThat;

public class TestIntList {
    @Test
    public void testIntList() {
        IntList l2 = new IntList(5, new IntList(10, new IntList (15, null)));

        assertThat(l2.size()).isEqualTo(3);

        assertThat(l2.get(0)).isEqualTo(5);
        assertThat(l2.get(1)).isEqualTo(10);
        assertThat(l2.get(2)).isEqualTo(15);

        assertThat(l2.incrementRecursiveNonDestructive().get(0)).isEqualTo(6);
        assertThat(l2.incrementRecursiveNonDestructive().get(1)).isEqualTo(11);
        assertThat(l2.incrementRecursiveNonDestructive().get(2)).isEqualTo(16);
    }

}
