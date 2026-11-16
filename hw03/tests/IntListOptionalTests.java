import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;

import static com.google.common.truth.Truth.assertThat;
import static org.junit.Assert.fail;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class IntListOptionalTests {
    // TBD



    @Test
    public void testSum() {
        IntList L1 = new IntList(5,new IntList(10, new IntList(15, null)));
        IntList L2 = new IntList(30,new IntList(0, new IntList(2, new IntList(3, null))));

        assertThat(L1.sum()).isEqualTo(30);
        assertThat(L2.sum()).isEqualTo(35);
    }

    @Test
    public void testAddLast() {
        IntList L = new IntList(5, null);

        L.addLast(10);
        assertThat(L.get(1)).isEqualTo(10);

        L.addLast(15);
        assertThat(L.get(2)).isEqualTo(15);
    }

    @Test
    public void testAddFirst() {
        IntList L = new IntList(15, null);

        L.addFirst(10);
        assertThat(L.first).isEqualTo(10);

        L.addFirst(15);
        assertThat(L.first).isEqualTo(15);
    }

}
