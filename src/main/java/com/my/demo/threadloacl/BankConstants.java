package com.my.demo.threadloacl;

import java.text.SimpleDateFormat;

/**
 * Created by zhuxq on 2016/11/9.
 */
public class BankConstants {

    public static final String UTF8="UTF-8";
    public static final String UTF8_BROWSER="text/html;charset=UTF-8";
    public static final String UTF8_JSON="application/json;charset=UTF-8";
    public static final String GBK="GBK";
    public static final String GBK_BROWSER="text/html;charset=GBK";
    public static final String POINT=".";

    public static final String time1 = "yyyyMMddHHmmss";
    public static final String time2 = "yyyy-MM-dd HH:mm:ss";//中间件接口中的日期格式 Mysql now()函数的默认格式
    public static final String time3 = "yyyy/MM/dd HH:mm:ss";//信审系统中的日期格式
    public static final String date1 = "yyyyMMdd";
    public static final String date2 = "dd/MM/yyyy";//Instinct入参时间的默认格式
    public static final String date3 = "yyyy/MM/dd";
    public static final String date4 = "yyyy-MM-dd";
    public static final String time4 = "yyyy.MM.dd HH:mm:ss";//厦门传送的日期格式
    public static final String time5 = "HH:mm";//获取时分格式


    public static ThreadLocal<SimpleDateFormat> sdf_time2Thread = new ThreadLocal<SimpleDateFormat>();
    public static final SimpleDateFormat sdf_time1 = new SimpleDateFormat(time1);
    public static final SimpleDateFormat sdf_time2 = new SimpleDateFormat(time2);//中间件接口中的日期格式 Mysql now()函数的默认格式
    public static final SimpleDateFormat sdf_time3 = new SimpleDateFormat(time3);//信审系统中的日期格式
    public static final SimpleDateFormat sdf_time4 = new SimpleDateFormat(time5);
    public static final SimpleDateFormat sdf_date1 = new SimpleDateFormat(date1);
    public static final SimpleDateFormat sdf_date2 = new SimpleDateFormat(date2);//Instinct入参时间的默认格式
    public static final SimpleDateFormat sdf_date3 = new SimpleDateFormat(date3);
    public static final SimpleDateFormat sdf_date4 = new SimpleDateFormat(date4);

    public static final String BANKAPI_BANK_TRADENO = "BANKAPI_BANK_TRADENO";
    public static final String BANKAPI_BANK_REQNO = "BANKAPI_BANK_REQNO";
    public static final String BANKAPI_BANK_B_PAY_ORDER_FTP = "BANKAPI_BANK_B_PAY_ORDER_FTP";
    public static final String PSBC_BANKAPI_BANK_IMAGEID = "PSBC_BANKAPI_BANK_IMAGEID";
    public static final String BANKAPI_BANK_KEY = "BANKAPI_BANK_KEY";
    public static final String BANKAPI_BANK_BATCHNOO = "BANKAPI_BANK_BATCHNOO";
    
    /**
     * 记录b_loan_info 中的最大id，查询放款状态使用
     */
    public static final String BANKAPI_B_LOAN_INFO_ID = "BANKAPI_B_LOAN_INFO_ID";
    /**
     * 中邮工作密钥的key
     */
    public static final String BANKAPI_PSBC_WORK_KEY = "BANKAPI_PSBC_WORK_KEY";
    /**
     * 幸福消费工作密钥的key
     */
    public static final String BANKAPI_XFXF_WORK_KEY = "BANKAPI_XFXF_WORK_KEY";

    public static final String BANKAPI_MONITORLOAN_TIME = "BANKAPI_MONITORLOAN_TIME";
    public static final String BANKAPI_MONITORPAY_TIME = "BANKAPI_MONITORPAY_TIME";
    /**
     * 众邦银行的seqNo
     */
    public static final String BANKAPI_ZBANK_SEQNO = "BANKAPI_ZBANK_SEQNO";

    public static final String BANK_MSG="银行返回信息：";
    public static final String BANK_CODE_MSG="银行返回信息：[%s]%s";
    public static final String BANK_FAILED_SYN_MSG="放款失败(同步结果)银行返回信息：[%s]%s";
    public static final String BANK_FAILED_ASYN_MSG="放款失败(通知结果)银行返回信息：[%s]%s";
    public static final String BANK_FAILED_QUERY_MSG="放款失败(查询结果)银行返回信息：[%s]%s";


    /**
     * 返回码
     */
    public static final String RETURN_CODE="code";
    /**
     * 返回信息
     */
    public static final String RETURN_MESSAGE="message";
    
    public static final String RETURN_DATA="data";
    
    /**
     * 厦门国际返回成功
     */
    public static final String XIB_SUCCESS_CODE="00000000";
    
    public static SimpleDateFormat getSdf_time2() {
        SimpleDateFormat simpleDateFormat = sdf_time2Thread.get();
        if (simpleDateFormat == null) {
            simpleDateFormat = new SimpleDateFormat(time2);
            sdf_time2Thread.set(simpleDateFormat);
        }
        return simpleDateFormat;
    }

}
