package com.my.demo.zookeeper;

import org.I0Itec.zkclient.ZkClient;
import org.I0Itec.zkclient.ZkConnection;

import java.util.List;

/**
 * Created by zhangzhile on 2017/5/26.
 */
public class ZookeeperTest {

    static final String CONNECT_ADDR = "localhost:2181,localhost:2182,localhost:2183";
    //static final String CONNECT_ADDR = "localhost:2182";
    static final int SESSION_TIMEOUT = 1000;
    private static ZkClient zkClient = new ZkClient(new ZkConnection(CONNECT_ADDR), SESSION_TIMEOUT);

    public static void main(String[] args) throws Exception {
        zkClient.subscribeChildChanges("/zk", (parentPath, currentChilds) -> {
            System.out.println("parentPath:" + parentPath);
            System.out.println("currentChilds:" + currentChilds);
        });
        boolean is = true;

        do {
            Thread.sleep(2000);
            /*zkClient.delete("/zk/c1");
            zkClient.createPersistent("/zk/c1");
            //3.更新和判断节点是否存在
            zkClient.writeData("/zk/c1", "123"); //修改指定节点的值*/
            String cData = zkClient.readData("/dubbo/com.my.demo.dubbo.service.IUserService/providers");
            forss("/dubbo");
            System.out.println("dubbo:" + cData);
            //System.out.println(zkClient.exists("/dubbo/com.my.demo.dubbo.service.IUserService")); //判断指定节点是否存在
        } while (false);

        zkClient.close();
    }


    public static void forss(String note) {
        List<String> children = zkClient.getChildren(note);
        for (String str : children) {
            List<String> childrens = zkClient.getChildren(note + "/" + str);
            /*for (String strs : childrens) {
                System.out.println("节点"+note + "/" + str+" = "+strs);
                forss(note + "/" + str + "/" + strs);
            }*/
            if (childrens.isEmpty()) {
               // System.out.println(note + "/" + str);
                String cData = zkClient.readData(note + "/" + str);
                System.out.println("节点=" + note + "/" + str + " ,值=" + cData);
            }else{
                forss(note + "/" + str );
            }
        }
    }

}
