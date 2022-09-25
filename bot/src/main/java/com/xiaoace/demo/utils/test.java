package com.xiaoace.demo.utils;

import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.ImageMessage;

public class test {

    ImageMessage imageMessage = new ImageMessage();

    public void setImageMessage(ImageMessage imageMessage) {
        this.imageMessage = imageMessage;

        //  "https://tva4.sinaimg.cn/large/ec43126fgy1gyeud5d12kj21c8231e85.jpg"
        imageMessage.attachments.put("type",2);

        imageMessage.type = 2;


    }
}
