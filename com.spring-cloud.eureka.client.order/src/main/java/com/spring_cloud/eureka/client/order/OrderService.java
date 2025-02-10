package com.spring_cloud.eureka.client.order;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class OrderService {

    private final ProductClient productClient;

    public String getOrder(String orderId) {
        if ("1".equals(orderId)) {
            return "Not exist order...";
        }
        long inputId = Long.parseLong(orderId);
        long newId = 1 + inputId;

        String productInfo = getProductInto(String.valueOf(newId));
        return "Your Order is " + orderId + " and " + productInfo;
    }

    public String getProductInto(String productId) {
        // 외부 호출
        return productClient.getProduct(productId);
    }
}
