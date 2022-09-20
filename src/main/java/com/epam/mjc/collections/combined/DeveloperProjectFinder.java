package com.epam.mjc.collections.combined;

import java.util.*;
import java.util.stream.Collectors;

public class DeveloperProjectFinder {
    public List<String> findDeveloperProject(Map<String, Set<String>> projects, String developer) {
        return projects.entrySet().stream()
                .flatMap(entry -> entry.getValue().stream()
                        .map(v -> new AbstractMap.SimpleEntry<>(v, entry.getKey())))
                .collect(Collectors.groupingBy(Map.Entry::getKey, Collectors.mapping(Map.Entry::getValue, Collectors.toSet())))
                .entrySet().stream()
                .filter(s -> s.getKey().equals(developer))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList())
                .stream()
                .flatMap(Collection::stream)
                .sorted(Comparator.comparing(String::length).thenComparing(Comparator.naturalOrder()).reversed())
                .collect(Collectors.toList());
    }
}
