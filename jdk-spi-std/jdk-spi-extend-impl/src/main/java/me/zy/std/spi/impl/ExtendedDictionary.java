package me.zy.std.spi.impl;

import me.zy.std.spi.api.Dictionary;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author zhaoyang on 2020-06-19.
 */
public class ExtendedDictionary implements Dictionary {

    private SortedMap<String, String> map;

    public ExtendedDictionary() {
        System.out.println("ExtendedDictionary loaded");
        map = new TreeMap<>();
        map.put("xml", "a document standard often used in web services, among other things");
        map.put("REST", "an architecture style for creating, reading, updating, " +
            "and deleting data that attempts to use the common " +
            "vocabulary of the HTTP protocol; Representational State " +
            "Transfer");
    }

    @Override
    public String getDefinition(String word) {
        return map.get(word);
    }
}
