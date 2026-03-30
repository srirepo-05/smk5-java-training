package com.example.itdept.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class HrConsumer {

    @Autowired
    private  DiscoveryClient discoveryClient;

    public String getLeave() {
        List<ServiceInstance> instances = discoveryClient.getInstances("HrDept");

        if(instances==null || instances.isEmpty()) {
            return "HR-Department is not available right now!";
        }

        ServiceInstance instance = instances.get(0);
        String url = instance.getUri()+"/leavestatus";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(url, String.class);

    }
}

