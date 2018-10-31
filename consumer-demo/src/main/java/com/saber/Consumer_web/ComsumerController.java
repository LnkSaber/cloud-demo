package com.saber.Consumer_web;

import com.saber.Consumer_pojo.People;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("consumer")
public class ComsumerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("{id}")
    public People queryById(@PathVariable("id") Integer id){
        //根据服务id获取实例
        List<ServiceInstance> instances = discoveryClient.getInstances("user-service");
//        //从实例中取出ip地址和端口
//        ServiceInstance instance = instances.get(0);
//
//        String url="http://"+ instance.getHost() +":"+instance.getPort()+"/people/"+id;
        String url="http://user-service/people/"+id;
        People people= restTemplate.getForObject(url,People.class);
        System.out.println(url);
        return people;
    }
}
