package me.zy.std.dubbo.spi.consumer;

import com.alibaba.dubbo.config.ApplicationConfig;
import com.alibaba.dubbo.config.ReferenceConfig;
import com.alibaba.dubbo.config.RegistryConfig;
import me.zy.std.dubbo.spi.api.EchoService;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class EchoConsumer {

    public static void main(String[] args) {
        ReferenceConfig<EchoService> reference = new ReferenceConfig<>();
        reference.setApplication(new ApplicationConfig("echo-service"));
        reference.setRegistry(new RegistryConfig("zookeeper://127.0.0.1:2181"));
        reference.setInterface(EchoService.class);
        EchoService service = reference.get();
        String message = service.echo("dubbo");
        System.out.println(message);
    }
}
