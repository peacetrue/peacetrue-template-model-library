package com.github.peacetrue.template;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * 控制器配置
 *
 * @author xiayx
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "peacetrue.template")
public class ControllerTemplateProperties {

    @Getter
    @Setter
    public static class Urls {
        /** 新增地址 */
        private String add;
        /** 查询地址 */
        private String query;
        /** 查看地址 */
        private String get;
    }

}