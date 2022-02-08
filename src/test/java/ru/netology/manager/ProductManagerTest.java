package ru.netology.manager;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import ru.netology.domain.Book;
import ru.netology.domain.Product;
import ru.netology.domain.Smartphone;
import ru.netology.repository.ProductRepository;

import static org.junit.jupiter.api.Assertions.*;

class ProductManagerTest {
    static ProductRepository repo = new ProductRepository();
    static ProductManager manager = new ProductManager(repo);
    static Product phone1 = new Smartphone(1, "Samsung Galaxy S22", 100000, "Samsung");
    static Product phone2 = new Smartphone(2, "Iphone 13", 110000, "Apple");
    static Product phone3 = new Smartphone(3, "Huawei P50 Pro", 80000, "Huawei");
    static Product book1 = new Book(1, "Transhumanism inc", 800, "Victor Pelevin");
    static Product book2 = new Book(2, "The ritual", 600, "Adam Nevill");
    static Product book3 = new Book(3, "Lost Echoes", 700, "Joe Lansdale");

    @BeforeAll
    static void setUp() {
        manager.add(phone1);
        manager.add(phone2);
        manager.add(phone3);
        manager.add(book1);
        manager.add(book2);
        manager.add(book3);

    }

    @Test
    void shouldFindPhoneName() {
        Product[] expected = {phone2};
        Product[] actual = manager.searchBy("Iphone 13");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindPhoneManufacturer() {
        Product[] expected = {phone1};
        Product[] actual = manager.searchBy("Samsung");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookName() {
        Product[] expected = {book2};
        Product[] actual = manager.searchBy("The ritual");

        assertArrayEquals(expected, actual);
    }

    @Test
    void shouldFindBookAuthor() {
        Product[] expected = {book3};
        Product[] actual = manager.searchBy("Joe Lansdale");

        assertArrayEquals(expected, actual);
    }
}