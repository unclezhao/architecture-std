package me.zy.std.spi.impl;

import me.zy.std.spi.api.Dictionary;

import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author zhaoyang on 2020-06-19.
 */
public class GeneralDictionary implements Dictionary {

    private SortedMap<String, String> map;

    public GeneralDictionary() {
        System.out.println("GeneralDictionary loaded");
        map = new TreeMap<>();
        map.put("book", "a set of written or printed pages, usually bound with " +
            "a protective cover");
        map.put("editor", "a person who edits");
    }

    @Override
    public String getDefinition(String word) {
        return map.get(word);
    }
}
