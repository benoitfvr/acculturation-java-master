package tech.agiledev.spring.prerequisites;

import java.time.LocalDate;
import java.time.Month;
import java.util.*;
import java.util.stream.Collectors;
import tech.agiledev.spring.prerequisites.model.*;

public class Main {

    private static List<Personne> personnes = new ArrayList<>();
    private static List<Animal> animaux = new ArrayList<>();
    private static List<EtreHumain> etresHumains = new ArrayList<>();

    private static void initPopulation() {
        Animal divine = new Animal("Divine", "Européen", LocalDate.of(2009, Month.JULY, 7));
		animaux.add(divine);
		Animal haskell = new Animal("Haskell", "Européen", LocalDate.of(2013, Month.SEPTEMBER, 1));
		animaux.add(haskell);
		Animal milou = new Animal("Milou", "Chartreux", LocalDate.of(2019, Month.NOVEMBER, 2));
		animaux.add(milou);
		Animal filou = new Animal("Filou", "Teckel", LocalDate.of(2019, Month.OCTOBER, 24));
		animaux.add(filou);
		Animal rex = new Animal("Rex", "Caniche", LocalDate.of(2016, Month.SEPTEMBER, 21));
		animaux.add(rex);
		Animal animalEric = new Animal("Eric", "Caniche", LocalDate.of(2013, Month.JANUARY, 21));
		animaux.add(animalEric);
		
		Personne eric = new Personne(Civilites.MONSIEUR, "Eric", "Siber", LocalDate.of(1981, Month.AUGUST, 29));
		eric.setAdresse(new Adresse("105", "avenue Général De Gaulle", 78500, "Sartrouville"));
		eric.getAnimaux().add(divine);
		eric.getAnimaux().add(haskell);
		personnes.add(eric);
		
		Personne timo = new Personne(Civilites.MONSIEUR, "Timo", "Siber", LocalDate.of(2016, Month.OCTOBER, 8));
		timo.setAdresse(new Adresse("105", "avenue Général De Gaulle", 78500, "Sartrouville"));
		timo.getAnimaux().add(milou);
		personnes.add(timo);
		
		Personne jean = new Personne("Monsieur", "Jean", "Dupond", LocalDate.of(1978, Month.OCTOBER, 29));
		jean.setAdresse(new Adresse("12", "avenue de la République", 75001, "Paris"));
		personnes.add(jean);
		
		Personne marie = new Personne(Civilites.MADAME, "Marie", "Dupond", LocalDate.of(1980, Month.SEPTEMBER, 10));
		marie.setAdresse(new Adresse("105", "avenue de la République", 75001, "Paris"));
		marie.getAnimaux().add(rex);
		personnes.add(marie);

        etresHumains.addAll(animaux);
        etresHumains.addAll(personnes);
    }

    public static List<EtreHumain> trierParPrenom(List<EtreHumain> elements) {
        return elements.stream()
                .sorted(Comparator.comparing(EtreHumain::getPrenom))
                .collect(Collectors.toList());
    }

    public static long compter(List<?> elements) {
        return elements.stream().count();
    }

    public static long compter(List<Personne> elements, String nom) {
        return elements.stream()
                .filter(personne -> nom.equals(personne.getNom()))
                .count();
    }

    public static List<String> listerPrenoms(List<EtreHumain> elements) {
        return elements.stream()
                .map(EtreHumain::getPrenom)
                .collect(Collectors.toList());
    }

    public static List<String> listerVilles(List<Personne> elements) {
        return elements.stream()
                .map(Personne::getAdresse)
                .filter(Objects::nonNull)
                .map(Adresse::getVille)
                .distinct()
                .collect(Collectors.toList());
    }

    private static List<String> listerRaces(List<Personne> elements) {
        return elements.stream()
                .flatMap(personne -> personne.getAnimaux().stream())
                .map(Animal::getRace)
                .collect(Collectors.toList());
    }

    private static Map<String, Long> compterHabitantsParVille(List<Personne> elements) {
        return elements.stream()
                .collect(Collectors.groupingBy(
                        personne -> Optional.ofNullable(personne.getAdresse())
                                .map(Adresse::getVille).orElse("Sans Adresse"),
                        Collectors.counting()));
    }

    public static void main(String[] args) {
        initPopulation();

        System.out.println("Personnes triées par prénom: " + trierParPrenom(new ArrayList<>(etresHumains)));
        System.out.println("Nombre total d'êtres humains: " + compter(etresHumains));
        System.out.println("Nombre de personnes nommées 'Siber': " + compter(personnes, "Siber"));
        System.out.println("Liste des prénoms: " + listerPrenoms(etresHumains));
        System.out.println("Liste des villes: " + listerVilles(personnes));
        System.out.println("Liste des races d'animaux: " + listerRaces(personnes));
        System.out.println("Nombre d'habitants par ville: " + compterHabitantsParVille(personnes));
    }
}
