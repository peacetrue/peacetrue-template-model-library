package com.github.peacetrue.template.mybatis;

import com.github.peacetrue.associate.AssociatedSourceBuilder;
import com.github.peacetrue.associate.AssociatedSourceBuilderImpl;
import org.apache.ibatis.annotations.Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Objects;

/**
 * @author xiayx
 */
@Configuration
@EnableConfigurationProperties(MybatisTemplateProperties.class)
@MapperScan(basePackageClasses = MybatisTemplateAutoConfiguration.class, annotationClass = Mapper.class)
public class MybatisTemplateAutoConfiguration {

    private MybatisTemplateProperties properties;

    public MybatisTemplateAutoConfiguration(MybatisTemplateProperties properties) {
        this.properties = Objects.requireNonNull(properties);
    }

    @Bean
    public AssociatedSourceBuilder associatedSourceBuilder() {
        return new AssociatedSourceBuilderImpl();
    }

}
