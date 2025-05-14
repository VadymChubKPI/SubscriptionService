package controller;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProductClient {

    private final RestTemplate restTemplate = new RestTemplate();
    private final String baseUrl = "http://localhost:8081/api/products";

    public boolean existsByProductName(String productName) {
        try {
            Boolean result = restTemplate.getForObject(baseUrl + "/exists/" + productName, Boolean.class);
            return Boolean.TRUE.equals(result);
        } catch (Exception e) {
            return false;
        }
    }
}
