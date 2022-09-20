package com.epam.mjc.collections.combined;

import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MapFromKeysCreator {
    public Map<Integer, Set<String>> createMap(Map<String, Integer> sourceMap) {
        return sourceMap.keySet().stream().collect(Collectors.groupingBy(String :: length, Collectors.toSet()));
    }
}
