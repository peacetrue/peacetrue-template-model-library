package com.github.peacetrue.demo.controller;

import com.github.peacetrue.demo.service.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


/**
 * @author xiayx
 */
@RequestMapping(value = "${peacetrue.demo.urls.base-path}")
@SuppressWarnings("unchecked")
public class DemoController {

    private Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private DemoService demoService;

    @ResponseBody
    @PostMapping(value = "${peacetrue.demo.urls.add}")
    public DemoVO add(DemoAdd params) {
        logger.info("新增信息[{}]", params);
        return demoService.add(params);
    }

    @ResponseBody
    @GetMapping(value = "${peacetrue.demo.urls.query}", params = "page")
    public Page<DemoVO> query(DemoQuery params,
                              @PageableDefault(sort = "createdTime", direction = Sort.Direction.DESC) Pageable pageable) {
        logger.info("分页查询信息[{}]", params);
        return demoService.query(params, pageable);
    }

    @ResponseBody
    @GetMapping(value = "${peacetrue.demo.urls.get}", params = {"!page"})
    public DemoVO get(DemoGet params) {
        logger.info("获取信息[{}]详情", params);
        return demoService.get(params);
    }

    @ResponseBody
    @PutMapping(value = "${peacetrue.demo.urls.modify}")
    public int modify(DemoModify params) {
        logger.info("修改信息[{}]", params);
        return demoService.modify(params);
    }

    @ResponseBody
    @DeleteMapping(value = "${peacetrue.demo.urls.delete}")
    public int delete(DemoDelete params) {
        logger.info("删除信息[{}]", params);
        return demoService.delete(params);
    }


}
