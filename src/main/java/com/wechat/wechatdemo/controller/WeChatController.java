package com.wechat.wechatdemo.controller;


import com.alibaba.fastjson.JSON;
import com.wechat.wechatdemo.entity.Wechat;
import com.wechat.wechatdemo.util.EventUtils;
import com.wechat.wechatdemo.util.IOUtils;
import com.wechat.wechatdemo.util.SHA1Utils;
import com.wechat.wechatdemo.util.XmlUtils;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.lang.annotation.Documented;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.UUID;


@Controller
@RequestMapping("/wechat")
public class WeChatController {

    /**
     * 微信公众号接入，修改了一个bug
     *
     * @return
     */
    @GetMapping("/welcome")
    @ResponseBody
    public String welcome(String echostr) {
        System.out.println("微信公众号网页接入");
        return echostr;
    }



    /**
     * 处理微信公众号的消息
     *
     * @param
     * @return
     */
    @PostMapping("/welcome")
    @ResponseBody
    public String index(HttpServletRequest request) throws IOException {
        System.out.println("微信手机关注事件");
        //获取请求体内容
        String content = IOUtils.inputStreamString(request.getInputStream());
        //解析xml--》实体类
        Wechat wechat = XmlUtils.xmlEntity(content);

        System.out.println("接收到微信消息！！！" + wechat);
//        处理不同的微信事件
        return EventUtils.event(wechat);
    }

    /**
     * 通过jssdk验证权限
     *
     * @return
     */
    @RequestMapping("/jssdk")
    @ResponseBody
    public String jsSDK(String url) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMddHHmmssSSS");

        String appId = "wx09480bfaa7f88868";//// 必填，公众号的唯一标识
        String timestamp = sdf.format(new Date());// 必填，生成签名的时间戳
        String nonceStr = UUID.randomUUID().toString(); // 必填，生成签名的随机串

        //获取jsAPI
        String ticket = IOUtils.getJSAPI();

        //URL键值对的拼接
        String sign = "jsapi_ticket=" + ticket + "&noncestr=" + nonceStr + "&timestamp=" + timestamp + "&url=" + url;

        //对键值对的字符进行sha签名加密得到签名字符串
        String signature = SHA1Utils.encode(sign);// 必填，签名


        HashMap<String, String> map = new HashMap<>();
        map.put("appid", appId);
        map.put("timestamp", timestamp);
        map.put("nonceStr", nonceStr);
        map.put("signature", signature);

        //把map转成json传进去
        String json = JSON.toJSONString(map);
        System.out.println("签名后得到json"+json);
        return json;
    }
}
