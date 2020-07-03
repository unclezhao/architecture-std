package me.zy.std.consistenthash;

import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhaoyang on 2020-07-02.
 */
public class ConsistentHashMapper {

    private final HashFunction hashFunction;
    private final int virtualNodeNum;
    private TreeMap<Long, ServerNode> hashRing = new TreeMap<>();

    public ConsistentHashMapper(HashFunction hashFunction) {
        this(hashFunction, 0);
    }

    public ConsistentHashMapper(HashFunction hashFunction, int virtualNodeNum) {
        if (virtualNodeNum < 0 || virtualNodeNum > 1000) {
            throw new IllegalArgumentException("virtual node number must between 0 and 1000");
        }
        this.hashFunction = hashFunction;
        this.virtualNodeNum = virtualNodeNum;
    }

    /**
     * Mapping kvData's key to hash ring,
     * and return the mapped ServerNode.
     *
     * @param nodeList ServerNode list
     * @param kvData KvData for mapping
     * @return ServerNode mapped by kvData
     */
    public ServerNode mapping(List<ServerNode> nodeList, KvData<String, Object> kvData) {
        if (nodeList == null || nodeList.isEmpty()) {
            throw new IllegalArgumentException("node list can not be null or empty");
        }
        if (kvData == null || kvData.key() == null || "".equals(kvData.key())) {
            throw new IllegalArgumentException("kvData's hashKey is null or empty");
        }
        long hashValue = hashFunction.hash(kvData.key());
        if (hashRing == null || hashRing.isEmpty()) {
            hashRing = buildHashRing(nodeList);
        }
        return locate(hashRing, hashValue);
    }

    /**
     * Addressing for hashValue in hash ring, return the first mapped ServerNode.
     * if not mapped util to the end, return the first ServerNode in the hash ring.
     *
     * @param hashRing hash ring with mapped ServerNode list
     * @param hashValue hash value need to addressing
     * @return ServerNode
     */
    private ServerNode locate(TreeMap<Long, ServerNode> hashRing, long hashValue) {
        Map.Entry<Long, ServerNode> entry = hashRing.ceilingEntry(hashValue);
        if (entry == null) {
            entry = hashRing.firstEntry();
        }
        return entry.getValue();
    }

    /**
     * Build the hash ring with input ServerNode list if hash ring not be built.
     * If #{code virtualNodeNum} larger than zero, the hash ring will build with virtual nodes.
     * The result is a TreeMap<Long, ServerNode>,
     * the map key is ServerNode's #{code HashFunction.hash(ServerNode.nodeKey())},
     * and the map value is ServerNode.
     *
     * @param nodeList ServerNode list
     * @return ServerNode mapping info map
     */
    private TreeMap<Long, ServerNode> buildHashRing(List<ServerNode> nodeList) {
        TreeMap<Long, ServerNode> virtualNodeMap = new TreeMap<>();
        // no virtual node number set, just add real node
        if (virtualNodeNum <= 0) {
            addRealNodes(virtualNodeMap, nodeList);
        } else {
            addVirtualNodes(virtualNodeMap, nodeList);
        }
        return virtualNodeMap;
    }

    private void addRealNodes(TreeMap<Long, ServerNode> virtualNodeMap, List<ServerNode> nodeList) {
        for (ServerNode node : nodeList) {
            virtualNodeMap.put(hashFunction.hash(node.nodeKey()), node);
        }
    }

    private void addVirtualNodes(TreeMap<Long, ServerNode> virtualNodeMap, List<ServerNode> nodeList) {
        for (ServerNode node : nodeList) {
            for (int i = 0; i < virtualNodeNum; i++) {
                // all mapped node is virtual node
                virtualNodeMap.put(hashFunction.hash(node.nodeKey() + String.format("%03d", i)), node);
            }
        }
    }

}
