package me.zy.std.spi.app;

import me.zy.std.spi.service.DictionaryService;

/**
 * @author zhaoyang on 2020-06-19.
 */
public class DictionaryApp {

    /**
     * Using <code>DictionaryService</code> to look up the word definition.
     * @param dictService concrete look up service
     * @param word the query word
     * @return the definition of the word
     */
    public static String lookup(DictionaryService dictService, String word) {
        String output = word + ": ";
        String definition = dictService.getDefinition(word);
        if (definition == null) {
            return output + "Cannot find definition for this word.";
        } else {
            return output + definition;
        }
    }

    public static void main(String[] args) {
        DictionaryService dictService = DictionaryService.getInstance();
        System.out.println(lookup(dictService, "book"));
        System.out.println(lookup(dictService, "editor"));
        System.out.println(lookup(dictService, "xml"));
        System.out.println(lookup(dictService, "REST"));
        System.out.println(lookup(dictService, "not-exist"));
        System.out.println(lookup(dictService, "book"));
    }
}

