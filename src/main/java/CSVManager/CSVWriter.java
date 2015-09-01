package CSVManager;

import java.io.FileNotFoundException;
import java.util.List;

/**
 * Created by Ангелин on 22.08.2015.
 */
public interface CSVWriter {
    void writeToFile(String fileName, List<Product> data, boolean appendToFile) throws FileNotFoundException;
    void writeToFileRandomData(String fileName, int lineValue) throws FileNotFoundException;
}
