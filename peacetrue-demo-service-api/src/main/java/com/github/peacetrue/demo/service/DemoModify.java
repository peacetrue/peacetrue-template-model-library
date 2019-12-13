package com.github.peacetrue.demo.service;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(callSuper = true)
public class DemoModify extends OperatorCapableImpl<String> {

    private static final long serialVersionUID = 0L;

    private Long id;
    private String code;
    private String name;
}
