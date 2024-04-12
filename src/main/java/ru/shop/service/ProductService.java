package ru.shop.service;

import ru.shop.modal.Product;
import ru.shop.modal.ProductType;
import ru.shop.repository.ProductRepository;

import java.util.ArrayList;
import java.util.List;

public class ProductService {
    private final ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void save(Product product){
        productRepository.save(product);
    }

    public List<Product> findAll(){
        return productRepository.findAll();
    };

    public List<Product> findByProductType(ProductType type) {
        List<Product> newList = new ArrayList<>();

        for (Product product : productRepository.findAll()) {
            if (product.productType() == type) {
                newList.add(product);
            }
        }

        return newList;
    }
}


