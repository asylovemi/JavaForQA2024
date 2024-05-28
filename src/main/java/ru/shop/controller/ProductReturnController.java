package ru.shop.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.shop.model.Customer;
import ru.shop.model.Order;
import ru.shop.model.Product;
import ru.shop.model.ProductReturn;
import ru.shop.service.OrderService;
import ru.shop.service.ProductReturnService;
import ru.shop.service.ProductService;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/product-return")
public class ProductReturnController {
    private final ProductReturnService productReturnService;

    @Autowired
    public ProductReturnController(ProductReturnService productReturnService) {
        this.productReturnService = productReturnService;
    }

    @GetMapping
    public List<ProductReturn> getAll() {
        return productReturnService.findAll();
    }

    @GetMapping("/{id}")
    public ProductReturn getById(@PathVariable UUID id) {
        return productReturnService.findById(id);
    }
}