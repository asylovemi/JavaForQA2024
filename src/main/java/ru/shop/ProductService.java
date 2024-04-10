package ru.shop;

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

    public void findByProductType(ProductType type) {
        List<Product> oldList = findAll();
        List<Product> newList = new ArrayList<>();

        for (var i : oldList) {
            if (i.productType() == type) {
                newList.add(i);
            }
        }
    }
}
