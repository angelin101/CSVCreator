package CSVManager;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by ������� on 22.08.2015.
 */
public interface Readable {
    List<Product> readFromFile(String fileName) throws FileNotFoundException;
}
