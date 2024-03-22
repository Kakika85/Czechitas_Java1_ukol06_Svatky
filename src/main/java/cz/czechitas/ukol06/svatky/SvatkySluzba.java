package cz.czechitas.ukol06.svatky;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.time.MonthDay;
import java.util.List;

public class SvatkySluzba {

    private final ObjectMapper objectMapper = JsonMapper.builder()
        .addModule(new JavaTimeModule())
        .build();
    private final Path cestaKDatum = Path.of("data/svatky.json");
    private final SeznamSvatku seznamSvatku;

    public SvatkySluzba() throws IOException {
        // načíst seznam svátků ze souboru svatky.json

        seznamSvatku = objectMapper.readValue(cestaKDatum.toFile(), SeznamSvatku.class);
        // Následující řádek po vlastní implementaci smažete.
    }

    public List<String> vyhledatSvatkyDnes() {
        return vyhledatSvatkyKeDni(MonthDay.now());
    }

    public List<String> vyhledatSvatkyKeDni(MonthDay day) {
        // získat seznam svátků
        List<Svatek> svatky = seznamSvatku.getSvatky();
        // převést na Stream
        // pomocí metody filter() vybrat jen ty, které odpovídají zadanému dni (porovnat MonthDay pomocí metodyequals())
        // pomocí metody map() získat z objektu jméno
        // pomocí toList() převést na List
        return svatky.stream()
            .filter(svatek ->
                day.equals(svatek.getDen())
            )
            .map(Svatek::getJmeno)  // říká vem si jmeno z třidy svátek a provolávej
            .toList();
    }
}
