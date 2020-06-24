package me.zy.std.dubbo.spi.provider;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import com.alibaba.dubbo.config.ServiceConfig;
import me.zy.std.dubbo.spi.api.EchoService;
import me.zy.std.dubbo.spi.provider.impl.EchoServiceImpl;

import java.util.concurrent.CountDownLatch;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class EchoProvider {

    public static void main(String[] args) throws InterruptedException {
        ServiceConfig<EchoServiceImpl> service = new ServiceConfig<>();
        service.setInterface(EchoService.class);
        service.setRef(new EchoServiceImpl());
        service.setApplication(new ApplicationConfig("echo-provider"));
        service.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        service.setSerialization("protostuff");
        service.export();

        System.out.println("dubbo service started");
        new CountDownLatch(1).await();
    }
}
