package com.hxd.apiversion.api;

import com.riswein.ccrc.annotation.ApiVersion;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huxudong
 * @Date: 2019/9/27 9:57 上午
 */
@ApiVersion(2)
@RequestMapping("version/{api_version}")
@RestController
@Api(tags = "版本2接口")
public class VersionTwoController {

    @RequestMapping("/hello")
    public String hello() {
        return "hello v2";
    }
}
