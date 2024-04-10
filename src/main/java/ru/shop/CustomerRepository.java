package ru.shop;


import java.util.ArrayList;
import java.util.List;

public class CustomerRepository {
    List<Customer> arrList = new ArrayList<>();

    public void save(Customer customer){
        arrList.add(customer);
    };
    public List<Customer> findAll(){
        return arrList;
    };
}
