package me.zy.std.consistenthash;

/**
 * @author zhaoyang on 2020-07-03.
 */
public interface ServerNode {

    /**
     * Server node identify key for mapping to hash ring
     *
     * @return node key value
     */
    String nodeKey();

}
