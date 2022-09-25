package com.xiaoace.demo.utils;

import cn.enaium.kook.spring.boot.starter.model.object.AttachmentsObject;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

import java.util.Map;

public class GetPicFromAPI {

    public String getLargeUrl(){

        StringBuilder rawJson = new StringBuilder(HttpUtil.get(GlobalVar.allAgePic));

        JSONObject picJSON = JSONUtil.parseObj(rawJson.toString(),false);

        JSONArray jsonArray = picJSON.getJSONArray("pic");

        String picUrl = jsonArray.get(0).toString();

        return picUrl;
    }

    public String getMiddleUrl(){

        String largeUrl = getLargeUrl();

        String picUrl = largeUrl.replace("large","middle");

        return picUrl;
    }

    public String getSmallUrl(){

        String largeUrl = getLargeUrl();

        String picUrl = largeUrl.replace("large","small");

        return picUrl;

    }



    public String cardMessage(){

        String picUrl = getMiddleUrl();

        String cardMessageString = GlobalVar.picCard.replace("这里是图片链接地址",picUrl);

        return cardMessageString;
    }


}
