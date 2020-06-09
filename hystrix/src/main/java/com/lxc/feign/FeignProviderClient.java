package com.lxc.feign;

import com.lxc.entity.Student;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collection;

//声明Feign访问的是哪个服务 注册中心注册过的名字;
// fallback 退路处理  ，如果可以成功就找provider 如果出现问题了就找FeignError
@FeignClient(value = "provider")
@Component
public interface FeignProviderClient {
    @GetMapping("/student/findAll")
    public Collection<Student> findAll();

    @GetMapping("/student/index")
    public String index();
}
