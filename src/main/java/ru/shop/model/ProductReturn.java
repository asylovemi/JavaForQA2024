package ru.shop.model;
import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "product_return")
public class ProductReturn {
    @Id
    private UUID id;
    private UUID orderId;
    private LocalDate date;
    private int quantity;
}

