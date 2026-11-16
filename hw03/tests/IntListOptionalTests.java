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
}
