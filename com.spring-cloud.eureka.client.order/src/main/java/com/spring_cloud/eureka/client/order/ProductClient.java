package com.spring_cloud.eureka.client.order;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "product-service") // 설정파일에 추가한 서비스 이름으로 검색하여 요청
public interface ProductClient {

    // 외부 요청 : http://product-service/product/{id}
    @GetMapping("/product/{id}")
    String getProduct(@PathVariable("id") String id);
}
