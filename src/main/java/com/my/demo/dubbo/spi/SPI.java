package com.my.demo.dubbo.spi;

import java.lang.annotation.*;

/**
 * Created by zhangzhile on 2017/8/11.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface SPI  {

    /**
     * ȱʡ��չ������
     */
    String value() default "";
}
