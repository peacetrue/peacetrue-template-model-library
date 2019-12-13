package com.github.peacetrue.demo.service;

import com.github.peacetrue.result.exception.ResultException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import javax.annotation.Nullable;

/**
 * @author xiayx
 */
public interface DemoService {

    /** 新增 */
    DemoVO add(DemoAdd params) throws ResultException;

    /** 分页查询 */
    Page<DemoVO> query(@Nullable DemoQuery params, @Nullable Pageable pageable) throws ResultException;

    /** 获取 */
    DemoVO get(DemoGet params) throws ResultException;

    /** 修改 */
    int modify(DemoModify params) throws ResultException;

    /** 删除 */
    int delete(DemoDelete params) throws ResultException;
}
