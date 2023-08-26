package com.yyn.im.handler.impl;

import cn.hutool.json.JSONUtil;
import com.yyn.common.lang.Consts;
import com.yyn.im.handler.MsgHandler;
import com.yyn.im.handler.filter.ExculdeMineChannelContextFilter;
import com.yyn.im.message.ChatImMess;
import com.yyn.im.message.ChatOutMess;
import com.yyn.im.vo.ImMess;
import com.yyn.im.vo.ImTo;
import com.yyn.im.vo.ImUser;
import com.yyn.service.ChatService;
import com.yyn.util.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.tio.core.ChannelContext;
import org.tio.core.Tio;
import org.tio.websocket.common.WsRequest;
import org.tio.websocket.common.WsResponse;

import java.util.Date;

@Slf4j
public class ChatMsgHandler implements MsgHandler {
    @Override
    public void handler(String data, WsRequest wsRequest, ChannelContext channelContext) {
        ChatImMess chatImMess = JSONUtil.toBean(data, ChatImMess.class);

        ImUser mine = chatImMess.getMine();
        ImTo to = chatImMess.getTo();

        // 特殊处理？？

        ImMess imMess = new ImMess();
        imMess.setContent(mine.getContent());
        imMess.setAvatar(mine.getAvatar());
        imMess.setMine(false); // 是否是我发送的消息

        imMess.setUsername(mine.getUsername());
        imMess.setFromid(mine.getId());

        imMess.setId(Consts.IM_GROUP_ID);
        imMess.setTimestamp(new Date());
        imMess.setType(to.getType());


        ChatOutMess chatOutMess = new ChatOutMess();
        chatOutMess.setEmit("chatMessage");
        chatOutMess.setData(imMess);

        String result = JSONUtil.toJsonStr(chatOutMess);
        log.info("群聊消息----------> {}", result);

        WsResponse wsResponse = WsResponse.fromText(result, "utf-8");

        ExculdeMineChannelContextFilter filter = new ExculdeMineChannelContextFilter();
        filter.setCurrentContext(channelContext);

        Tio.sendToGroup(channelContext.getGroupContext(), Consts.IM_GROUP_NAME, wsResponse, filter);

        //保存群聊信息
        ChatService chatService = (ChatService) SpringUtil.getBean("chatService");
        chatService.setGroupHistoryMsg(imMess);

    }
}
