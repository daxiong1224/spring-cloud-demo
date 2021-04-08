package com.hx.demo.api.fallback;

import com.hx.demo.api.SchedualServiceHi;
import org.springframework.stereotype.Component;

@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {
    //todo 错误描述返回未生效，应该是包版本问题
    @Override
    public String sayHiFromClientOne(String name) {
        return "sorry, you are fail,"+name;
    }
}