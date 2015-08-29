package CSVManager;

import java.util.List;

/**
 * Created by Ангелин on 22.08.2015.
 */
public interface CSVWriter {
    void writeToFile(String fileName, List<Product> Data, boolean appendToFile);
    void writeToFileRandomData(String fileName, int lineValue);
}
