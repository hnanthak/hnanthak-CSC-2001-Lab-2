import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

   @Test
    void daysInMonth() {
        assertEquals(31, Main.daysInMonth(1));
        assertEquals(31, Main.daysInMonth(2));
        assertEquals(30, Main.daysInMonth(9));}
    @Test
    void tommorow(){
       //random date
       assertEquals(
               new Main.date(10,7,2026),
               Main.tommorow(9,7,2026)
       );
       //end of month
        assertEquals(
                new Main.date(1,2,2026),
                Main.tommorow(31,1,2026)
        );
        //end of year
        assertEquals(
                new Main.date(1,1,2027),
                Main.tommorow(31,12,2026)
        );




    }

    @Test
    void daysOfYear(){
       assertEquals(159,Main.daysOfYear(9,6));
       assertEquals(0,Main.daysOfYear(1,1));
        assertEquals(1,Main.daysOfYear(2,1));
    }

    @Test
    void comesBefore(){
        assertEquals(true, Main.comesBefore(1, 1, 2025, 1, 1, 2025));
        assertEquals(true, Main.comesBefore(20, 12, 2024, 1, 1, 2025));
        assertEquals(false, Main.comesBefore(1, 1, 2026, 31, 12, 2025));
    }
    @Test
    void invalidDates() {


        assertThrows(IllegalArgumentException.class, () -> {new Main.date(32, 1, 2025);});

        assertThrows(IllegalArgumentException.class, () -> {new Main.date(0, 1, 2025);});
    }


}