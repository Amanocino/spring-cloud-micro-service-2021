/**
 * @projectName spring-cloud-micro-service-2021
 * @package com.example.gateway.handler
 * @className com.example.gateway.handler.UserBlockHandler
 */
package com.example.gateway.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowException;
import com.alibaba.csp.sentinel.slots.system.SystemBlockException;
import com.alibaba.fastjson2.JSON;

import java.util.HashMap;

/**
 * UserBlockHandler
 * @description UserBlockHandler sentinel class
 * @author chenzhicheng
 * @date 2023/5/17 16:57
 */
public class UserBlockHandler {
    public static String handleException(BlockException ex) {
        HashMap<String, Object> map = new HashMap<>();
        if (ex instanceof FlowException) {
            map.put("code", -1);
            map.put("msg", "系统限流，请稍等");
        } else if (ex instanceof DegradeException) {
            map.put("code", -2);
            map.put("msg", "降级了");
        } else if (ex instanceof ParamFlowException) {
            map.put("code", -3);
            map.put("msg", "热点参数限流");
        } else if (ex instanceof SystemBlockException) {
            map.put("code", -4);
            map.put("msg", "系统规则（负载/...不满足要求）");
        } else if (ex instanceof AuthorityException) {
            map.put("code", -5);
            map.put("msg", "授权规则不通过");
        }
        return JSON.toJSONString(map);
    }

    public static String handleError() {
        HashMap<String, Object> map = new HashMap<>();
        map.put("code", 500);
        map.put("msg", "系统异常");
        return JSON.toJSONString(map);
    }
}
