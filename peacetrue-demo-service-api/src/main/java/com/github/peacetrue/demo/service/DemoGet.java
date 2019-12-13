package com.github.peacetrue.demo.service;

import com.github.peacetrue.core.OperatorCapableImpl;
import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author xiayx
 */
@Getter
@Setter
@ToString(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class DemoGet extends OperatorCapableImpl<String> {

    private static final long serialVersionUID = 0L;

    @NotNull
    private Long id;

}
