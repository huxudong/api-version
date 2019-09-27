package com.hxd.apiversion.api;

import com.hxd.apiversion.config.version.ApiVersion;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huxudong
 * @Date: 2019/9/27 9:57 上午
 */
@ApiVersion(3)
@RequestMapping("{api_version}")
@RestController
public class VersionThreeController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello v3";
    }
}
