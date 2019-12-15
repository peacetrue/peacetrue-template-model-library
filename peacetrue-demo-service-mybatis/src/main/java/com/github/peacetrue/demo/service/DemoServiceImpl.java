package com.github.peacetrue.demo.service;

import com.github.pagehelper.PageHelper;
import com.github.peacetrue.core.Range;
import com.github.peacetrue.mybatis.dynamic.MybatisDynamicUtils;
import com.github.peacetrue.pagehelper.PageHelperUtils;
import com.github.peacetrue.spring.util.BeanUtils;
import com.github.peacetrue.util.EntityNotFoundException;
import org.mybatis.dynamic.sql.SqlBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.*;
import org.springframework.stereotype.Service;

import javax.annotation.Nullable;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import static com.github.peacetrue.demo.service.DemoDynamicSqlSupport.*;

/**
 * @author xiayx
 */
@Service
public class DemoServiceImpl implements DemoService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DemoMapper demoMapper;

    @Override
    public DemoVO add(DemoAdd params) {
        logger.info("新增信息[{}]", params);
        Demo demo = new Demo();
        BeanUtils.copyProperties(params, demo);
        demo.setCreatorId(params.getOperatorId());
        demo.setCreatedTime(new Date());
        demo.setModifierId(params.getOperatorId());
        demo.setModifiedTime(demo.getCreatedTime());
        logger.debug("保存信息[{}]", demo);
        int count = demoMapper.insertSelective(demo);
        logger.debug("共影响[{}]条记录", count);
        return to(demo);
    }

    private DemoVO to(Demo demo) {
        DemoVO vo = new DemoVO();
        BeanUtils.copyProperties(demo, vo);
        return vo;
    }

    @Override
    public Page<DemoVO> query(@Nullable DemoQuery params, @Nullable Pageable pageable) {
        logger.info("分页查询信息[{}]", params);
        if (params == null) params = DemoQuery.DEFAULT;
        if (params.getCreatedTime() == null) params.setCreatedTime(new Range.Date());
        if (pageable == null) pageable = new PageRequest(0, 10, new Sort(Sort.Direction.DESC, "createdTime"));
        PageHelper.startPage(pageable.getPageNumber() + 1, pageable.getPageSize());
        List<Demo> entities = demoMapper.selectByExample()
                .where(code, SqlBuilder.isLikeWhenPresent(MybatisDynamicUtils.likeValue(params.getCode())))
                .and(name, SqlBuilder.isEqualToWhenPresent(params.getName()))
                .and(createdTime, SqlBuilder.isGreaterThanOrEqualToWhenPresent(params.getCreatedTime().getLowerBound()))
                .and(createdTime, SqlBuilder.isLessThanWhenPresent(MybatisDynamicUtils.endDateValue(params.getCreatedTime().getUpperBound())))
                .orderBy(MybatisDynamicUtils.orders(demo, pageable.getSort()))
                .build().execute();
        logger.debug("共取得'{}'条记录", entities.size());
        if (entities.isEmpty()) return new PageImpl<>(Collections.emptyList());

        List<DemoVO> vos = entities.stream().map(this::to).collect(Collectors.toList());
        return new PageImpl<>(vos, pageable, PageHelperUtils.getTotal(entities));
    }

    @Override
    public DemoVO get(DemoGet params) {
        logger.info("获取符合条件[{}]的信息", params);
        return demoMapper.selectByExample()
                .where(id, SqlBuilder.isEqualTo(params.getId()))
                .build().execute().stream()
                .reduce((l, r) -> r)
                .map(this::to)
                .orElseThrow(() -> new EntityNotFoundException(Demo.class, "id", params.getId()));
    }

    @Override
    public int modify(DemoModify params) {
        logger.info("修改信息[{}]", params);
        Demo demo = new Demo();
        BeanUtils.copyProperties(params, demo);
        demo.setModifierId(params.getOperatorId());
        demo.setModifiedTime(new Date());
        int count = demoMapper.updateByPrimaryKeySelective(demo);
        logger.debug("共影响[{}]条记录", count);
        return count;
    }

    @Override
    public int delete(DemoDelete params) {
        logger.info("删除信息[{}]", params);
        int count = params.getId().length == 1
                ? demoMapper.deleteByPrimaryKey(params.getId()[0])
                : demoMapper.deleteInPrimaryKey(Arrays.asList(params.getId()));
        logger.debug("共影响[{}]条记录", count);
        return count;
    }
}
