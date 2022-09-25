package com.xiaoace.demo.bot;

import cn.enaium.kook.spring.boot.starter.annotation.event.Event;
import cn.enaium.kook.spring.boot.starter.annotation.event.Register;
import cn.enaium.kook.spring.boot.starter.api.DirectMessageAPI;
import cn.enaium.kook.spring.boot.starter.api.MessageAPI;
import cn.enaium.kook.spring.boot.starter.model.sign.data.EventData;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.TextMessageExtra;
import cn.enaium.kook.spring.boot.starter.model.sign.data.extra.event.message.KMarkdownMessage;
import cn.enaium.kook.spring.boot.starter.util.HttpUtil;
import com.xiaoace.demo.utils.GetPicFromAPI;
import com.xiaoace.demo.utils.GlobalVar;
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
        //判断消息的发送者是不是机器人，如果不加判断，机器人会进入死循环
        if (message.extra.author.bot) {
            return;
        }

        Object raw_content = message.content;
        logger.info("对方说了:{}", raw_content);

        if (raw_content.equals("/help")) {
            if (message.channel_type.equals("PERSON")) {
                logger.info("私信回复Ta/help的内容 返回:{}", httpUtil.send(DirectMessageAPI.DIRECT_MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", 10,
                                "target_id", message.author_id,
                                "content", GlobalVar.Card
                        )
                )));
            }
            if (message.channel_type.equals("GROUP")) {
                logger.info("在频道内回复Ta/help卡片的内容", httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", 10,
                                "quote",message.msg_id,
                                "target_id", message.author_id,
                                "guild_id",message.extra.guild_id,
                                "channel_id",message.target_id,
                                "content", GlobalVar.Card
                        )
                )));
            }
        }

        if (raw_content.equals("/随机二次元")) {

            GetPicFromAPI getPicFromAPI = new GetPicFromAPI();
            String picUrl = getPicFromAPI.getMiddleUrl();

            if (message.channel_type.equals("PERSON")) {

                logger.info("私信回复Ta一张二次元,内容{}", httpUtil.send(DirectMessageAPI.DIRECT_MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", 1,
                                "target_id", message.author_id,
                                "content", picUrl
                        )
                )));

            }
            if (message.channel_type.equals("GROUP")) {

                String CardString = getPicFromAPI.cardMessage();

                logger.info("在频道内回复回复Ta一张二次元,内容：{}", httpUtil.send(MessageAPI.MESSAGE_CREATE.setBody(
                        Map.of(
                                "type", 10,
                                "quote",message.msg_id,
                                "target_id", message.author_id,
                                "guild_id",message.extra.guild_id,
                                "channel_id",message.target_id,
                                "content", CardString
                        )
                )));
            }
        }

    }

}
