package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;

/**
 * @author CaiBowen
 * @date 2024/4/20 23:14
 */


@RestController
public class PayCircuitController {

    //Resilience for Java circuitBreaker的例子
    /*@GetMapping(value = "/pay/circuit/{id}")
    public String myCircuit(@PathVariable("id") Integer id){

        if (id == -4) throw new RuntimeException("--------circuit不能负载");

        if (id ==9999){
            try {
                TimeUnit.SECONDS.sleep(5);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        return "Hello,circuit!" + id + "\t" + IdUtil.simpleUUID();
    }*/

    //=========Resilience4j bulkhead 的例子
    @GetMapping(value = "/pay/bulkhead/{id}")
    public String myBulkhead(@PathVariable("id") Integer id)
    {
        if(id == -4) throw new RuntimeException("----bulkhead id 不能-4");

        if(id == 9999)
        {
            try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
        }

        return "Hello, bulkhead! inputId:  "+id+" \t " + IdUtil.simpleUUID();
    }

    //Resilience4j ratelimit的例子
    @GetMapping(value = "/pay/ratelimit/{id}")
    public String myRatelimit(@PathVariable("id") Integer id){
        return "hello ,myRatelimit欢迎来到 inputID" + id +"\t" + IdUtil.simpleUUID();
    }
}
