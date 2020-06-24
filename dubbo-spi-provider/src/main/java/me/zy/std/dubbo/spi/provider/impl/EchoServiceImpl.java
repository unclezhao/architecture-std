package me.zy.std.dubbo.spi.provider.impl;

import com.alibaba.dubbo.rpc.RpcContext;
import me.zy.std.dubbo.spi.api.EchoService;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author zhaoyang on 2020-06-24.
 */
public class EchoServiceImpl implements EchoService {

    @Override
    public String echo(String message) {
        String now = new SimpleDateFormat("HH:mm:ss").format(new Date());
        System.out.println("[" + now + "] Hello " + message
            + ", request from consumer: " + RpcContext.getContext().getRemoteAddress());
        return message;
    }
}
