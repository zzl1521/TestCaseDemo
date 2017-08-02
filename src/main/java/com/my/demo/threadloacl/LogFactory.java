package com.my.demo.threadloacl;

/**
 * Created by zhangzhile on 2017/5/17.
 */
public class LogFactory {

    private static ThreadLocal<String> txsId=new ThreadLocal<String>();

    public static String getTxId() {
        return txsId.get();
    }

    public static void setTxId(String txId) {
        txsId.set(txId);
    }
}
