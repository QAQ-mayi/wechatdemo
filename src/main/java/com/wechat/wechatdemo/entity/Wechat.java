package com.wechat.wechatdemo.entity;

public class Wechat {

    /**
     * 普通消息
     */
    private String ToUserName;
    private String FromUserName;
    private String CreateTime;
    private String MsgType;
    private String Content;
    private String MsgId;

    /**
     * 图片消息
     */
    private String PicUrl;
    private String MediaId;

    /**
     * 关注微信公众号的消息
     */
    private String Event;
    private String EventKey;

    public String getToUserName() {
        return ToUserName;
    }

    public void setToUserName(String toUserName) {
        ToUserName = toUserName;
    }

    public String getFromUserName() {
        return FromUserName;
    }

    public void setFromUserName(String fromUserName) {
        FromUserName = fromUserName;
    }

    public String getCreateTime() {
        return CreateTime;
    }

    public void setCreateTime(String createTime) {
        CreateTime = createTime;
    }

    public String getMsgType() {
        return MsgType;
    }

    public void setMsgType(String msgType) {
        MsgType = msgType;
    }

    public String getContent() {
        return Content;
    }

    public void setContent(String content) {
        Content = content;
    }

    public String getMsgId() {
        return MsgId;
    }

    public void setMsgId(String msgId) {
        MsgId = msgId;
    }

    public String getPicUrl() {
        return PicUrl;
    }

    public void setPicUrl(String picUrl) {
        PicUrl = picUrl;
    }

    public String getMediaId() {
        return MediaId;
    }

    public void setMediaId(String mediaId) {
        MediaId = mediaId;
    }

    public String getEvent() {
        return Event;
    }

    public void setEvent(String event) {
        Event = event;
    }

    public String getEventKey() {
        return EventKey;
    }

    public void setEventKey(String eventKey) {
        EventKey = eventKey;
    }

    @Override
    public String toString() {
        return "Wechat{" +
                "ToUserName='" + ToUserName + '\'' +
                ", FromUserName='" + FromUserName + '\'' +
                ", CreateTime='" + CreateTime + '\'' +
                ", MsgType='" + MsgType + '\'' +
                ", Content='" + Content + '\'' +
                ", MsgId='" + MsgId + '\'' +
                ", PicUrl='" + PicUrl + '\'' +
                ", MediaId='" + MediaId + '\'' +
                ", Event='" + Event + '\'' +
                ", EventKey='" + EventKey + '\'' +
                '}';
    }
}
