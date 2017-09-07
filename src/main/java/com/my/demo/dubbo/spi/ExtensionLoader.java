package com.my.demo.dubbo.spi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Enumeration;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by zhangzhile on 2017/8/11.
 */
public class ExtensionLoader<T> {

    public static ConcurrentHashMap<String, Class<?>> extensions = new ConcurrentHashMap<String, Class<?>>();

    public static Object getExtension(Class<?> clazz,String type) throws Exception {
        Class<?> inteImpl = extensions.get(type);
        if (inteImpl == null) {
            new ExtensionLoader().loader();
            inteImpl=extensions.get(type);
        }
        SPI annotation = clazz.getAnnotation(SPI.class);
        inteImpl=extensions.get(annotation.value());
        return inteImpl.newInstance();
    }

    private void loader() throws Exception {
        String fileName="extension/com.my.demo.dubbo.spi.IUserService";
        Enumeration<URL> resources = this.getClass().getClassLoader().getResources(fileName);
        //Enumeration<URL> resources = ClassLoader.getSystemResources(fileName);
        while (resources.hasMoreElements()) {
            URL url = resources.nextElement();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(url.openStream()));
            String line = null;
            while ((line = bufferedReader.readLine()) != null) {
                String[] split = line.split("=");
                extensions.put(split[0], Class.forName(split[1]));
            }
        }
    }

}
