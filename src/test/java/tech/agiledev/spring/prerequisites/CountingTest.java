package tech.agiledev.spring.prerequisites;

import tech.agiledev.spring.prerequisites.model.*;
import java.util.List;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import java.time.Month;


class CountingTest {

    @Test
    void testCompter() {
        List<Personne> personnes = Arrays.asList(
            new Personne(Civilites.MONSIEUR, "John", "Doe", LocalDate.now()),
            new Personne(Civilites.MADAME, "Jane", "Doe", LocalDate.now())
        );

        assertEquals(2, Main.compter(personnes));
    }

    @Test
    void testCompterWithCondition() {
        List<Personne> personnes = Arrays.asList(
            new Personne(Civilites.MONSIEUR, "John", "Doe", LocalDate.now()),
            new Personne(Civilites.MADAME, "Jane", "Doe", LocalDate.now()),
            new Personne(Civilites.MONSIEUR, "Jack", "Smith", LocalDate.now())
        );

        assertEquals(2, Main.compter(personnes, "Doe"));
    }
}
