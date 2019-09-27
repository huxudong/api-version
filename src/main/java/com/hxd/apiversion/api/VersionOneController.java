package com.hxd.apiversion.api;

import com.riswein.ccrc.annotation.ApiVersion;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huxudong
 * @Date: 2019/9/27 9:57 上午
 */
@ApiVersion(1)
@RequestMapping("version/{api_version}")
@RestController
@Api(tags = "版本1接口")
public class VersionOneController {

    @RequestMapping("/hello")
    @ApiOperation(value = "hello")
    public String hello() {
        return "hello v1";
    }

    @RequestMapping("/extend")
    @ApiOperation(value = "extend")
    public String extend() {
        return "extend v1";
    }
}
