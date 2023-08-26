package com.yyn.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.yyn.common.lang.Result;
import com.yyn.entity.User;
import com.yyn.shiro.AccountProfile;

/**
 * <p>
 *  服务类
 * </p>
 *

 */
public interface UserService extends IService<User> {

    Result register(User user);

    AccountProfile login(String username, String password);
}
