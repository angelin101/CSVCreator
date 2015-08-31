package CSVManager;

import java.io.*;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.*;


/**
 * Created by Ангелин on 29.08.2015.
 */
public class Reader implements CSVReader {
    private File file;

    @Override
    public List<Product> readFromFile(String fileName) throws FileNotFoundException, InvalidNumberOfLinesException, IncorrectValueException{
        file = new File(fileName);
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
    // Метод конвертирующий одну строку в один обьект Product
    private Product convertOneProduct(String line) throws InvalidNumberOfLinesException, IncorrectValueException{
        Product obj = new Product();
        String[] str = line.split(";");
        if(str.length > 4){
            throw new InvalidNumberOfLinesException("\nВ файле "+file.getName()+", у продукта "+str[0]+" больше 4-х значений!");
        }
        else if(str.length < 4){
            throw new InvalidNumberOfLinesException("\nВ файле "+file.getName()+", у продукта "+str[0]+" меньше 4-х значений!");
        }
        for (int i = 0; i < 3; i++){
            if (testOnValidation(str[i])){
                throw new IncorrectValueException("\nВ файле "+file.getName()+", столбец № "+(i+1)+" содержит числовое значение!");
            }
        }
        obj.setName(str[0]);
        obj.setTradeMark(str[1]);
        obj.setArticle(str[2]);
        obj.setPrice(Integer.parseInt(str[3]));
        return obj;
    }

    // Внутренний метод проверяющий с помощью регулярных выражений строку на валидность, возвращает true если в строке одни числа!
    private boolean testOnValidation(String str){
        Pattern p = Pattern.compile("^\\d+$");
        Matcher m = p.matcher(str);
        return m.matches();
    }
}
