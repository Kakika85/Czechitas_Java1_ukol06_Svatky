package cz.czechitas.ukol06.svatky;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.time.MonthDay;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SvatkySluzbaTest {

    @Test
    void vyhledatSvatkyKeDni() throws IOException {
        // implementovat test metody vyhledatSvatkyKeDni (jeden svátek, více svátků, žádný svátek)

        MonthDay day = MonthDay.of(12, 2);
        SvatkySluzba svatky = new SvatkySluzba();

        List<String> kdoMaSvatek = svatky.vyhledatSvatkyKeDni(day);

        Assertions.assertEquals(1, kdoMaSvatek.size());
        Assertions.assertEquals("Blanka", kdoMaSvatek.getFirst());
    }

    @Test
        void vyhledejSvatkyKeDni() throws IOException{
        // více svátků
        MonthDay day = MonthDay.of(11, 20);
        SvatkySluzba svatky = new SvatkySluzba();

        List<String> kdoMaSvatek = svatky.vyhledatSvatkyKeDni(day);

        Assertions.assertEquals(3, kdoMaSvatek.size());
        Assertions.assertEquals("Nikola", kdoMaSvatek.get(0));
        Assertions.assertEquals( "Niké", kdoMaSvatek.get(1));
        Assertions.assertEquals("Nikita", kdoMaSvatek.get(2));
    }

    @Test
    void vyhledejSvatkyKeDni2() throws IOException {
        // žádný svátek

        MonthDay day = MonthDay.of(12, 25);
        SvatkySluzba svatky = new SvatkySluzba();

        List<String> kdoMaSvatek = svatky.vyhledatSvatkyKeDni(day);

        Assertions.assertEquals(0, kdoMaSvatek.size());
    }
}
