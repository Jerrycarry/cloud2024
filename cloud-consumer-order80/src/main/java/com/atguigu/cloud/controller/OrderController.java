package com.atguigu.cloud.controller;

import com.atguigu.cloud.Enum.ResultData;
import com.atguigu.cloud.entities.PayDTO;
import jakarta.annotation.Resource;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;


/**
 * @author CaiBowen
 * @date 2024/4/17 10:01
 */

@RestController
public class OrderController {

    public static final String PaymentStv_URL="Http://cloud-payment-service";//不能写死,硬编码

    @Resource
    private RestTemplate restTemplate;

    /*增*/
    @GetMapping(value = "/consumer/pay/add")
    public ResultData addOrder(PayDTO payDTO){
        return restTemplate.postForObject(PaymentStv_URL+"/pay/add",payDTO,ResultData.class);
    }

    /*删*/
    @DeleteMapping(value = "consumer/pay/delete/{id}")
    public ResultData deleteOrder(@PathVariable("id") Integer id){
        return restTemplate.exchange(PaymentStv_URL+"/pay/delete/"+id, HttpMethod.DELETE,null,ResultData.class).getBody();
    }

    /*改*/
    @PutMapping(value = "consumer/pay/update")
    public ResultData updateOrder(@RequestBody PayDTO payDTO){
        return restTemplate.exchange(PaymentStv_URL+"/pay/update/",HttpMethod.PUT,new HttpEntity<>(payDTO),ResultData.class).getBody();
    }

    /*查*/
    @GetMapping(value = "/consumer/pay/get/{id}")
    public ResultData getPayInfo(@PathVariable("id") Integer id){
        return restTemplate.getForObject(PaymentStv_URL+"/pay/get/"+id,ResultData.class,id);
    }
    /*查询所有流水*/
    @GetMapping(value = "/consumer/pay/getAll")
    public ResultData getPayListInfo(){
        return restTemplate.getForObject(PaymentStv_URL+"/pay/getAll",ResultData.class);
    }

    @GetMapping(value = "/consumer/pay/get/info")
    public String getInfoByConsul(){
        return restTemplate.getForObject(PaymentStv_URL+"/pay/get/info",String.class);
    }
}
