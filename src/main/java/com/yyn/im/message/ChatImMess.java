package com.yyn.im.message;

import com.yyn.im.vo.ImTo;
import com.yyn.im.vo.ImUser;
import lombok.Data;

@Data
public class ChatImMess {

    private ImUser mine;
    private ImTo to;

}
