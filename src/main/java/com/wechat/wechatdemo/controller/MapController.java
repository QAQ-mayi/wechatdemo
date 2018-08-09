package com.wechat.wechatdemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/map")
public class MapController {


        @RequestMapping("/toMap")
        public String toMap(){
            System.out.println("我的地图信息");
            return  "baiduMap";
        }

}
