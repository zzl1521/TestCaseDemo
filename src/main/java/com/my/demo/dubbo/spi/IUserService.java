package com.my.demo.dubbo.spi;


/**
 * Created by zhangzhile on 2017/8/11.
 */
@SPI("B")
public interface IUserService {

    User getUser();
}
