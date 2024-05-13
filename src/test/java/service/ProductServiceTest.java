import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import ru.shop.exception.EntityNotFoundException;
import ru.shop.model.Product;
import ru.shop.model.ProductType;
import ru.shop.repository.ProductRepository;
import ru.shop.service.ProductService;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.when;

public class ProductServiceTest {
    private final ProductRepository repository = Mockito.mock();
    private final ProductService productService = new ProductService(repository);

    @Test
    public void shouldGetProduct() {
        // given
        UUID productId = UUID.randomUUID();
        //id name cost productType
        Product mockedProduct = new Product(productId, "name", 1000, ProductType.GOOD);
        when(repository.findById(productId)).thenReturn(Optional.of(mockedProduct));

        // when
        Product customer = productService.getById(productId);
        // then
        Assertions.assertEquals(mockedProduct, customer);
    }

    @Test
    public void shouldThrowWhenProductNotFound() {
        // then
        Assertions.assertThrows(
                EntityNotFoundException.class,
                () -> productService.getById(UUID.randomUUID())
        );
    }

}
