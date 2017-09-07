package com.my.demo.job;

/**
 * Created by zhangzhile on 2017/9/6.
 */
public class TaskParam {

    private String id;
    private String param;
    private String time;


    public TaskParam(String id, String param, String time) {
        this.id = id;
        this.param = param;
        this.time = time;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
