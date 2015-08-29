package CSVManager;

import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by ������� on 29.08.2015.
 */
public class WriterCSVTest {

    @Test
    public void testWriteToFile() throws Exception {
        List<Product> list = new LinkedList<>();
        Product prod1 = new Product("kefir", "TM5", "B45", 10);
        Product prod2 = new Product("juice", "TM4", "C7", 21);
        Product prod3 = new Product("lime", "TM1", "A9", 5);
        list.add(prod1);
        list.add(prod2);
        list.add(prod3);
        WriterCSV wTest = new WriterCSV();
        wTest.writeToFile("Test file.csv", list, true);
    }
}