package ru.shop.service;

import ru.shop.exception.BadOrderCountException;
import ru.shop.modal.Customer;
import ru.shop.modal.Order;
import ru.shop.modal.Product;
import ru.shop.repository.OrderRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OrderService {
    OrderRepository orderRepository;

    public OrderService(OrderRepository orderRepository) {
        this.orderRepository = orderRepository;
    }

    public void add(Customer customer, Product product, int count) {
        if (count <= 0) {
            throw new BadOrderCountException("Количество товара в заказе должно быть больше нуля");
        }
        orderRepository.save(new Order(UUID.randomUUID().toString(), customer.id(), product.id(), count, count * product.cost()));
    }

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public List<Order> findByCustomer(Customer customer) {
        List<Order> newList = new ArrayList<>();

        for (Order order : orderRepository.findAll()) {
            if (order.customerId().equals(customer.id())) {
                newList.add(order);
            }
        }
        return newList;
    }

    public long getTotalCustomerAmount(Customer customer) {
        long totalAmount = 0;
        for (Order order : findByCustomer(customer)) {
            totalAmount += order.amount();
        }
        return totalAmount;
    }
}

