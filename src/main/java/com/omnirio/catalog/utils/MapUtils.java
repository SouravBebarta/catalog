package com.omnirio.catalog.utils;

import java.util.HashMap;
import java.util.Map;

public class MapUtils {

    public static Map<String, Object> convertStringToMap(String value) {
        value = value.substring(1, value.length() - 1);
        String[] keyValuePairs = value.split(",");
        Map<String, Object> map = new HashMap<>();
        for (String pair : keyValuePairs) {
            String[] entry = pair.split("=");
            map.put(entry[0].trim(), entry[1].trim());
        }
        return map;
    }
}
