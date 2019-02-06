package com.kodilla.good.patterns.challenges;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static java.util.stream.Collectors.joining;

public final class MovieStore {

    public static Map<String, List<String>> getMovies() {

        List<String> ironManTranslations = new ArrayList<>();
            ironManTranslations.add("Żelazny Człowiek");
            ironManTranslations.add("Iron Man");

        List<String> avengersTranslations = new ArrayList<>();
            avengersTranslations.add("Mściciele");
            avengersTranslations.add("Avengers");

        List<String> flashTranslations = new ArrayList<>();
            flashTranslations.add("Błyskawica");
            flashTranslations.add("Flash");

        final Map<String, List<String>> booksTitlesWithTranslations = new HashMap<>();
            booksTitlesWithTranslations.put("IM", ironManTranslations);
            booksTitlesWithTranslations.put("AV", avengersTranslations);
            booksTitlesWithTranslations.put("FL", flashTranslations);

        return new HashMap<>(booksTitlesWithTranslations);
    }

    public static void main(String []args){
            String filmTitles = MovieStore.getMovies().entrySet().stream()
                .map(Map.Entry::getValue)
                .flatMap(entry->entry.stream())
                .collect(joining("!","",""));

        System.out.println(filmTitles);

    }
}
