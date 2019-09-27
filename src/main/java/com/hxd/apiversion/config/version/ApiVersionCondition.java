package com.hxd.apiversion.config.version;

import org.springframework.web.servlet.mvc.condition.RequestCondition;

import javax.servlet.http.HttpServletRequest;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: huxudong
 * @Date: 2019/9/27 9:51 上午
 */
public class ApiVersionCondition implements RequestCondition<ApiVersionCondition> {

    /**
     * extract the version part from url. example [v0-9]
     */
    private final static Pattern VERSION_PREFIX_PATTERN = Pattern.compile("v(\\d+)/");

    private int apiVersion;


    public ApiVersionCondition(int apiVersion) {
        this.apiVersion = apiVersion;
    }

    /**
     *  // 和另外一个请求匹配条件合并，具体合并逻辑由实现类提供
     * @param other
     * @return
     */
    @Override
    public ApiVersionCondition combine(ApiVersionCondition other) {
        // latest defined would be take effect, that means, methods definition with
        // override the classes definition
        return new ApiVersionCondition(other.getApiVersion());
    }

    /**
     * 	// 检查当前请求匹配条件和指定请求request是否匹配，如果不匹配返回null，
     * 	// 如果匹配，生成一个新的请求匹配条件，该新的请求匹配条件是当前请求匹配条件
     * 	// 针对指定请求request的剪裁。
     * 	// 举个例子来讲，如果当前请求匹配条件是一个路径匹配条件，包含多个路径匹配模板，
     * 	// 并且其中有些模板和指定请求request匹配，那么返回的新建的请求匹配条件将仅仅
     * 	// 包含和指定请求request匹配的那些路径模板。
     * @param request
     * @return
     */
    @Override
    public ApiVersionCondition getMatchingCondition(HttpServletRequest request) {
        Matcher m = VERSION_PREFIX_PATTERN.matcher(request.getRequestURI());
        if (m.find()) {
            Integer version = Integer.valueOf(m.group(1));
            // when applying version number bigger than configuration, then it will take
            if (version >= this.apiVersion) {
                // effect
                return this;
            }

        }
        return null;
    }

    /**
     *  针对指定的请求对象request比较两个请求匹配条件。
     *  该方法假定被比较的两个请求匹配条件都是针对该请求对象request调用了
     *  #getMatchingCondition方法得到的，这样才能确保对它们的比较
     *  是针对同一个请求对象request，这样的比较才有意义(最终用来确定谁是
     *  更匹配的条件)。
      * @param other
     * @param request
     * @return
     */
    @Override
    public int compareTo(ApiVersionCondition other, HttpServletRequest request) {
        // when more than one configured version number passed the match rule, then only
        // the biggest one will take effect.
        return other.getApiVersion() - this.apiVersion;
    }

    public int getApiVersion() {
        return apiVersion;
    }
}
