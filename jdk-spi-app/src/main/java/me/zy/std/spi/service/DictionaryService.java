package me.zy.std.spi.service;

import me.zy.std.spi.api.Dictionary;

import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;

/**
 * @author zhaoyang on 2020-06-19.
 */
public class DictionaryService {

    private ServiceLoader<Dictionary> serviceLoader;

    /**
     * Not allowed create DictionaryService instances from other place.
     */
    private DictionaryService() {
        // load all Dictionaries when initialized DictionaryService.
        loadServices();
    }

    public static DictionaryService getInstance() {
        return LazyHolder.SERVICE;
    }

    /**
     * Singleton instance holder
     */
    private static class LazyHolder {
        private static final DictionaryService SERVICE = new DictionaryService();
    }

    /**
     * ServiceLoader load all Dictionary.class implements
     */
    private void loadServices() {
        serviceLoader = ServiceLoader.load(Dictionary.class);
    }

    /**
     * Find definition from all loaded dictionaries.
     * If found, return the first matched definition,
     * otherwise, return null.
     *
     * @param word the query word.
     * @return The first result find from all Dictionaries.
     */
    public String getDefinition(String word) {
        String definition = null;

        try {
//            serviceLoader.reload();
            Iterator<Dictionary> dictionaries = serviceLoader.iterator();
            while (definition == null && dictionaries.hasNext()) {
                Dictionary d = dictionaries.next();
                definition = d.getDefinition(word);
            }
        } catch (ServiceConfigurationError error) {
            definition = null;
            error.printStackTrace();
        }
        return definition;
    }
}

