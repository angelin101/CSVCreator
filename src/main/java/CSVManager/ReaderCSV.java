package CSVManager;

import java.io.*;
import java.util.LinkedList;
import java.util.List;


/**
 * Created by Ангелин on 22.08.2015.
 */
public class ReaderCSV implements Readable {

    @Override
    public List<Product> readFromFile(String fileName) throws FileNotFoundException {
        File file = new File(fileName);
        String line;
        List<Product> list = new LinkedList<>();
        try(BufferedReader read = new BufferedReader(new FileReader(file))) {
            while ((line = read.readLine()) != null){
                list.add(convertOneProduct(line));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }

    private Product convertOneProduct(String line){
        Product obj = new Product();
        String[] str = line.split(";");
        obj.setName(str[0]);
        obj.setTradeMark(str[1]);
        obj.setArticle(str[2]);
        obj.setPrice(Integer.parseInt(str[3]));
        return obj;
    }
}
