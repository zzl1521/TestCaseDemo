package com.my.demo.netty;

import java.math.BigDecimal;

/**
 * Created by zhangzhile on 2017/7/26.
 */
public class Test {

    public static void main(String[] args) {
        BigDecimal bigDecimal = new BigDecimal("273.87496");
        System.out.println(bigDecimal.setScale(4,BigDecimal.ROUND_HALF_UP));
        System.out.println(bigDecimal.setScale(3,BigDecimal.ROUND_HALF_UP));
        System.out.println(bigDecimal.setScale(2,BigDecimal.ROUND_HALF_UP));
        System.out.println(new BigDecimal("273.87496").setScale(4,BigDecimal.ROUND_HALF_UP).setScale(3,BigDecimal.ROUND_HALF_UP).setScale(2,BigDecimal.ROUND_HALF_UP));
    }
}
