package ru.shop;

import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    List<Order> arrList = new ArrayList<>();

    public void save(Order order){
        arrList.add(order);
    };
    public List<Order> findAll(){
        return arrList;
    };
}
