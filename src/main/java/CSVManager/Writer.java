package CSVManager;

import java.io.*;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Ангелин on 29.08.2015.
 */
public class Writer implements CSVWriter {
    private final String SEPARATOR = ";";
    private File file;
    private PrintWriter write;

    @Override
    public void writeToFile(String fileName, List<Product> Data, boolean appendToFile) throws FileNotFoundException{
        file = new File(fileName);
            write = new PrintWriter((new BufferedOutputStream(new FileOutputStream(file, appendToFile))), true);
            for (Product a : Data){
                write.println(recordOneProduct(a));
            }
            write.close();
    }

   // Приватный метод записывающий один обьект Product в строку и возвращает её
    private String recordOneProduct(Product obj){
        return obj.getName()+SEPARATOR+obj.getTradeMark()+SEPARATOR+obj.getArticle()+SEPARATOR+obj.getPrice();
    }

    @Override
    public void writeToFileRandomData(String fileName, int lineValue) throws FileNotFoundException {
        file = new File(fileName);
        write = new PrintWriter((new BufferedOutputStream(new FileOutputStream(file))), true);
        for (int i = 1; i <= lineValue; i++){
            write.println("Name"+i+SEPARATOR+"Trade Mark"+i+SEPARATOR+"Article"+i+SEPARATOR+(int)(Math.random()*100));
        }
    }
}
