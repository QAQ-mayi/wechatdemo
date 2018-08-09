package com.wechat.wechatdemo.util;

import com.wechat.wechatdemo.entity.Wechat;

public class EventUtils {

    /**
     *处理实体类调用相对应的方法
     *
     * @param wechat
     * @return
     *
     * <xml>
        <ToUserName>< ![CDATA[toUser] ]></ToUserName>
        <FromUserName>< ![CDATA[fromUser] ]></FromUserName>
        <CreateTime>12345678</CreateTime>
        <MsgType>< ![CDATA[news] ]></MsgType>
        <ArticleCount>2</ArticleCount>
        <Articles>
            <item>
                <Title>< ![CDATA[title1] ]></Title>
                <Description>< ![CDATA[description1] ]></Description>
                <PicUrl>< ![CDATA[picurl] ]></PicUrl>
                <Url>< ![CDATA[url] ]></Url>
            </item>
            <item>
                <Title>< ![CDATA[title] ]></Title>
                <Description>< ![CDATA[description] ]></Description>
                <PicUrl>< ![CDATA[picurl] ]></PicUrl>
                <Url>< ![CDATA[url] ]></Url>
            </item>
        </Articles>
    </xml>
     *
     */
    public static String event(Wechat wechat) {
//        关注微信公众号推送
        if (wechat.getMsgType().equals("event") && wechat.getEvent().equals("subscribe")){
//            返回一个图文菜单
            StringBuilder sb = new StringBuilder();
            sb.append("<xml>");
            sb.append("<ToUserName>").append(wechat.getFromUserName()).append("</ToUserName>");
            sb.append("<FromUserName>").append(wechat.getToUserName()).append("</FromUserName>");
            sb.append("<CreateTime>").append(System.currentTimeMillis()).append("</CreateTime>");
            sb.append("<MsgType>news</MsgType>");
            sb.append("<ArticleCount>3</ArticleCount>");
                sb.append("<Articles>");
//                第一个图文信息，自动转化为大图
                    sb.append("<item>");
                    sb.append("<Title>").append("欢迎关注本公众号信息").append("</Title>");
                    sb.append("<PicUrl>").append("http://mmbiz.qpic.cn/mmbiz_jpg/jnTKL2vl9YATrOW2eMvz7tzrwERd7libxnD6RfpXndiaVCwbLIlQicmiaaR0aRicib7MCQyhVh2LSh6lic2PdohQFMz8g/0").append("</PicUrl>");
                    sb.append("<Url>").append("https://user.qzone.qq.com/312897771").append("</Url>");
                    sb.append("</item>");

//                    第二个图文信息
                    sb.append("<item>");
                    sb.append("<Title>").append("做我的猫，嘻嘻嘻").append("</Title>");
                    sb.append("<PicUrl>").append("http://mmbiz.qpic.cn/mmbiz_jpg/jnTKL2vl9YATrOW2eMvz7tzrwERd7libxHeMKaz5ypiarR4QUb1bzLCH9rgHBKP8s8pG7VhFz9AImvbCawZ6TRzQ/0").append("</PicUrl>");
                    sb.append("<Url>").append("www.baidu.com").append("</Url>");
                    sb.append("</item>");
//                    第三个图文信息
                    sb.append("<item>");
                    sb.append("<Title>").append("我的位置信息").append("</Title>");
                    sb.append("<PicUrl>").append("http://mmbiz.qpic.cn/mmbiz_jpg/jnTKL2vl9YATrOW2eMvz7tzrwERd7libxaRVvq02118hBSyf9K8AqIjUwB3ba32ibSAh4BzL4g31Ijm9hKjFROkw/0").append("</PicUrl>");
                    sb.append("<Url>").append("http://qaqmayi.top/map/toMap").append("</Url>");
                    sb.append("</item>");
                sb.append("</Articles>");
            sb.append("</xml>");

            return sb.toString();
    }
        return "success";
    }
}
