package CSVManager;

import java.io.*;
import java.util.List;

/**
 * Created by Ангелин on 22.08.2015.
 */
public class Writer implements CSVWriter{
    @Override
    public void writeToFile(String fileName, List<Product> Data, boolean appendToFile) {
        File file = new File(fileName);
        try {
            PrintWriter write = new PrintWriter(file, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (file.exists()){ // Проверка существует ли файл, если существует дальше решаем добавлять в конец файла или перезаписать
            if (appendToFile == true){

            }

        }
        else{ // Если файла не сушествует зсоздаем новый и игнорируем значение appendToFile
            try {
                file.createNewFile();

                //...

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public void writeToFileRandomData(String fileName, int lineValue) {

    }
}
