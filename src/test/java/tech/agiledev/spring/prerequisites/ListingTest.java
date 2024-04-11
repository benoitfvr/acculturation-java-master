package tech.agiledev.spring.prerequisites;

import tech.agiledev.spring.prerequisites.model.*;
import java.util.List;
import java.util.Arrays;
import java.time.LocalDate;
import java.time.Month;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;


class ListingTest {

    @Test
    void testListerPrenoms() {
        List<EtreHumain> etresHumains = Arrays.asList(
            new Personne(Civilites.MONSIEUR, "Alex", "Test", LocalDate.now()),
            new Personne(Civilites.MADAME, "Zoe", "Example", LocalDate.now())
        );

        List<String> prenoms = Main.listerPrenoms(etresHumains);
        assertTrue(prenoms.containsAll(Arrays.asList("Alex", "Zoe")));
    }

    @Test
    void testListerVilles() {
        Personne personne1 = new Personne(Civilites.MONSIEUR, "John", "Doe", LocalDate.now());
        personne1.setAdresse(new Adresse("123", "Main St", 12345, "Springfield"));
        Personne personne2 = new Personne(Civilites.MADAME, "Jane", "Doe", LocalDate.now());
        personne2.setAdresse(new Adresse("456", "Elm St", 67890, "Shelbyville"));

        List<String> villes = Main.listerVilles(Arrays.asList(personne1, personne2));
        assertTrue(villes.containsAll(Arrays.asList("Springfield", "Shelbyville")));
    }
}
