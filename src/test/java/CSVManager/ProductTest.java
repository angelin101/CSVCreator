package CSVManager;

import org.junit.Test;

import java.util.Collections;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

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

    @Test
    public void testSortedDataBy() throws Exception {
        Reader read = new Reader();
        List<Product> list = read.readFromFile("Test random file.csv");
        for (Product p : list){
            System.out.println(p);
        }
        System.out.println();
        Product.sortedDataBy(list, CompareType.BY_PRICE);
        for (Product p : list){
            System.out.println(p);
        }
        System.out.println();
        Product p1 = new Product("avakado", "Mars", "A12", 6);
        Product p2 = new Product("banana", "Chev", "A26", 15);
        Product p3 = new Product("lime", "Canada", "F35", 31);
        Product p4 = new Product("milk", "Zarechye", "C9", 9);
        List<Product> list1 = new LinkedList<>();
        list1.add(p1);
        list1.add(p2);
        list1.add(p3);
        list1.add(p4);
        Collections.shuffle(list1);
        for (Product p : list1){
            System.out.println(p);
        }
        System.out.println();
        Product.sortedDataBy(list1, CompareType.BY_TRADE_MARK);
        for (Product p : list1){
            System.out.println(p);
        }
    }
}