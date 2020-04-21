package com.leesin;

import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.rpc.Protocol;

import java.util.ServiceLoader;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //JDK SPI
        //得到了所有实现类
        // ServiceLoader<DataBase> loads = ServiceLoader.load(DataBase.class);
        // for (DataBase load : loads) {
        //     System.out.println(load.dataBaseName());
        // }

        //Dubbo SPI
        Protocol myProtocol = ExtensionLoader.getExtensionLoader(Protocol.class).getExtension("myprotocol");
        System.out.println(myProtocol.getDefaultPort());
    }
}
