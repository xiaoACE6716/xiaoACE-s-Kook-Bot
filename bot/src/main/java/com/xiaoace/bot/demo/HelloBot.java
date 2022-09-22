package com.xiaoace.bot.demo;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.TextMessageExtra;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.ImageAnimationMessage;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

@Register
public class HelloBot {

    private final Logger logger = LogManager.getLogger(HelloBot.class);

    @Autowired
    public HttpUtil httpUtil;

    @Event(KMarkdownMessage.class)
    public void event(EventData<TextMessageExtra> message) {
        if (message.extra.author.bot) {
            return;
        }

        Object raw_content = message.content;
        logger.info("对方说了:{}",raw_content);
        boolean flag = true;
        if (flag){

            logger.info("回复他Hello 返回:{}",httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                    Map.of(
                            "type",1,
                            "quote",message.msg_id,
                            "content","Hello",
                            "guild_id",message.extra.guild_id,
                            "channel_id",message.target_id
                    )
            )));

        }

    }
    @Event(ImageAnimationMessage.class)
    public void imageAnimation(EventData<ImageAnimationMessage> imageAnimationMessageEventData) {
        logger.info(imageAnimationMessageEventData.extra.kmarkdown);
    }

}
