package ru.shop.modal;

public record Order(String id, String customerId, String productId, long count, long amount) {
}
