package com.my.demo.reflect;

import java.util.List;
import java.util.Map;

/**
 * Created by zhangzhile on 2016/12/28.
 * 获取白骑士黑明单请求参数
 */
public class QueryBQSParam {

    private String idCardNo;//身份证
    private String trueName;//姓名

    private List list;
    private Integer integer;
    private Map map;

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Integer getInteger() {
        return integer;
    }

    public void setInteger(Integer integer) {
        this.integer = integer;
    }

    public String getIdCardNo() {
        return idCardNo;
    }

    public void setIdCardNo(String idCardNo) {
        this.idCardNo = idCardNo;
    }

    public String getTrueName() {
        return trueName;
    }

    public void setTrueName(String trueName) {
        this.trueName = trueName;
    }
}
