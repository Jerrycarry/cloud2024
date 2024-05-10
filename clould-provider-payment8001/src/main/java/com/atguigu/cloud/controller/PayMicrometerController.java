package com.atguigu.cloud.controller;

import cn.hutool.core.util.IdUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @BelongsProject: cloud2024
 * @BelongsPackage: com.atguigu.cloud.controller
 * @Author: Jerry
 * @CreateTime: 2024-05-08  22:43
 * @Description: TODO
 * @Version: 1.0
 */
@RestController
public class PayMicrometerController {

    @GetMapping(value = "/pay/micrometer/{id}")
    public String mymicrometer(@PathVariable ("id") Integer id){
        return "Hello 欢迎来到myMicrometer InputId:" + id + "\t" + IdUtil.simpleUUID();
    }
}
