package com.my.demo.schema;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

/**
 * Created by zhangzhile on 2017/8/3.
 */
public class PersonNamespaceHandler extends NamespaceHandlerSupport {
    @Override
    public void init() {
        registerBeanDefinitionParser("person", new PersonBeanDefinitionParser());
    }
}
