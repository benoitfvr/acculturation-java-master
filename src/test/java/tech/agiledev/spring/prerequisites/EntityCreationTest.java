package tech.agiledev.spring.prerequisites;

import tech.agiledev.spring.prerequisites.model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.time.LocalDate;
import java.time.Month;

class EntityCreationTest {

    @Test
    void testAnimalCreation() {
        Animal animal = new Animal("TestName", "TestBreed", LocalDate.of(2020, Month.JANUARY, 1));
        assertNotNull(animal);
        assertEquals("TestName", animal.getPrenom());
        assertEquals("TestBreed", animal.getRace());
        assertEquals(LocalDate.of(2020, Month.JANUARY, 1), animal.getDateNaissance());
    }

    @Test
    void testPersonneCreation() {
        Personne personne = new Personne(Civilites.MONSIEUR, "John", "Doe", LocalDate.of(1990, Month.JANUARY, 1));
        assertNotNull(personne);
        assertEquals(Civilites.MONSIEUR, personne.getCivilite());
        assertEquals("John", personne.getPrenom());
        assertEquals("Doe", personne.getNom());
    }
}
