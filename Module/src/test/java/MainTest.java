import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void daysInMonth() {
        assertEquals(31, Main.daysInMonth(1));
        assertEquals(31, Main.daysInMonth(2));
        assertEquals(30, Main.daysInMonth(9));
    }

}
