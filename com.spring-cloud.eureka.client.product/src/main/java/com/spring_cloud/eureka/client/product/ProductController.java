package com.spring_cloud.eureka.client.product;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RefreshScope // Value 로 가져온 설정값을 업데이트 해주기 위함
@RestController
public class ProductController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${message}")
    private String message;

    @GetMapping("/product")
    public String getProduct() {
        return "Product info : From port : " + serverPort + " [message : " + message + " ]";
    }
}
