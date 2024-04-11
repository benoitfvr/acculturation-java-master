package tech.agiledev.spring.prerequisites;

import tech.agiledev.spring.prerequisites.model.*;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class SortingTest {

    @Test
    void testTrierParPrenom() {
        List<EtreHumain> etresHumains = Arrays.asList(
            new Personne(Civilites.MONSIEUR, "Alex", "Test", LocalDate.now()),
            new Personne(Civilites.MADAME, "Zoe", "Example", LocalDate.now()),
            new Personne(Civilites.MONSIEUR, "Bob", "Sample", LocalDate.now())
        );

        List<EtreHumain> sortedList = Main.trierParPrenom(etresHumains);
        assertEquals("Alex", sortedList.get(0).getPrenom());
        assertEquals("Bob", sortedList.get(1).getPrenom());
        assertEquals("Zoe", sortedList.get(2).getPrenom());
    }
}
