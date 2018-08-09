package com.wechat.wechatdemo.util;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import javax.servlet.annotation.HttpConstraint;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class IOUtils {

    /**
     * 将一个输入流转化成String字符串
     *
     * @param in
     * @return
     */
    public static String inputStreamString(InputStream in) {
        //获取请求体内容
        ByteArrayOutputStream ou = new ByteArrayOutputStream();
        try {
            byte[] bytes = new byte[1024];
            int len;
            while ((len = in.read(bytes)) != -1) {
                ou.write(bytes, 0, len);
            }
            byte[] by = ou.toByteArray();
            String content = new String(by, "utf-8");
            return content;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (in != null) {
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (ou != null) {
                try {
                    ou.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return null;
    }

    /**
     * 通过url获取响应结果
     *
     * @param url
     * @return
     */
    public static String url2String(String url) {

        try {
            URL url1 = new URL(url);
//            得到连接对象
            HttpURLConnection conn = (HttpURLConnection) url1.openConnection();
//            获取输入流
            InputStream inputStream = conn.getInputStream();
//            通过工具方法拿到响应结果
            return  inputStreamString(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    /**
     * 获取access_token的值的
     * 在正式开发中access_token需要放在缓存中读取，每天只有2000次，判断是否存在没有就获取并放入缓存当中
     * @return
     */
    public  static  String getAccessToken(){
        //接口调用请求
        String url ="https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=wx09480bfaa7f88868&secret=a67044bc3a76393dfa44a502d49d9ec8";
        //调用工具类方及解析
        String json = url2String(url);
        //解析json
        JSONObject jsonObject = JSON.parseObject(json);
        String access_token = jsonObject.getString("access_token");
        return  access_token;
    }

    /**
     * 获取jsAPI
     * @return
     */
    public static  String getJSAPI(){
        String url = "https://api.weixin.qq.com/cgi-bin/ticket/getticket?access_token="+getAccessToken()+"&type=jsapi";
        String json = url2String(url);
        //解析json
        JSONObject jsonObject = JSON.parseObject(json);
        String ticket = jsonObject.getString("ticket");
        return ticket;
    }
}