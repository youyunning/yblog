package com.yyn.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.yyn.entity.Category;
import com.yyn.mapper.CategoryMapper;
import com.yyn.service.CategoryService;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *

 */
@Service
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements CategoryService {

}
