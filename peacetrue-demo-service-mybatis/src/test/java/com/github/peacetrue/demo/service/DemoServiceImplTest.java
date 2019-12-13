package com.github.peacetrue.demo.service;

import com.github.peacetrue.spring.util.BeanUtils;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author xiayx
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = TestServiceDemoAutoConfiguration.class)
@Transactional
public class DemoServiceImplTest {

    @Autowired
    private DemoService demoService;

    public static final DemoAdd DEMO_ADD = new DemoAdd();

    static {
        DEMO_ADD.setCode("2");
        DEMO_ADD.setName("2");
        DEMO_ADD.setOperatorId("1");
    }

    @Test
    public void add() {
        DemoVO vo = demoService.add(DEMO_ADD);
        Assert.assertEquals(vo, demoService.get(new DemoGet(vo.getId())));
    }

    @Test
    public void query() {
        Page<DemoVO> vos = demoService.query(new DemoQuery(), new PageRequest(0, 1));
        Assert.assertEquals(vos.getTotalElements(), 1);
    }

    @Test
    public void get() {
        DemoVO vo = demoService.get(new DemoGet(1L));
        Assert.assertNotNull(vo);
    }

    @Test
    public void modify() {
        DemoVO vo = demoService.get(new DemoGet(1L));
        DemoModify modify = new DemoModify();
        BeanUtils.copyProperties(vo, modify);
        modify.setCode("2");
        int count = demoService.modify(modify);
        Assert.assertEquals(count, 1);
        vo = demoService.get(new DemoGet(1L));
        Assert.assertEquals(modify.getCode(), vo.getCode());
    }

    @Test
    public void delete() {
        int count = demoService.delete(new DemoDelete(new Long[]{1L}));
        Assert.assertEquals(count, 1);
    }
}