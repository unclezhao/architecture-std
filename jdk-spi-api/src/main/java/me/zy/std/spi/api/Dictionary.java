package me.zy.std.spi.api;

/**
 * @author zhaoyang on 2020-06-19.
 */
public interface Dictionary {

    /**
     * Get the definition of the input word.
     * @param word the query word
     * @return the definition of the word
     */
    String getDefinition(String word);

}

