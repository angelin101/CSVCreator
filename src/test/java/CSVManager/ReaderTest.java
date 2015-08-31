package CSVManager;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertTrue;

/**
 * Created by Ангелин on 29.08.2015.
 */
public class ReaderTest {
    Reader test = new Reader();
    List<Product> list;

    @Test
    public void testReadFromFile() throws Exception {
        list = test.readFromFile("Test random file.csv");
        System.out.println(list.size());
        for (Product p : list){
            System.out.println(p);
        }
    }

    /*@Test
    public void testTestOnValidation() throws Exception {
        assertTrue(test.testOnValidation("01"));
    }*/
}