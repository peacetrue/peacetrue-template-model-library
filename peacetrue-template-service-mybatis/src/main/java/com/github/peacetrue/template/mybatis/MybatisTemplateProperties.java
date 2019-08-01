package com.github.peacetrue.template.mybatis;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author xiayx
 */
@Data
@ConfigurationProperties(prefix = "peacetrue.template")
public class MybatisTemplateProperties {

}
