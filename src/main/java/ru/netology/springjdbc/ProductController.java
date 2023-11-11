package ru.netology.springjdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
    private final ProductRepository productRepository;

    @Autowired
    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping("/hi")
    public String hi() {
        return "Hi";
    }
    @GetMapping("/hello")
    public String hello() {
        return "Hello, authenticated user";
    }

    @GetMapping("/products/fetch-product")
    public String fetchProductByName(@RequestParam String name) {
        String productName = productRepository.getProductName(name);
        return productName;
    }


}
