package com.hxd.apiversion.config.version;

import org.springframework.web.bind.annotation.Mapping;

import java.lang.annotation.*;

/**
 * @Author: huxudong
 * @Date: 2019/9/27 9:49 上午
 */
@Target({ ElementType.METHOD, ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Mapping
public @interface ApiVersion {

    /**
     * version
     *
     * @return
     */
    int value() default 1;
}
