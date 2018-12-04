package com.my.demo.nio;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zhangzhile on 2018/3/8.
 */
@Service
public class XibSocketHander extends AbstractSocketHander {

    private static final Logger LOGGER = LoggerFactory.getLogger(XibSocketHander.class);

    @Autowired
    //private FacadeApi xibExchange;

    public String post(String message) throws Exception {
        String result = null;
        try {
            LOGGER.info("厦门国际回调参数[{}]", message);
            /*String bankType = BankTypeEnum.XIB.getType();
            FacadeReceiveRequest facadeReceiveRequest = new FacadeReceiveRequest();
            facadeReceiveRequest.setBankType(bankType);
            facadeReceiveRequest.setPacket(message);*/
            //result = xibExchange.callBack(facadeReceiveRequest);
        } catch (Exception e) {
            LOGGER.error("厦门国际通知处理异常，参数[{}]",message,e);
        }
        return result;
    }
}
