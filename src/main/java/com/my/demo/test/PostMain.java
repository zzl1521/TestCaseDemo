package com.my.demo.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by zhangzhile on 2018/4/20.
 */
public class PostMain {

    // private static String url="http://localhost:8080//webapi/businessapi/activity/";
    //private static String url="http://mrelease07.houbank.net/activity/xiaomi/lottery;
    private static String url="http://mrelease07.houbank.net//webapi/businessapi/activity/";

    public static void main(String[] args) throws Exception{
        for (int i=0;i<5;i++){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    draw();
                }
            }).start();
        }
        //share();
        //draw();
        //myWinList();
    }


    public static void share()throws Exception{
        String serialObject = httpPostSerialObject(url+"share", 30000, 30000, null);
        System.out.println(serialObject);
    }

    public static void draw()throws Exception{
        String serialObject = httpPostSerialObject(url+"draw?drawNum=15", 30000, 30000, null);
        System.out.println(serialObject);
    }

    public static void myWinList()throws Exception{
        String serialObject = httpGetSerialObject(url+"myWinList", 30000, 30000, null);
        System.out.println(serialObject);
    }

    /**
     * ��ȡpost��ʽ�ύ���л����object���� </br>
     * ����ο���java.io.ObjectInputStream/ObjectOutputStream
     * @param requestUrl �����ַ
     * @param connTimeoutMills ��������������ʱ����λ������
     * @param readTimeoutMills ���ô�������ȡ���ݳ�ʱ����λ������
     * @param serializedObject ���л����object����
     *
     * @return remoteHttp���صĽ��
     */
    public static String httpPostSerialObject(String requestUrl, int connTimeoutMills,
                                              int readTimeoutMills, Object serializedObject) throws Exception
    {
        HttpURLConnection httpUrlConn = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        ObjectOutputStream oos = null;
        StringBuffer buffer = new StringBuffer();
        try
        {
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpURLConnection)url.openConnection();
            // ����content_type=SERIALIZED_OBJECT
            // ����������,�ڴ������л�����ʱ,��WEB����Ĭ�ϵĲ�����������ʱ������java.io.EOFException
            httpUrlConn.setRequestProperty("Content-Type","application/x-java-serialized-object");
            httpUrlConn.setRequestProperty("houbankuid","28113532");
            httpUrlConn.setRequestProperty("authtoken","281135321211111");
            httpUrlConn.setConnectTimeout(connTimeoutMills);
            httpUrlConn.setReadTimeout(readTimeoutMills);
            // �����Ƿ���httpUrlConn�������Ϊ��post���󣬲���Ҫ����http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false
            httpUrlConn.setDoOutput(true);
            // �����Ƿ��httpUrlConn���룬Ĭ���������true
            httpUrlConn.setDoInput(true);
            // ��ʹ�û���
            httpUrlConn.setUseCaches(false);

            // ��������ʽ��Ĭ����GET
            httpUrlConn.setRequestMethod("POST");
            httpUrlConn.connect();

            if (serializedObject != null)
            {
                // �˴�getOutputStream�������Ľ���connect��������ͬ���������connect()������
                // �����ڿ����в�����������connect()Ҳ���ԣ��������������ʽ����
                // write object(impl Serializable) using ObjectOutputStream
                oos = new ObjectOutputStream(httpUrlConn.getOutputStream());
                oos.writeObject(serializedObject);
                oos.flush();
                // outputStream����һ�����������������Ǹ��ַ�������������д��Ķ��������������͵����磬
                // ���Ǵ������ڴ滺�����У���outputStream���ر�ʱ�������������������http���ġ����������close�Ǳ����
                oos.close();
            }
            // �����ص�������ת�����ַ���
            // ������post����get��http����ʵ����ֱ��HttpURLConnection��getInputStream()��������������ʽ���ͳ�ȥ
            inputStream = httpUrlConn.getInputStream();//ע�⣬ʵ�ʷ�������Ĵ���ξ�������
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null)
            {
                buffer.append(str);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            try
            {
                /*IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(oos);*/
                if (httpUrlConn != null)
                {
                    httpUrlConn.disconnect();
                }
            }
            catch (Exception e)
            {
            }
        }
        return buffer.toString();
    }


    /**
     * ��ȡpost��ʽ�ύ���л����object���� </br>
     * ����ο���java.io.ObjectInputStream/ObjectOutputStream
     * @param requestUrl �����ַ
     * @param connTimeoutMills ��������������ʱ����λ������
     * @param readTimeoutMills ���ô�������ȡ���ݳ�ʱ����λ������
     * @param serializedObject ���л����object����
     *
     * @return remoteHttp���صĽ��
     */
    public static String httpGetSerialObject(String requestUrl, int connTimeoutMills,
                                              int readTimeoutMills, Object serializedObject) throws Exception
    {
        HttpURLConnection httpUrlConn = null;
        InputStream inputStream = null;
        InputStreamReader inputStreamReader = null;
        BufferedReader bufferedReader = null;
        ObjectOutputStream oos = null;
        StringBuffer buffer = new StringBuffer();
        try
        {
            URL url = new URL(requestUrl);
            httpUrlConn = (HttpURLConnection)url.openConnection();
            // ����content_type=SERIALIZED_OBJECT
            // ����������,�ڴ������л�����ʱ,��WEB����Ĭ�ϵĲ�����������ʱ������java.io.EOFException
            httpUrlConn.setRequestProperty("Content-Type","text/html");
            httpUrlConn.setRequestProperty("houbankuid","28113532");
            httpUrlConn.setRequestProperty("authtoken","281135321211111");
            httpUrlConn.setConnectTimeout(connTimeoutMills);
            httpUrlConn.setReadTimeout(readTimeoutMills);
            // �����Ƿ���httpUrlConn�������Ϊ��post���󣬲���Ҫ����http�����ڣ������Ҫ��Ϊtrue, Ĭ���������false
            httpUrlConn.setDoOutput(true);
            // �����Ƿ��httpUrlConn���룬Ĭ���������true
            httpUrlConn.setDoInput(true);
            // ��ʹ�û���
            httpUrlConn.setUseCaches(false);

            // ��������ʽ��Ĭ����GET
            httpUrlConn.setRequestMethod("GET");
            httpUrlConn.connect();

            if (serializedObject != null)
            {
                // �˴�getOutputStream�������Ľ���connect��������ͬ���������connect()������
                // �����ڿ����в�����������connect()Ҳ���ԣ��������������ʽ����
                // write object(impl Serializable) using ObjectOutputStream
                oos = new ObjectOutputStream(httpUrlConn.getOutputStream());
                oos.writeObject(serializedObject);
                oos.flush();
                // outputStream����һ�����������������Ǹ��ַ�������������д��Ķ��������������͵����磬
                // ���Ǵ������ڴ滺�����У���outputStream���ر�ʱ�������������������http���ġ����������close�Ǳ����
                oos.close();
            }
            // �����ص�������ת�����ַ���
            // ������post����get��http����ʵ����ֱ��HttpURLConnection��getInputStream()��������������ʽ���ͳ�ȥ
            inputStream = httpUrlConn.getInputStream();//ע�⣬ʵ�ʷ�������Ĵ���ξ�������
            inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = null;
            while ((str = bufferedReader.readLine()) != null)
            {
                buffer.append(str);
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            try
            {
                /*IOUtils.closeQuietly(bufferedReader);
                IOUtils.closeQuietly(inputStreamReader);
                IOUtils.closeQuietly(inputStream);
                IOUtils.closeQuietly(oos);*/
                if (httpUrlConn != null)
                {
                    httpUrlConn.disconnect();
                }
            }
            catch (Exception e)
            {
            }
        }
        return buffer.toString();
    }
}
