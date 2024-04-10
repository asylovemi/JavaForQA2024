package ru.shop;

import java.util.ArrayList;
import java.util.List;

public class ProductRepository {
    List<Product> arrList = new ArrayList<>();

    public void save(Product product){
        arrList.add(product);
    };
    public List<Product> findAll(){
        return arrList;
    };
}
