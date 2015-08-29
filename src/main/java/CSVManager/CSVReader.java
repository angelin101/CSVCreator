package CSVManager;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Ангелин on 22.08.2015.
 */
public interface CSVReader {
    List<Product> readFromFile(String fileName) throws FileNotFoundException;
}
