package ru.shop;

import ru.shop.exception.BadOrderCountException;
import ru.shop.modal.Customer;
import ru.shop.modal.Order;
import ru.shop.modal.Product;
import ru.shop.modal.ProductType;
import ru.shop.repository.CustomerRepository;
import ru.shop.repository.OrderRepository;
import ru.shop.repository.ProductRepository;
import ru.shop.service.CustomerService;
import ru.shop.service.OrderService;
import ru.shop.service.ProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static ru.shop.modal.ProductType.GOOD;
import static ru.shop.modal.ProductType.SERVICE;

public class Main {
    public static void main(String[] args) {
        CustomerRepository customerRepository = new CustomerRepository();
        OrderRepository orderRepository = new OrderRepository();
        ProductRepository productRepository = new ProductRepository();

        CustomerService customerService = new CustomerService(customerRepository);
        OrderService orderService = new OrderService(orderRepository);
        ProductService productService = new ProductService(productRepository);

        Customer customer1 = new Customer("1", "Ivan", "123456789", 30);
        Customer customer2 = new Customer("2", "Maria", "987654321", 25);
        Customer customer3 = new Customer("3", "Petr", "98762421", 20);
        customerService.save(customer1);
        customerService.save(customer2);
        customerService.save(customer3);

        Product product1 = new Product("1","Товар 1", 100, SERVICE);
        Product product2 = new Product("2", "Товар 2", 200, GOOD);
        Product product3 = new Product("2", "Товар 3", 300, SERVICE);
        productService.save(product1);
        productService.save(product2);
        productService.save(product3);

        try {
            orderService.add(customer1, product1, 2);
            orderService.add(customer3, product3, 3);
            orderService.add(customer2, product2, -1);
        } catch (BadOrderCountException e) {
            System.out.println("Ошибка при добавлении заказа: " + e.getMessage());
        }

        System.out.println("Количество заказчиков: " + customerService.findAll().size());
        System.out.println("Количество заказов всего: " + orderService.findAll().size());

        System.out.println("Количество заказов типа GOOD: " + productService.findByProductType(GOOD).size());
        System.out.println("Количество заказов типа SERVICE: " + productService.findByProductType(SERVICE).size());

        List<Order> orders = orderService.findAll();
        Map<String, Integer> ordersByCustomers = new HashMap<>();

        for (var order: orders) {
            var count = ordersByCustomers.get(order.customerId());
            if (count == null) {
                ordersByCustomers.put(order.customerId(), 1);
            } else {
                ordersByCustomers.put(order.customerId(), count + 1);
            }
        }
        for (Map.Entry<String, Integer> entry : ordersByCustomers.entrySet()) {
            System.out.println("ID покупателя: " + entry.getKey() + ", количество его заказов: " + entry.getValue());
        }

        Map<String, Long> sumByCustomers = new HashMap<>();

        for (var order: orders) {
            var amount = sumByCustomers.get(order.customerId());
            if (amount == null) {
                sumByCustomers.put(order.customerId(), order.amount());
            } else {
                sumByCustomers.put(order.customerId(), amount + order.amount());
            }
        }
        for (Map.Entry<String, Long> entry : sumByCustomers.entrySet()) {
            System.out.println("ID покупателя: " + entry.getKey() + ", его сумма для оплаты: " + entry.getValue());
        }
    }
}