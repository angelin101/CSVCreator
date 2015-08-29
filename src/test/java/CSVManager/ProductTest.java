package CSVManager;

import org.junit.Test;

import java.util.Date;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 22.08.2015.
 */
public class ProductTest {

    @Test
    public void testCompareTo() throws Exception {
        Product prod1 = new Product("apple", "TM1", "B10", 6);
        Product prod2 = new Product("tomato", "TM2", "A10", 2);
        assertEquals(1, prod1.compareTo(prod2));
    }

    @Test
    public void testEquals() throws Exception {
        Product prod1 = new Product("apple", "TM1", "A12", 6);
        Product prod2 = new Product("tomato", "TM2", "A12", 2);
        assertTrue(prod1.equals(prod2));
    }

    @Test
    public void testHashCode() throws Exception {
        Product prod1 = new Product("apple", "TM1", "B12", 6);
        Product prod2 = new Product("tomato", "TM2", "B11", 2);
        assertTrue(prod1.hashCode() != prod2.hashCode());

    }
}