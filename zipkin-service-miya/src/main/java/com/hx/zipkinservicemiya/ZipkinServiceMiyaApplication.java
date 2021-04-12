package com.hx.zipkinservicemiya;

import brave.sampler.Sampler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
public class ZipkinServiceMiyaApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZipkinServiceMiyaApplication.class, args);
    }

    @Autowired
    RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate(){
        return new RestTemplate();
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
    
    @RequestMapping("/hi")
    public String home() {
        System.out.println("hi is being called");
        return "hi i am miya!";
    }
    
    @RequestMapping("/miya")
    public String info() {
        System.out.println("info is being called");
        return restTemplate.getForObject("http://localhost:8988/info", String.class);
    }
}
