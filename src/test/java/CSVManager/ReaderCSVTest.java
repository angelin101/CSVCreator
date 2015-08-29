package CSVManager;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Ангелин on 29.08.2015.
 */
public class ReaderCSVTest {

    @Test
    public void testReadFromFile() throws Exception {
        ReaderCSV test = new ReaderCSV();
        List<Product> list = test.readFromFile("Test file.csv");
        System.out.println(list.size());
        for (Product p : list){
            System.out.println(p);
        }
    }
}