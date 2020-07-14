package me.zy.std.consistenthash;

import com.google.common.util.concurrent.AtomicLongMap;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import static org.junit.Assert.assertNotNull;

/**
 * @author zhaoyang on 2020-07-03.
 */
public class TestConsistentHashMapper {

    /**
     * Mock ServerNode list
     */
    private static final List<ServerNode> nodeList = Arrays.asList(
        () -> newServerNodeKey("server01"),
        () -> newServerNodeKey("server02"),
        () -> newServerNodeKey("server03"),
        () -> newServerNodeKey("server04"),
        () -> newServerNodeKey("server05"),
        () -> newServerNodeKey("server06"),
        () -> newServerNodeKey("server07"),
        () -> newServerNodeKey("server08"),
        () -> newServerNodeKey("server09"),
        () -> newServerNodeKey("server10")
    );

    private static String newServerNodeKey(String name) {
        assertNotNull("server name can not be null", name);
        return name;
    }

    private void initStatisticMap(List<ServerNode> nodeList, AtomicLongMap<String> statisticMap) {
        for(ServerNode node : nodeList) {
            statisticMap.put(node.nodeKey(), 0L);
        }
    }

    ////  test Md5Hash start  ////

    @Test
    public void testMd5HashWithoutVirtualNode() {
        System.out.println("Md5Hash with no virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new Md5HashFunction());
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testMd5HashWith10VirtualNode() {
        System.out.println("Md5Hash with 10 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new Md5HashFunction(), 10);
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testMd5HashWith20VirtualNode() {
        System.out.println("Md5Hash with 20 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new Md5HashFunction(), 20);
        process(hashMapper, AtomicLongMap.create());
    }

    ////  test Md5Hash end  ////

    ////  test KetamaHash start  ////

    @Test
    public void testKetamaHashWithoutVirtualNode() {
        System.out.println("KetamaHash with no virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new KetamaHashFunction());
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testKetamaHashWith10VirtualNode() {
        System.out.println("KetamaHash with 10 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new KetamaHashFunction(), 10);
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testKetamaHashWith20VirtualNode() {
        System.out.println("KetamaHash with 20 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new KetamaHashFunction(), 20);
        process(hashMapper, AtomicLongMap.create());
    }

    ////  test KetamaHash end  ////

    ////  test MurmurHash2 start  ////

    @Test
    public void testMurmurHash2WithoutVirtualNode() {
        System.out.println("MurmurHash2 with no virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new MurmurHash2Function());
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testMurmurHash2With10VirtualNode() {
        System.out.println("MurmurHash2 with 10 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new MurmurHash2Function(), 10);
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testMurmurHash2With20VirtualNode() {
        System.out.println("MurmurHash2 with 20 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new MurmurHash2Function(), 20);
        process(hashMapper, AtomicLongMap.create());
    }

    ////  test MurmurHash2 end  ////

    ////  test MurmurHash3 start  ////

    @Test
    public void testMurmurHash3WithoutVirtualNode() {
        System.out.println("MurmurHash3 with no virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new MurmurHash3Function());
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testMurmurHash3With10VirtualNode() {
        System.out.println("MurmurHash3 with 10 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new MurmurHash3Function(), 10);
        process(hashMapper, AtomicLongMap.create());
    }

    @Test
    public void testMurmurHash3With20VirtualNode() {
        System.out.println("MurmurHash3 with 20 virtual node: ");
        ConsistentHashMapper hashMapper = new ConsistentHashMapper(new MurmurHash3Function(), 20);
        process(hashMapper, AtomicLongMap.create());
    }

    ////  test MurmurHash3 end  ////

    private void process(ConsistentHashMapper hashMapper, AtomicLongMap<String> statisticMap) {
        initStatisticMap(nodeList, statisticMap);
        processMappingWithLoop(hashMapper, statisticMap, 1000000);
        prettyPrintStatisticMap(statisticMap);
    }

    private void processMappingWithLoop(ConsistentHashMapper hashMapper, AtomicLongMap<String> statisticMap, int timesOfLoop) {
        for (int i = 0; i < timesOfLoop; i++) {
            ServerNode node = hashMapper.mapping(nodeList, () -> UUID.randomUUID().toString().replaceAll("-", ""));
            statisticMap.getAndIncrement(node.nodeKey());
        }
    }

    private void prettyPrintStatisticMap(AtomicLongMap<String> statisticMap) {
        statisticMap.asMap().entrySet().stream().sorted(Map.Entry.comparingByValue()).forEach(System.out::println);
        System.out.print("Standard Deviation: ");
        System.out.println(StatisticUtils.stdev(statisticMap.asMap().values().toArray(new Long[]{})));
        System.out.println("\n");
    }

}
