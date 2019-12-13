package com.github.peacetrue.demo.service;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author xiayx
 */
@Data
public class DemoVO implements Serializable {

    private static final long serialVersionUID = 0L;

    private Long id;
    private String code;
    private String name;
    private String creatorId;
    private Date createdTime;
    private String modifierId;
    private Date modifiedTime;
}
