package com.wechat.wechatdemo.util;

import com.wechat.wechatdemo.entity.Wechat;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

import java.lang.reflect.Field;

/**
 * 解析xml工具类
 */
public class XmlUtils {

    /**
     * 解析微信xml内容，转化成实体类
     *
     * @param xml
     * @return
     */
    public static Wechat xmlEntity(String xml) {
        //获取反射对象
        Class cls = Wechat.class;

        //解析XML
        try {
            //创建一个对象
            Object obj = cls.newInstance();
            //1：先把XML--->Document对象
            Document document = DocumentHelper.parseText(xml);
            //2:先拿到根节点（xml）
            Element element = document.getRootElement();
            //反射获得实体类中所有属性数组
            Field[] fields = cls.getDeclaredFields();

            for (Field field : fields) {
                //对私有属性授权
                field.setAccessible(true);
                //获得属性名称
                String fieldName = field.getName();
                //去XML中解析下是否有属性对应的标签
                Element eles = element.element(fieldName);
                if (eles != null) {
                    //将标签中的值获取到，并且放入实体类对应的属性中
                    String textTrim = eles.getTextTrim();
                    //放入对应的属性
                    field.set(obj, textTrim);
                }
            }
            return (Wechat) obj;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
