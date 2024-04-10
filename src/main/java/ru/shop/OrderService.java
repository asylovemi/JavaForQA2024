package ru.shop;

import java.util.List;
import java.util.UUID;


public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(Customer customer, Product product, int count) {
        orderRepository.save(new Order(UUID.randomUUID().toString(), customer.id(), product.id(), count, count*product.cost()));
    }

    public class BadOrderCountException extends Exception {
        public BadOrderCountException(String message) {
            super(message);
        }

    public List<Order> findAll(){
        return orderRepository.findAll();
    };
}


}
