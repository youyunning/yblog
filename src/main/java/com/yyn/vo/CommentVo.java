package com.yyn.vo;

import com.yyn.entity.Comment;
import lombok.Data;

@Data
public class CommentVo extends Comment {

    private Long authorId;
    private String authorName;
    private String authorAvatar;

}
