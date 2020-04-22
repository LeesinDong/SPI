package com.leesin;

import com.alibaba.dubbo.common.URL;
import org.apache.dubbo.common.compiler.Compiler;
import org.apache.dubbo.common.extension.ExtensionLoader;
import org.apache.dubbo.config.annotation.Service;
import org.apache.dubbo.rpc.Filter;
import org.apache.dubbo.rpc.Protocol;

import java.util.List;


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

        //自适应扩展点
        Compiler adaptiveExtension = ExtensionLoader.getExtensionLoader(Compiler.class).getAdaptiveExtension();
        // System.out.println(adaptiveExtension.compile());

        //传到url中判断用哪个扩展点
        // @Service(proxy = "jdk")
        // interface

         //激活扩展点
        URL url = new URL("","",0);
        url = url.addParameter("cache", "cache");
        List<Filter> cache = ExtensionLoader.getExtensionLoader(Filter.class).getActivateExtension(url, "cache");
        for (Filter filter : cache) {
            System.out.println(filter);
        }
    }
}
