package CSVManager;

import org.junit.Test;

import java.util.List;

/**
 * Created by Ангелин on 29.08.2015.
 */
public class ReaderTest {

    @Test
    public void testReadFromFile() throws Exception {
        Reader test = new Reader();
        List<Product> list = test.readFromFile("Test random file.csv");
        System.out.println(list.size());
        for (Product p : list){
            System.out.println(p);
        }
    }
}