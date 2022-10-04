import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ProductRepositoryTest {
    Book item1 = new Book(1, "For Whom The Bells Tolls", 150, "Ernest Hemingway");
    Smartphone item2 = new Smartphone(2, "Xiaomi 12", 2000, "Xiaomi");
    Book item3 = new Book(3, "If Tomorrow Comes", 250, "Sidney Sheldon");
    Smartphone item4 = new Smartphone(2, "Honor 5d", 2000, "Honor");

    ProductRepository repository = new ProductRepository();

    @Test
    public void shouldGetItemsInZeroLengthRepository() {
        Product[] expected = new Product[0];
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddOne() {
        Product[] expected = {item1};
        repository.add(item1);
        Product[] actual = repository.getItems();

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldAddSomeAndGetItems() {
        Product[] expected = {item1, item2, item3, item4};
        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.add(item4);
        Product[] actual = repository.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfIdExist() {
        Product[] expected = {item1, item2, item4};
        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.add(item4);
        repository.removeById(3);
        Product[] actual = repository.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfIdNotExist() {
        Product[] expected = {item1, item2, item3, item4};
        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.add(item4);
        repository.removeById(0);
        Product[] actual = repository.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void shouldRemoveByIdIfIdExistAndNotUnique() {
        Product[] expected = {item1, item3};
        repository.add(item1);
        repository.add(item2);
        repository.add(item3);
        repository.add(item4);
        repository.removeById(2);
        Product[] actual = repository.getItems();
        Assertions.assertArrayEquals(expected, actual);
    }
}
