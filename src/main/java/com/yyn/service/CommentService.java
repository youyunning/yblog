package com.yyn.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.yyn.entity.Comment;
import com.yyn.vo.CommentVo;

public interface CommentService extends IService<Comment> {

    IPage<CommentVo> paing(Page page, Long postId, Long userId, String order);
}
